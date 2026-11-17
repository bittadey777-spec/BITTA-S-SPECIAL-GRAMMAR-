package com.example.model

import androidx.compose.ui.graphics.Color
import com.example.ui.theme.TopicArticleColor
import com.example.ui.theme.TopicChangingColor
import com.example.ui.theme.TopicNarrationColor
import com.example.ui.theme.TopicSuffixColor
import com.example.ui.theme.TopicVerbColor
import com.example.ui.theme.TopicWritingColor

enum class TopicId(
    val titleEn: String,
    val titleBn: String,
    val subtitleEn: String,
    val subtitleBn: String,
    val accentColor: Color,
    val badgeLabel: String
) {
    RIGHT_FORMS_OF_VERBS(
        titleEn = "Right Forms of Verbs",
        titleBn = "ক্রিয়ার সঠিক রূপ",
        subtitleEn = "Tense, Subject-Verb Agreement & Modals",
        subtitleBn = "টেন্স, সাবজেক্ট-ভার্ব এবং মডাল ভার্বের নিয়ম",
        accentColor = TopicVerbColor,
        badgeLabel = "Unit 1"
    ),
    NARRATION(
        titleEn = "Narration (Speech)",
        titleBn = "উক্তি পরিবর্তন",
        subtitleEn = "Direct to Indirect & Indirect to Direct",
        subtitleBn = "প্রত্যক্ষ ও পরোক্ষ উক্তি পরিবর্তনের নিয়ম",
        accentColor = TopicNarrationColor,
        badgeLabel = "Unit 2"
    ),
    CHANGING_SENTENCES(
        titleEn = "Changing Sentences",
        titleBn = "বাক্য ও বাচ্য পরিবর্তন",
        subtitleEn = "Affirmative, Negative, Interrogative & Voice",
        subtitleBn = "হ্যাঁ-বোধক, না-বোধক, প্রশ্নবোধক ও ভয়েস চেঞ্জ",
        accentColor = TopicChangingColor,
        badgeLabel = "Unit 3"
    ),
    ARTICLES_PREPOSITIONS(
        titleEn = "Articles & Prepositions",
        titleBn = "আর্টিকেল ও প্রিপজিশন",
        subtitleEn = "A, An, The & Time/Place Prepositions",
        subtitleBn = "A/An/The এবং স্থান ও সময়ের প্রিপজিশন",
        accentColor = TopicArticleColor,
        badgeLabel = "Unit 4"
    ),
    COMPLETING_SUFFIX_PREFIX(
        titleEn = "Completing & Suffix-Prefix",
        titleBn = "বাক্য পূরণ ও উপসর্গ-প্রত্যয়",
        subtitleEn = "Clause Completion & Word Formation",
        subtitleBn = "অসম্পূর্ণ বাক্য পূরণ ও নতুন শব্দ গঠন",
        accentColor = TopicSuffixColor,
        badgeLabel = "Unit 5"
    ),
    COMPOSITION(
        titleEn = "Paragraph & Composition",
        titleBn = "প্যারাগ্রাফ ও রচনা নির্দেশিকা",
        subtitleEn = "Paragraph, Application, Dialogue & Essay",
        subtitleBn = "প্যারাগ্রাফ, দরখাস্ত, ডায়ালগ ও রচনা লেখার কৌশল",
        accentColor = TopicWritingColor,
        badgeLabel = "Bonus"
    )
}

data class GrammarExample(
    val sentenceEn: String,
    val sentenceBn: String,
    val focusNote: String
)

data class GrammarRule(
    val id: String,
    val topicId: TopicId,
    val ruleNumber: Int,
    val titleEn: String,
    val titleBn: String,
    val formula: String?,
    val explanationEn: String,
    val explanationBn: String,
    val examples: List<GrammarExample>
)

enum class QuestionType(val labelEn: String, val labelBn: String) {
    MCQ("Multiple Choice", "বহুনির্বাচনি"),
    FILL_IN_BLANK("Fill in the Blank", "শূন্যস্থান পূরণ")
}

enum class QuizFilterMode(val labelEn: String, val labelBn: String) {
    ALL("All Questions", "সব প্রশ্ন"),
    MCQ_ONLY("MCQ Only", "শুধু MCQ"),
    BLANKS_ONLY("Fill-in-Blanks", "শূন্যস্থান")
}

data class QuizQuestion(
    val id: String,
    val topicId: TopicId,
    val type: QuestionType,
    val promptEn: String,
    val promptBn: String,
    val options: List<String> = emptyList(),
    val correctAnswer: String,
    val acceptedAnswers: List<String> = listOf(correctAnswer),
    val hintBn: String? = null,
    val explanationEn: String,
    val explanationBn: String
)

data class CompositionGuide(
    val id: String,
    val categoryEn: String,
    val categoryBn: String,
    val titleEn: String,
    val titleBn: String,
    val structureStepsEn: List<String>,
    val structureStepsBn: List<String>,
    val keyVocabulary: List<Pair<String, String>>,
    val sampleTitle: String,
    val sampleText: String,
    val examTipsBn: String
)

data class TopicProgress(
    val topicId: TopicId,
    val completedRuleIds: Set<String> = emptySet(),
    val bestScore: Int = 0,
    val lastScore: Int = 0,
    val quizTotalQuestions: Int = 0,
    val quizzesCompletedCount: Int = 0
) {
    val bestAccuracyPercent: Int
        get() = if (quizTotalQuestions > 0) ((bestScore * 100f) / quizTotalQuestions).toInt().coerceIn(0, 100) else 0
}
