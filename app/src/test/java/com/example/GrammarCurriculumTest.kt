package com.example

import com.example.data.GrammarCurriculumRepository
import com.example.model.QuestionType
import com.example.model.QuizFilterMode
import com.example.model.TopicId
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class GrammarCurriculumTest {

    @Test
    fun allSixTopicsHaveRulesAndQuestions() {
        for (topic in TopicId.entries) {
            val rules = GrammarCurriculumRepository.getRulesForTopic(topic)
            val questions = GrammarCurriculumRepository.getQuestionsForTopic(topic)
            assertTrue("Expected rules for $topic", rules.isNotEmpty())
            assertTrue("Expected questions for $topic", questions.isNotEmpty())
        }
    }

    @Test
    fun verbsAndNarrationHaveTenQuestionsEach() {
        assertEquals(10, GrammarCurriculumRepository.getQuestionsForTopic(TopicId.RIGHT_FORMS_OF_VERBS).size)
        assertEquals(10, GrammarCurriculumRepository.getQuestionsForTopic(TopicId.NARRATION).size)
    }

    @Test
    fun everyQuestionHasValidAnswerAndBilingualExplanation() {
        for (topic in TopicId.entries) {
            val questions = GrammarCurriculumRepository.getQuestionsForTopic(topic)
            for (q in questions) {
                assertTrue("Explanation EN blank for ${q.id}", q.explanationEn.isNotBlank())
                assertTrue("Explanation BN blank for ${q.id}", q.explanationBn.isNotBlank())
                if (q.type == QuestionType.MCQ) {
                    assertTrue("MCQ options missing correctAnswer for ${q.id}", q.options.contains(q.correctAnswer))
                } else {
                    assertTrue("Fill-in-blank missing acceptedAnswers for ${q.id}", q.acceptedAnswers.isNotEmpty())
                }
            }
        }
    }

    @Test
    fun filterModesReturnMatchingTypes() {
        val mcqOnly = GrammarCurriculumRepository.getQuestionsForTopic(TopicId.RIGHT_FORMS_OF_VERBS, QuizFilterMode.MCQ_ONLY)
        val blanksOnly = GrammarCurriculumRepository.getQuestionsForTopic(TopicId.RIGHT_FORMS_OF_VERBS, QuizFilterMode.BLANKS_ONLY)
        assertTrue(mcqOnly.all { it.type == QuestionType.MCQ })
        assertTrue(blanksOnly.all { it.type == QuestionType.FILL_IN_BLANK })
        assertEquals(10, mcqOnly.size + blanksOnly.size)
    }
}
