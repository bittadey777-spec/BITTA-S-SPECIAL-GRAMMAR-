package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.GrammarCurriculumRepository
import com.example.model.QuestionType
import com.example.model.QuizFilterMode
import com.example.model.TopicId
import com.example.model.TopicProgress
import com.example.ui.components.topicIcon
import com.example.ui.theme.CorrectGreen
import com.example.ui.theme.CorrectGreenSoft
import com.example.ui.theme.bengaliBodyStyle
import com.example.viewmodel.GrammarUiState

@Composable
fun QuizHubScreen(
    uiState: GrammarUiState,
    onSelectFilter: (QuizFilterMode) -> Unit,
    onStartTopicQuiz: (TopicId) -> Unit,
    onStartMixedChallenge: () -> Unit,
    modifier: Modifier = Modifier
) {
    val topics = GrammarCurriculumRepository.allTopics

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Column {
                Text(
                    text = "Practice & Quiz Hub",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                if (uiState.showBengaliHelpers) {
                    Text(
                        text = "MCQ ও শূন্যস্থান পূরণ কুইজ অনুশীলন করো — সাথে সাথে ব্যাখ্যা পাবে",
                        style = bengaliBodyStyle(sizeSp = 13),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        item {
            Card(
                shape = MaterialTheme.shapes.extraLarge,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.linearGradient(
                                colors = listOf(Color(0xFF4338CA), Color(0xFF6D28D9))
                            )
                        )
                        .padding(18.dp)
                ) {
                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Bolt,
                                contentDescription = null,
                                tint = Color(0xFFFDE047),
                                modifier = Modifier.size(22.dp)
                            )
                            Text(
                                text = "DAILY MIXED CHALLENGE",
                                style = MaterialTheme.typography.labelMedium,
                                color = Color(0xFFFDE047),
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "10 Random NCTB Exam Questions",
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.White
                        )
                        if (uiState.showBengaliHelpers) {
                            Text(
                                text = "সব অধ্যায় থেকে মিশ্র ১০টি প্রশ্ন • মডেল টেস্ট অনুশীলন",
                                style = bengaliBodyStyle(sizeSp = 13),
                                color = Color(0xFFE0E7FF),
                                modifier = Modifier.padding(top = 2.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(14.dp))
                        Button(
                            onClick = onStartMixedChallenge,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp)
                                .testTag("quizhub_mixed_challenge_btn"),
                            shape = RoundedCornerShape(14.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFFBBF24),
                                contentColor = Color(0xFF1E1B4B)
                            )
                        ) {
                            Text(
                                text = "Start Mixed Challenge (${uiState.totalMixedChallengesCompleted} Done)",
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }

        item {
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = "Question Mode / প্রশ্নের ধরন",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(QuizFilterMode.entries) { mode ->
                        FilterChip(
                            selected = uiState.selectedQuizFilter == mode,
                            onClick = { onSelectFilter(mode) },
                            modifier = Modifier
                                .minimumInteractiveComponentSize()
                                .testTag("quiz_filter_${mode.name.lowercase()}"),
                            label = {
                                Text(
                                    text = if (uiState.showBengaliHelpers) "${mode.labelEn} (${mode.labelBn})" else mode.labelEn,
                                    style = MaterialTheme.typography.labelMedium
                                )
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        )
                    }
                }
            }
        }

        items(topics, key = { it.name }) { topic ->
            val filteredQuestions = GrammarCurriculumRepository.getQuestionsForTopic(topic, uiState.selectedQuizFilter)
            val allQuestions = GrammarCurriculumRepository.getQuestionsForTopic(topic, QuizFilterMode.ALL)
            val mcqCount = allQuestions.count { it.type == QuestionType.MCQ }
            val blankCount = allQuestions.count { it.type == QuestionType.FILL_IN_BLANK }
            val progress = uiState.topicProgress[topic] ?: TopicProgress(topic)

            Card(
                shape = MaterialTheme.shapes.large,
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.7f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(RoundedCornerShape(14.dp))
                            .background(topic.accentColor.copy(alpha = 0.14f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = topicIcon(topic),
                            contentDescription = topic.titleEn,
                            tint = topic.accentColor,
                            modifier = Modifier.size(26.dp)
                        )
                    }

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = topic.titleEn,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        if (uiState.showBengaliHelpers) {
                            Text(
                                text = topic.titleBn,
                                style = bengaliBodyStyle(sizeSp = 13, bold = true),
                                color = topic.accentColor
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "$mcqCount MCQ • $blankCount Blank",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            if (progress.quizzesCompletedCount > 0) {
                                Surface(
                                    color = CorrectGreenSoft,
                                    shape = RoundedCornerShape(6.dp)
                                ) {
                                    Text(
                                        text = "Best: ${progress.bestScore}/${progress.quizTotalQuestions}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = CorrectGreen,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }
                            }
                        }
                    }

                    Button(
                        onClick = { onStartTopicQuiz(topic) },
                        enabled = filteredQuestions.isNotEmpty(),
                        modifier = Modifier
                            .height(48.dp)
                            .testTag("quizhub_start_${topic.name.lowercase()}"),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = topic.accentColor),
                        contentPadding = PaddingValues(horizontal = 14.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.PlayArrow,
                            contentDescription = "Start quiz",
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "${filteredQuestions.size}",
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }
            }
        }
    }
}
