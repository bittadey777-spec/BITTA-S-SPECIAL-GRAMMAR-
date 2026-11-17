package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.Quiz
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.GrammarCurriculumRepository
import com.example.model.TopicId
import com.example.model.TopicProgress
import com.example.ui.components.BilingualToggleChip
import com.example.ui.components.RuleStudyCard
import com.example.ui.theme.bengaliBodyStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopicLessonScreen(
    topicId: TopicId,
    progress: TopicProgress,
    showBengali: Boolean,
    onToggleBengali: (Boolean) -> Unit,
    onToggleRuleCompleted: (String) -> Unit,
    onStartQuiz: () -> Unit,
    onOpenWritingTab: () -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler(onBack = onBack)

    val rules = GrammarCurriculumRepository.getRulesForTopic(topicId)
    val questionsCount = GrammarCurriculumRepository.getQuestionsForTopic(topicId).size
    val completedCount = progress.completedRuleIds.size
    val ratio = if (rules.isNotEmpty()) completedCount.toFloat() / rules.size else 0f

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = topicId.titleEn,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        if (showBengali) {
                            Text(
                                text = topicId.titleBn,
                                style = bengaliBodyStyle(sizeSp = 12, bold = true),
                                color = topicId.accentColor
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier.testTag("lesson_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back to topics"
                        )
                    }
                },
                actions = {
                    BilingualToggleChip(
                        showBengali = showBengali,
                        onToggle = onToggleBengali,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .widthIn(max = 720.dp)
                    .fillMaxWidth(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                item {
                    Surface(
                        color = topicId.accentColor.copy(alpha = 0.09f),
                        shape = MaterialTheme.shapes.large,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Lesson Progress: $completedCount/${rules.size} Rules",
                                    style = MaterialTheme.typography.labelLarge,
                                    color = topicId.accentColor,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "${(ratio * 100).toInt()}%",
                                    style = MaterialTheme.typography.labelLarge,
                                    color = topicId.accentColor,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            LinearProgressIndicator(
                                progress = { ratio },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(8.dp)
                                    .clip(CircleShape),
                                color = topicId.accentColor,
                                trackColor = topicId.accentColor.copy(alpha = 0.2f),
                                strokeCap = StrokeCap.Round
                            )
                            if (showBengali) {
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "প্রতিটি নিয়ম পড়ে 'Done' বাটনে ট্যাপ করলে তোমার অগ্রগতি সেভ হয়ে থাকবে।",
                                    style = bengaliBodyStyle(sizeSp = 12),
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }

                items(rules, key = { it.id }) { rule ->
                    RuleStudyCard(
                        rule = rule,
                        accentColor = topicId.accentColor,
                        isCompleted = progress.completedRuleIds.contains(rule.id),
                        showBengali = showBengali,
                        onToggleCompleted = { onToggleRuleCompleted(rule.id) }
                    )
                }

                if (topicId == TopicId.COMPOSITION) {
                    item {
                        OutlinedButton(
                            onClick = onOpenWritingTab,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .testTag("open_sample_models_button"),
                            shape = RoundedCornerShape(14.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.EditNote,
                                contentDescription = null,
                                tint = topicId.accentColor
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "View Model Paragraphs, Applications & Dialogues",
                                color = topicId.accentColor
                            )
                        }
                    }
                }

                item {
                    Card(
                        shape = MaterialTheme.shapes.large,
                        colors = CardDefaults.cardColors(containerColor = topicId.accentColor.copy(alpha = 0.1f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(18.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Ready to Test Yourself?",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            if (showBengali) {
                                Text(
                                    text = "এবার $questionsCount-টি প্রশ্নের কুইজে অংশ নিয়ে নিজের দক্ষতা যাচাই করো!",
                                    style = bengaliBodyStyle(sizeSp = 13),
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.padding(top = 4.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                            Button(
                                onClick = onStartQuiz,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .testTag("lesson_start_quiz_button"),
                                shape = RoundedCornerShape(14.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = topicId.accentColor)
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Quiz,
                                    contentDescription = null,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Start Topic Quiz ($questionsCount Questions)",
                                    style = MaterialTheme.typography.labelLarge
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
