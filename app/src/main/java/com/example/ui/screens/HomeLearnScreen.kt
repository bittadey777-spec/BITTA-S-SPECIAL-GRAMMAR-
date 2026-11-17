package com.example.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.data.GrammarCurriculumRepository
import com.example.model.TopicId
import com.example.model.TopicProgress
import com.example.ui.components.BilingualToggleChip
import com.example.ui.components.TopicCard
import com.example.ui.theme.MarigoldSecondary
import com.example.ui.theme.bengaliBodyStyle
import com.example.viewmodel.GrammarUiState

@Composable
fun HomeLearnScreen(
    uiState: GrammarUiState,
    onToggleBengali: (Boolean) -> Unit,
    onOpenTopicLesson: (TopicId) -> Unit,
    onStartTopicQuiz: (TopicId) -> Unit,
    onStartMixedChallenge: () -> Unit,
    modifier: Modifier = Modifier
) {
    val topics = GrammarCurriculumRepository.allTopics

    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        val isWide = maxWidth >= 640.dp
        val columns = if (isWide) 2 else 1

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.School,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(20.dp)
                            )
                            Text(
                                text = "NCTB • Class 7 English Grammar",
                                style = MaterialTheme.typography.labelLarge,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Text(
                            text = stringResource(R.string.app_name),
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.testTag("home_app_title")
                        )
                        Text(
                            text = stringResource(R.string.app_slogan_bn),
                            style = bengaliBodyStyle(sizeSp = 14, bold = true),
                            color = MaterialTheme.colorScheme.secondary,
                            modifier = Modifier.testTag("home_app_slogan")
                        )
                    }

                    BilingualToggleChip(
                        showBengali = uiState.showBengaliHelpers,
                        onToggle = onToggleBengali
                    )
                }
            }

            item {
                HeroBannerCard(
                    rulesCompleted = uiState.totalRulesCompleted,
                    totalRules = uiState.totalRulesCount,
                    quizzesCompleted = uiState.totalQuizzesCompleted,
                    showBengali = uiState.showBengaliHelpers,
                    onStartMixedChallenge = onStartMixedChallenge
                )
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Grammar & Writing Units",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        if (uiState.showBengaliHelpers) {
                            Text(
                                text = "নিয়ম পড়ো এবং সাথে সাথে কুইজে অংশ নাও",
                                style = bengaliBodyStyle(sizeSp = 13),
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                    Surface(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = "${topics.size} Units",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            val rows = topics.chunked(columns)
            items(rows.size) { rowIndex ->
                val rowTopics = rows[rowIndex]
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    rowTopics.forEach { topic ->
                        val rulesCount = GrammarCurriculumRepository.getRulesForTopic(topic).size
                        val questionsCount = GrammarCurriculumRepository.getQuestionsForTopic(topic).size
                        val topicProgress = uiState.topicProgress[topic] ?: TopicProgress(topic)
                        TopicCard(
                            topicId = topic,
                            totalRules = rulesCount,
                            totalQuestions = questionsCount,
                            progress = topicProgress,
                            showBengali = uiState.showBengaliHelpers,
                            onOpenLesson = { onOpenTopicLesson(topic) },
                            onStartQuiz = { onStartTopicQuiz(topic) },
                            modifier = Modifier.weight(1f)
                        )
                    }
                    if (rowTopics.size == 1 && columns == 2) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(8.dp)) }
        }
    }
}

@Composable
private fun HeroBannerCard(
    rulesCompleted: Int,
    totalRules: Int,
    quizzesCompleted: Int,
    showBengali: Boolean,
    onStartMixedChallenge: () -> Unit
) {
    val progressRatio = if (totalRules > 0) rulesCompleted.toFloat() / totalRules else 0f

    Card(
        shape = MaterialTheme.shapes.extraLarge,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.img_hero_banner),
                contentDescription = "Class 7 English Grammar study banner",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .matchParentSize()
            )
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color(0xCC013C2C),
                                Color(0xEB004D38)
                            )
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp)
            ) {
                Surface(
                    color = MarigoldSecondary,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "CLASS 7 MASTER TRACK",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Learn Grammar Smarter!",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                if (showBengali) {
                    Text(
                        text = "সহজ বাংলা ব্যাখ্যা ও কুইজের মাধ্যমে প্রস্তুতি নাও",
                        style = bengaliBodyStyle(sizeSp = 13),
                        color = Color(0xFFE2F7EE)
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "$rulesCompleted of $totalRules Rules Studied",
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.White
                    )
                    Text(
                        text = "$quizzesCompleted Quizzes Done",
                        style = MaterialTheme.typography.labelMedium,
                        color = Color(0xFFFDE68A),
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                LinearProgressIndicator(
                    progress = { progressRatio },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(CircleShape),
                    color = Color(0xFFFBBF24),
                    trackColor = Color.White.copy(alpha = 0.25f),
                    strokeCap = StrokeCap.Round
                )

                Spacer(modifier = Modifier.height(14.dp))

                Button(
                    onClick = onStartMixedChallenge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .testTag("hero_mixed_challenge_button"),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF59E0B),
                        contentColor = Color(0xFF1F1600)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Filled.Bolt,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (showBengali) "Mixed Quiz Challenge (১০টি প্রশ্ন)" else "Start 10-Question Mixed Quiz",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
