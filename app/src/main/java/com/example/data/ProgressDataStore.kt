package com.example.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.model.TopicId
import com.example.model.TopicProgress
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.json.JSONArray
import org.json.JSONObject

private val Context.grammarDataStore: DataStore<Preferences> by preferencesDataStore(name = "grammar7_local_progress")

data class StoredAppProgress(
    val topicProgress: Map<TopicId, TopicProgress>,
    val showBengaliHelpers: Boolean,
    val totalChallengesCompleted: Int
)

class ProgressDataStore(private val context: Context) {

    private val keyProgressJson = stringPreferencesKey("topic_progress_json")
    private val keyShowBengali = booleanPreferencesKey("show_bengali_helpers")
    private val keyMixedCompleted = intPreferencesKey("mixed_challenges_completed")

    val progressFlow: Flow<StoredAppProgress> = context.grammarDataStore.data.map { prefs ->
        val jsonText = prefs[keyProgressJson]
        val map = parseProgressMap(jsonText)
        StoredAppProgress(
            topicProgress = map,
            showBengaliHelpers = prefs[keyShowBengali] ?: true,
            totalChallengesCompleted = prefs[keyMixedCompleted] ?: 0
        )
    }

    suspend fun toggleRuleCompleted(topicId: TopicId, ruleId: String) {
        context.grammarDataStore.edit { prefs ->
            val current = parseProgressMap(prefs[keyProgressJson]).toMutableMap()
            val existing = current[topicId] ?: TopicProgress(topicId)
            val updatedRules = existing.completedRuleIds.toMutableSet()
            if (updatedRules.contains(ruleId)) {
                updatedRules.remove(ruleId)
            } else {
                updatedRules.add(ruleId)
            }
            current[topicId] = existing.copy(completedRuleIds = updatedRules)
            prefs[keyProgressJson] = serializeProgressMap(current)
        }
    }

    suspend fun saveQuizResult(topicId: TopicId?, score: Int, totalQuestions: Int) {
        context.grammarDataStore.edit { prefs ->
            if (topicId == null) {
                val prev = prefs[keyMixedCompleted] ?: 0
                prefs[keyMixedCompleted] = prev + 1
            } else {
                val current = parseProgressMap(prefs[keyProgressJson]).toMutableMap()
                val existing = current[topicId] ?: TopicProgress(topicId)
                val newBest = maxOf(existing.bestScore, score)
                val newTotal = maxOf(existing.quizTotalQuestions, totalQuestions)
                current[topicId] = existing.copy(
                    bestScore = newBest,
                    lastScore = score,
                    quizTotalQuestions = newTotal,
                    quizzesCompletedCount = existing.quizzesCompletedCount + 1
                )
                prefs[keyProgressJson] = serializeProgressMap(current)
            }
        }
    }

    suspend fun setShowBengaliHelpers(enabled: Boolean) {
        context.grammarDataStore.edit { prefs ->
            prefs[keyShowBengali] = enabled
        }
    }

    suspend fun resetAllProgress() {
        context.grammarDataStore.edit { prefs ->
            prefs.remove(keyProgressJson)
            prefs.remove(keyMixedCompleted)
        }
    }

    private fun parseProgressMap(jsonText: String?): Map<TopicId, TopicProgress> {
        val result = TopicId.entries.associateWith { TopicProgress(it) }.toMutableMap()
        if (jsonText.isNullOrBlank()) return result
        return try {
            val root = JSONObject(jsonText)
            for (topic in TopicId.entries) {
                val obj = root.optJSONObject(topic.name) ?: continue
                val rulesArray = obj.optJSONArray("completedRuleIds") ?: JSONArray()
                val ruleSet = buildSet {
                    for (i in 0 until rulesArray.length()) {
                        add(rulesArray.getString(i))
                    }
                }
                result[topic] = TopicProgress(
                    topicId = topic,
                    completedRuleIds = ruleSet,
                    bestScore = obj.optInt("bestScore", 0),
                    lastScore = obj.optInt("lastScore", 0),
                    quizTotalQuestions = obj.optInt("quizTotalQuestions", 0),
                    quizzesCompletedCount = obj.optInt("quizzesCompletedCount", 0)
                )
            }
            result
        } catch (_: Exception) {
            result
        }
    }

    private fun serializeProgressMap(map: Map<TopicId, TopicProgress>): String {
        val root = JSONObject()
        for ((topic, progress) in map) {
            val obj = JSONObject()
            val arr = JSONArray()
            progress.completedRuleIds.forEach { arr.put(it) }
            obj.put("completedRuleIds", arr)
            obj.put("bestScore", progress.bestScore)
            obj.put("lastScore", progress.lastScore)
            obj.put("quizTotalQuestions", progress.quizTotalQuestions)
            obj.put("quizzesCompletedCount", progress.quizzesCompletedCount)
            root.put(topic.name, obj)
        }
        return root.toString()
    }
}
