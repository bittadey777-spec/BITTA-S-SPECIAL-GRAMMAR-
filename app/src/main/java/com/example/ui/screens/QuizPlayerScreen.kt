package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.model.QuestionType
import com.example.model.QuizQuestion
import com.example.ui.theme.CorrectGreen
import com.example.ui.theme.CorrectGreenSoft
import com.example.ui.theme.HintAmber
import com.example.ui.theme.HintAmberSoft
import com.example.ui.theme.WrongRose
import com.example.ui.theme.WrongRoseSoft
import com.example.ui.theme.bengaliBodyStyle
import com.example.viewmodel.ActiveQuizState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizPlayerScreen(
    quizState: ActiveQuizState,
    showBengali: Boolean,
    onSelectMcq: (String) -> Unit,
    onUpdateBlank: (String) -> Unit,
    onToggleHint: () -> Unit,
    onSubmitAnswer: () -> Unit,
    onNextQuestion: () -> Unit,
    onRetryQuiz: () -> Unit,
    onOpenRules: (() -> Unit)?,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler(onBack = onBack)

    val accent = quizState.topicId?.accentColor ?: MaterialTheme.colorScheme.tertiary

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = quizState.titleEn,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        if (showBengali) {
                            Text(
                                text = quizState.titleBn,
                                style = bengaliBodyStyle(sizeSp = 12, bold = true),
                                color = accent
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier.testTag("quiz_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Exit quiz"
                        )
                    }
                },
                actions = {
                    Surface(
                        color = accent.copy(alpha = 0.14f),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.padding(end = 12.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.LocalFireDepartment,
                                contentDescription = "Score",
                                tint = accent,
                                modifier = Modifier.size(16.dp)
                            )
                            Text(
                                text = "${quizState.score}/${quizState.questions.size}",
                                style = MaterialTheme.typography.labelLarge,
                                color = accent,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.TopCenter
        ) {
            if (quizState.isFinished) {
                QuizSummaryContent(
                    quizState = quizState,
                    accent = accent,
                    showBengali = showBengali,
                    onRetry = onRetryQuiz,
                    onOpenRules = onOpenRules,
                    onBack = onBack
                )
            } else {
                val question = quizState.currentQuestion ?: return@Box
                ActiveQuestionContent(
                    quizState = quizState,
                    question = question,
                    accent = accent,
                    showBengali = showBengali,
                    onSelectMcq = onSelectMcq,
                    onUpdateBlank = onUpdateBlank,
                    onToggleHint = onToggleHint,
                    onSubmitAnswer = onSubmitAnswer,
                    onNextQuestion = onNextQuestion
                )
            }
        }
    }
}

@Composable
private fun ActiveQuestionContent(
    quizState: ActiveQuizState,
    question: QuizQuestion,
    accent: Color,
    showBengali: Boolean,
    onSelectMcq: (String) -> Unit,
    onUpdateBlank: (String) -> Unit,
    onToggleHint: () -> Unit,
    onSubmitAnswer: () -> Unit,
    onNextQuestion: () -> Unit
) {
    val total = quizState.questions.size
    val progress = (quizState.currentIndex + 1).toFloat() / total.coerceAtLeast(1)

    Column(
        modifier = Modifier
            .widthIn(max = 680.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Question ${quizState.currentIndex + 1} of $total",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Surface(
                color = accent.copy(alpha = 0.12f),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = if (showBengali) "${question.type.labelEn} • ${question.type.labelBn}" else question.type.labelEn,
                    style = MaterialTheme.typography.labelSmall,
                    color = accent,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }

        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(CircleShape),
            color = accent,
            trackColor = accent.copy(alpha = 0.15f),
            strokeCap = StrokeCap.Round
        )

        Card(
            shape = MaterialTheme.shapes.large,
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.7f)),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                if (showBengali) {
                    Text(
                        text = question.promptBn,
                        style = bengaliBodyStyle(sizeSp = 14, bold = true),
                        color = accent
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                }
                Text(
                    text = question.promptEn,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    lineHeight = MaterialTheme.typography.titleLarge.lineHeight
                )
            }
        }

        when (question.type) {
            QuestionType.MCQ -> {
                val labels = listOf("A", "B", "C", "D")
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    question.options.forEachIndexed { index, option ->
                        val isSelected = quizState.selectedOption == option
                        val isCorrectOption = option == question.correctAnswer

                        val containerColor by animateColorAsState(
                            targetValue = when {
                                quizState.isSubmitted && isCorrectOption -> CorrectGreenSoft
                                quizState.isSubmitted && isSelected && !isCorrectOption -> WrongRoseSoft
                                isSelected -> accent.copy(alpha = 0.12f)
                                else -> MaterialTheme.colorScheme.surface
                            },
                            label = "mcq_bg"
                        )

                        val borderColor by animateColorAsState(
                            targetValue = when {
                                quizState.isSubmitted && isCorrectOption -> CorrectGreen
                                quizState.isSubmitted && isSelected && !isCorrectOption -> WrongRose
                                isSelected -> accent
                                else -> MaterialTheme.colorScheme.outline
                            },
                            label = "mcq_border"
                        )

                        Surface(
                            shape = MaterialTheme.shapes.medium,
                            color = containerColor,
                            border = BorderStroke(if (isSelected || (quizState.isSubmitted && isCorrectOption)) 2.dp else 1.dp, borderColor),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(MaterialTheme.shapes.medium)
                                .clickable(enabled = !quizState.isSubmitted) { onSelectMcq(option) }
                                .testTag("mcq_option_$index")
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 14.dp, vertical = 14.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(32.dp)
                                        .clip(CircleShape)
                                        .background(
                                            when {
                                                quizState.isSubmitted && isCorrectOption -> CorrectGreen
                                                quizState.isSubmitted && isSelected && !isCorrectOption -> WrongRose
                                                isSelected -> accent
                                                else -> MaterialTheme.colorScheme.surfaceVariant
                                            }
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = labels.getOrElse(index) { "${index + 1}" },
                                        style = MaterialTheme.typography.labelLarge,
                                        color = if (isSelected || (quizState.isSubmitted && isCorrectOption)) {
                                            Color.White
                                        } else {
                                            MaterialTheme.colorScheme.onSurfaceVariant
                                        },
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                                Text(
                                    text = option,
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.weight(1f)
                                )

                                if (quizState.isSubmitted && isCorrectOption) {
                                    Icon(
                                        imageVector = Icons.Filled.CheckCircle,
                                        contentDescription = "Correct option",
                                        tint = CorrectGreen
                                    )
                                } else if (quizState.isSubmitted && isSelected && !isCorrectOption) {
                                    Icon(
                                        imageVector = Icons.Filled.Close,
                                        contentDescription = "Incorrect option",
                                        tint = WrongRose
                                    )
                                }
                            }
                        }
                    }
                }
            }

            QuestionType.FILL_IN_BLANK -> {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    OutlinedTextField(
                        value = quizState.blankInput,
                        onValueChange = onUpdateBlank,
                        enabled = !quizState.isSubmitted,
                        singleLine = true,
                        label = { Text("Type your answer / উত্তর লেখো") },
                        placeholder = { Text("e.g., ${question.correctAnswer.take(1)}...") },
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                if (!quizState.isSubmitted && quizState.blankInput.isNotBlank()) {
                                    onSubmitAnswer()
                                }
                            }
                        ),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("fill_blank_input")
                    )

                    if (!quizState.isSubmitted && !question.hintBn.isNullOrBlank()) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            TextButton(
                                onClick = onToggleHint,
                                modifier = Modifier.testTag("toggle_hint_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Lightbulb,
                                    contentDescription = "Hint",
                                    tint = HintAmber,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = if (quizState.showHint) "Hide Hint" else "Show Hint (ইঙ্গিত)",
                                    color = HintAmber
                                )
                            }
                        }

                        AnimatedVisibility(visible = quizState.showHint) {
                            Surface(
                                color = HintAmberSoft,
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = question.hintBn,
                                    style = bengaliBodyStyle(sizeSp = 13, bold = true),
                                    color = HintAmber,
                                    modifier = Modifier.padding(12.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        AnimatedVisibility(
            visible = quizState.isSubmitted,
            enter = fadeIn() + slideInVertically { it / 4 }
        ) {
            val isCorrect = quizState.isCurrentCorrect
            Card(
                shape = MaterialTheme.shapes.large,
                colors = CardDefaults.cardColors(
                    containerColor = if (isCorrect) CorrectGreenSoft else WrongRoseSoft
                ),
                border = BorderStroke(1.5.dp, if (isCorrect) CorrectGreen else WrongRose),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("quiz_feedback_card")
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = if (isCorrect) Icons.Filled.CheckCircle else Icons.Filled.Close,
                            contentDescription = null,
                            tint = if (isCorrect) CorrectGreen else WrongRose
                        )
                        Text(
                            text = if (isCorrect) "Correct! / সঠিক হয়েছে!" else "Incorrect! / সঠিক উত্তর দেখো:",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = if (isCorrect) CorrectGreen else WrongRose
                        )
                    }

                    if (!isCorrect) {
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "Correct Answer: ${question.correctAnswer}",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = question.explanationEn,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFF1F2937)
                    )
                    if (showBengali) {
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "বাংলা ব্যাখ্যা: ${question.explanationBn}",
                            style = bengaliBodyStyle(sizeSp = 14),
                            color = Color(0xFF111827)
                        )
                    }
                }
            }
        }

        val canSubmit = when (question.type) {
            QuestionType.MCQ -> quizState.selectedOption != null
            QuestionType.FILL_IN_BLANK -> quizState.blankInput.isNotBlank()
        }

        if (!quizState.isSubmitted) {
            Button(
                onClick = onSubmitAnswer,
                enabled = canSubmit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .testTag("submit_answer_button"),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = accent)
            ) {
                Text(
                    text = if (showBengali) "Check Answer / উত্তর যাচাই করো" else "Check Answer",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        } else {
            val isLast = quizState.currentIndex == quizState.questions.lastIndex
            Button(
                onClick = onNextQuestion,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .testTag("next_question_button"),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = accent)
            ) {
                Text(
                    text = if (isLast) "Finish & View Score" else "Next Question",
                    style = MaterialTheme.typography.labelLarge
                )
                Spacer(modifier = Modifier.width(6.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Composable
private fun QuizSummaryContent(
    quizState: ActiveQuizState,
    accent: Color,
    showBengali: Boolean,
    onRetry: () -> Unit,
    onOpenRules: (() -> Unit)?,
    onBack: () -> Unit
) {
    val total = quizState.questions.size.coerceAtLeast(1)
    val percent = ((quizState.score * 100f) / total).toInt()
    val praiseEn = when {
        percent >= 80 -> "Outstanding Work!"
        percent >= 60 -> "Good Job! Keep Practicing!"
        else -> "Nice Effort! Review the Rules"
    }
    val praiseBn = when {
        percent >= 80 -> "দারুণ করেছ! তুমি এই অধ্যায়টি খুব ভালোভাবে শিখেছ।"
        percent >= 60 -> "ভালো হয়েছে! আরেকটু অনুশীলন করলে ১০০% পাবে।"
        else -> "চেষ্টা চালিয়ে যাও! নিয়মগুলো আরেকবার দেখে নিলে সহজ হয়ে যাবে।"
    }

    Column(
        modifier = Modifier
            .widthIn(max = 560.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_quiz_trophy),
            contentDescription = "Quiz completion trophy",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(28.dp))
        )

        Text(
            text = praiseEn,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        if (showBengali) {
            Text(
                text = praiseBn,
                style = bengaliBodyStyle(sizeSp = 15),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
        }

        Card(
            shape = MaterialTheme.shapes.extraLarge,
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SummaryStatColumn(label = "Score", value = "${quizState.score}/$total", color = accent)
                SummaryStatColumn(label = "Accuracy", value = "$percent%", color = CorrectGreen)
                SummaryStatColumn(label = "Best Streak", value = "${quizState.bestStreakInRun}", color = HintAmber)
            }
        }

        Button(
            onClick = onRetry,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .testTag("quiz_retry_button"),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(containerColor = accent)
        ) {
            Icon(imageVector = Icons.Filled.Refresh, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Retry Quiz / আবার চেষ্টা করো", style = MaterialTheme.typography.labelLarge)
        }

        if (onOpenRules != null) {
            OutlinedButton(
                onClick = onOpenRules,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .testTag("quiz_review_rules_button"),
                shape = RoundedCornerShape(14.dp)
            ) {
                Text("Review Lesson Rules / নিয়ম দেখো", style = MaterialTheme.typography.labelLarge)
            }
        }

        TextButton(
            onClick = onBack,
            modifier = Modifier.testTag("quiz_finish_back_button")
        ) {
            Text("Back to Topics", style = MaterialTheme.typography.labelLarge)
        }
    }
}

@Composable
private fun SummaryStatColumn(label: String, value: String, color: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = color
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
