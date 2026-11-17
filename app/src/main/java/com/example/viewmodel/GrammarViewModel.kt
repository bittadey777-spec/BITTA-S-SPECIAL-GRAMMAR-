package com.example.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.GrammarCurriculumRepository
import com.example.data.ProgressDataStore
import com.example.model.QuizFilterMode
import com.example.model.QuizQuestion
import com.example.model.TopicId
import com.example.model.TopicProgress
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

enum class MainTab(val titleEn: String, val titleBn: String) {
    LEARN("Topics", "অধ্যায়"),
    PRACTICE("Quiz Hub", "অনুশীলন"),
    WRITING("Writing", "রচনা"),
    PROGRESS("Progress", "অগ্রগতি")
}

sealed interface AppDestination {
    data object Home : AppDestination
    data class TopicLesson(val topicId: TopicId) : AppDestination
    data class QuizSession(val topicId: TopicId?, val filterMode: QuizFilterMode) : AppDestination
    data class CompositionDetail(val guideId: String) : AppDestination
}

data class ActiveQuizState(
    val topicId: TopicId?, // null indicates Daily Mixed Challenge
    val titleEn: String,
    val titleBn: String,
    val filterMode: QuizFilterMode,
    val questions: List<QuizQuestion>,
    val currentIndex: Int = 0,
    val selectedOption: String? = null,
    val blankInput: String = "",
    val isSubmitted: Boolean = false,
    val isCurrentCorrect: Boolean = false,
    val showHint: Boolean = false,
    val score: Int = 0,
    val currentStreak: Int = 0,
    val bestStreakInRun: Int = 0,
    val isFinished: Boolean = false,
    val answeredCorrectIds: Set<String> = emptySet()
) {
    val currentQuestion: QuizQuestion?
        get() = questions.getOrNull(currentIndex)
}

data class GrammarUiState(
    val currentTab: MainTab = MainTab.LEARN,
    val destination: AppDestination = AppDestination.Home,
    val topicProgress: Map<TopicId, TopicProgress> = TopicId.entries.associateWith { TopicProgress(it) },
    val showBengaliHelpers: Boolean = true,
    val totalMixedChallengesCompleted: Int = 0,
    val selectedQuizFilter: QuizFilterMode = QuizFilterMode.ALL,
    val activeQuiz: ActiveQuizState? = null
) {
    val totalRulesCount: Int
        get() = TopicId.entries.sumOf { GrammarCurriculumRepository.getRulesForTopic(it).size }

    val totalRulesCompleted: Int
        get() = topicProgress.values.sumOf { it.completedRuleIds.size }

    val totalQuizzesCompleted: Int
        get() = topicProgress.values.sumOf { it.quizzesCompletedCount } + totalMixedChallengesCompleted

    val overallAverageAccuracyPercent: Int
        get() {
            val attempted = topicProgress.values.filter { it.quizTotalQuestions > 0 }
            if (attempted.isEmpty()) return 0
            return attempted.map { it.bestAccuracyPercent }.average().toInt()
        }
}

class GrammarViewModel(application: Application) : AndroidViewModel(application) {

    private val progressDataStore = ProgressDataStore(application.applicationContext)

    private val _uiState = MutableStateFlow(GrammarUiState())
    val uiState: StateFlow<GrammarUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            progressDataStore.progressFlow.collect { stored ->
                _uiState.update { state ->
                    state.copy(
                        topicProgress = stored.topicProgress,
                        showBengaliHelpers = stored.showBengaliHelpers,
                        totalMixedChallengesCompleted = stored.totalChallengesCompleted
                    )
                }
            }
        }
    }

    fun selectTab(tab: MainTab) {
        _uiState.update {
            it.copy(
                currentTab = tab,
                destination = AppDestination.Home,
                activeQuiz = null
            )
        }
    }

    fun openTopicLesson(topicId: TopicId) {
        _uiState.update {
            it.copy(destination = AppDestination.TopicLesson(topicId))
        }
    }

    fun openCompositionGuide(guideId: String) {
        _uiState.update {
            it.copy(destination = AppDestination.CompositionDetail(guideId))
        }
    }

    fun setQuizFilter(filterMode: QuizFilterMode) {
        _uiState.update { it.copy(selectedQuizFilter = filterMode) }
    }

    fun startTopicQuiz(topicId: TopicId, filterMode: QuizFilterMode = _uiState.value.selectedQuizFilter) {
        val questions = GrammarCurriculumRepository.getQuestionsForTopic(topicId, filterMode)
        if (questions.isEmpty()) return
        _uiState.update {
            it.copy(
                destination = AppDestination.QuizSession(topicId, filterMode),
                activeQuiz = ActiveQuizState(
                    topicId = topicId,
                    titleEn = topicId.titleEn,
                    titleBn = topicId.titleBn,
                    filterMode = filterMode,
                    questions = questions
                )
            )
        }
    }

    fun startMixedChallenge() {
        val questions = GrammarCurriculumRepository.getMixedChallengeQuestions(limit = 10)
        _uiState.update {
            it.copy(
                destination = AppDestination.QuizSession(null, QuizFilterMode.ALL),
                activeQuiz = ActiveQuizState(
                    topicId = null,
                    titleEn = "Mixed NCTB Challenge",
                    titleBn = "সমন্বিত চ্যালেঞ্জ কুইজ",
                    filterMode = QuizFilterMode.ALL,
                    questions = questions
                )
            )
        }
    }

    fun navigateBack() {
        _uiState.update {
            it.copy(
                destination = AppDestination.Home,
                activeQuiz = null
            )
        }
    }

    fun toggleRuleCompleted(topicId: TopicId, ruleId: String) {
        viewModelScope.launch {
            progressDataStore.toggleRuleCompleted(topicId, ruleId)
        }
    }

    fun selectMcqOption(option: String) {
        _uiState.update { state ->
            val quiz = state.activeQuiz ?: return@update state
            if (quiz.isSubmitted) return@update state
            state.copy(activeQuiz = quiz.copy(selectedOption = option))
        }
    }

    fun updateBlankInput(text: String) {
        _uiState.update { state ->
            val quiz = state.activeQuiz ?: return@update state
            if (quiz.isSubmitted) return@update state
            state.copy(activeQuiz = quiz.copy(blankInput = text))
        }
    }

    fun toggleHint() {
        _uiState.update { state ->
            val quiz = state.activeQuiz ?: return@update state
            state.copy(activeQuiz = quiz.copy(showHint = !quiz.showHint))
        }
    }

    fun submitAnswer() {
        val currentState = _uiState.value
        val quiz = currentState.activeQuiz ?: return
        val question = quiz.currentQuestion ?: return
        if (quiz.isSubmitted) return

        val isCorrect = when (question.type) {
            com.example.model.QuestionType.MCQ -> {
                quiz.selectedOption == question.correctAnswer
            }
            com.example.model.QuestionType.FILL_IN_BLANK -> {
                val cleaned = quiz.blankInput.trim()
                cleaned.isNotEmpty() && question.acceptedAnswers.any {
                    it.equals(cleaned, ignoreCase = true)
                }
            }
        }

        val newScore = if (isCorrect) quiz.score + 1 else quiz.score
        val newStreak = if (isCorrect) quiz.currentStreak + 1 else 0
        val newBestStreak = maxOf(quiz.bestStreakInRun, newStreak)
        val newAnsweredSet = if (isCorrect) quiz.answeredCorrectIds + question.id else quiz.answeredCorrectIds

        _uiState.update {
            it.copy(
                activeQuiz = quiz.copy(
                    isSubmitted = true,
                    isCurrentCorrect = isCorrect,
                    score = newScore,
                    currentStreak = newStreak,
                    bestStreakInRun = newBestStreak,
                    answeredCorrectIds = newAnsweredSet
                )
            )
        }
    }

    fun nextQuestionOrFinish() {
        val quiz = _uiState.value.activeQuiz ?: return
        val nextIndex = quiz.currentIndex + 1
        if (nextIndex >= quiz.questions.size) {
            _uiState.update {
                it.copy(activeQuiz = quiz.copy(isFinished = true))
            }
            viewModelScope.launch {
                progressDataStore.saveQuizResult(
                    topicId = quiz.topicId,
                    score = quiz.score,
                    totalQuestions = quiz.questions.size
                )
            }
        } else {
            _uiState.update {
                it.copy(
                    activeQuiz = quiz.copy(
                        currentIndex = nextIndex,
                        selectedOption = null,
                        blankInput = "",
                        isSubmitted = false,
                        isCurrentCorrect = false,
                        showHint = false
                    )
                )
            }
        }
    }

    fun retryQuiz() {
        val quiz = _uiState.value.activeQuiz ?: return
        val refreshedQuestions = if (quiz.topicId == null) {
            GrammarCurriculumRepository.getMixedChallengeQuestions(limit = 10)
        } else {
            quiz.questions
        }
        _uiState.update {
            it.copy(
                activeQuiz = ActiveQuizState(
                    topicId = quiz.topicId,
                    titleEn = quiz.titleEn,
                    titleBn = quiz.titleBn,
                    filterMode = quiz.filterMode,
                    questions = refreshedQuestions
                )
            )
        }
    }

    fun toggleBengaliHelpers(enabled: Boolean) {
        viewModelScope.launch {
            progressDataStore.setShowBengaliHelpers(enabled)
        }
    }

    fun resetAllProgress() {
        viewModelScope.launch {
            progressDataStore.resetAllProgress()
        }
    }
}
