package com.example.data

import com.example.model.CompositionGuide
import com.example.model.GrammarRule
import com.example.model.QuizFilterMode
import com.example.model.QuizQuestion
import com.example.model.TopicId

object GrammarCurriculumRepository {

    val allTopics: List<TopicId> = TopicId.entries

    fun getRulesForTopic(topicId: TopicId): List<GrammarRule> = when (topicId) {
        TopicId.RIGHT_FORMS_OF_VERBS -> VerbAndNarrationData.verbRules
        TopicId.NARRATION -> VerbAndNarrationData.narrationRules
        TopicId.CHANGING_SENTENCES -> SentencesAndArticlesData.changingSentencesRules
        TopicId.ARTICLES_PREPOSITIONS -> SentencesAndArticlesData.articlesPrepositionsRules
        TopicId.COMPLETING_SUFFIX_PREFIX -> SuffixAndCompositionData.completingSuffixRules
        TopicId.COMPOSITION -> SuffixAndCompositionData.compositionRules
    }

    fun getQuestionsForTopic(
        topicId: TopicId,
        filterMode: QuizFilterMode = QuizFilterMode.ALL
    ): List<QuizQuestion> {
        val base = when (topicId) {
            TopicId.RIGHT_FORMS_OF_VERBS -> VerbAndNarrationData.verbQuestions
            TopicId.NARRATION -> VerbAndNarrationData.narrationQuestions
            TopicId.CHANGING_SENTENCES -> SentencesAndArticlesData.changingSentencesQuestions
            TopicId.ARTICLES_PREPOSITIONS -> SentencesAndArticlesData.articlesPrepositionsQuestions
            TopicId.COMPLETING_SUFFIX_PREFIX -> SuffixAndCompositionData.completingSuffixQuestions
            TopicId.COMPOSITION -> SuffixAndCompositionData.compositionQuestions
        }
        return when (filterMode) {
            QuizFilterMode.ALL -> base
            QuizFilterMode.MCQ_ONLY -> base.filter { it.type == com.example.model.QuestionType.MCQ }
            QuizFilterMode.BLANKS_ONLY -> base.filter { it.type == com.example.model.QuestionType.FILL_IN_BLANK }
        }
    }

    fun getMixedChallengeQuestions(limit: Int = 10): List<QuizQuestion> {
        val pool = allTopics.flatMap { getQuestionsForTopic(it, QuizFilterMode.ALL) }
        return pool.shuffled().take(limit)
    }

    fun getCompositionGuides(): List<CompositionGuide> = SuffixAndCompositionData.compositionGuides

    fun getCompositionGuideById(id: String): CompositionGuide? =
        SuffixAndCompositionData.compositionGuides.firstOrNull { it.id == id }
}
