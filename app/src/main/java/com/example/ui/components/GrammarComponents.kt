package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.Extension
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.model.GrammarRule
import com.example.model.TopicId
import com.example.model.TopicProgress
import com.example.ui.theme.CorrectGreen
import com.example.ui.theme.CorrectGreenSoft
import com.example.ui.theme.bengaliBodyStyle

fun topicIcon(topicId: TopicId): ImageVector = when (topicId) {
    TopicId.RIGHT_FORMS_OF_VERBS -> Icons.Filled.AutoAwesome
    TopicId.NARRATION -> Icons.Filled.FormatQuote
    TopicId.CHANGING_SENTENCES -> Icons.Filled.SwapHoriz
    TopicId.ARTICLES_PREPOSITIONS -> Icons.AutoMirrored.Filled.MenuBook
    TopicId.COMPLETING_SUFFIX_PREFIX -> Icons.Filled.Extension
    TopicId.COMPOSITION -> Icons.Filled.EditNote
}

@Composable
fun BilingualToggleChip(
    showBengali: Boolean,
    onToggle: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    FilterChip(
        selected = showBengali,
        onClick = { onToggle(!showBengali) },
        modifier = modifier
            .minimumInteractiveComponentSize()
            .testTag("toggle_bengali_chip"),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Translate,
                contentDescription = "Toggle Bengali explanations",
                modifier = Modifier.size(16.dp)
            )
        },
        label = {
            Text(
                text = if (showBengali) "বাংলা সহায়িকা: চালু" else "EN Only",
                style = if (showBengali) bengaliBodyStyle(sizeSp = 12, bold = true) else MaterialTheme.typography.labelMedium
            )
        },
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer,
            selectedLeadingIconColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Composable
fun TopicCard(
    topicId: TopicId,
    totalRules: Int,
    totalQuestions: Int,
    progress: TopicProgress,
    showBengali: Boolean,
    onOpenLesson: () -> Unit,
    onStartQuiz: () -> Unit,
    modifier: Modifier = Modifier
) {
    val studiedCount = progress.completedRuleIds.size
    val ruleFraction by animateFloatAsState(
        targetValue = if (totalRules > 0) studiedCount.toFloat() / totalRules else 0f,
        animationSpec = spring(),
        label = "topic_progress"
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("topic_card_${topicId.name.lowercase()}"),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.65f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .clickable(onClick = onOpenLesson)
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(RoundedCornerShape(14.dp))
                            .background(topicId.accentColor.copy(alpha = 0.14f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = topicIcon(topicId),
                            contentDescription = topicId.titleEn,
                            tint = topicId.accentColor,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    Surface(
                        color = topicId.accentColor.copy(alpha = 0.12f),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = topicId.badgeLabel,
                            style = MaterialTheme.typography.labelSmall,
                            color = topicId.accentColor,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }

                if (progress.quizzesCompletedCount > 0) {
                    Surface(
                        color = CorrectGreenSoft,
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Text(
                            text = "Best ${progress.bestAccuracyPercent}%",
                            style = MaterialTheme.typography.labelSmall,
                            color = CorrectGreen,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = topicId.titleEn,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            AnimatedVisibility(visible = showBengali) {
                Text(
                    text = topicId.titleBn,
                    style = bengaliBodyStyle(sizeSp = 14, bold = true),
                    color = topicId.accentColor,
                    modifier = Modifier.padding(top = 2.dp)
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = if (showBengali) topicId.subtitleBn else topicId.subtitleEn,
                style = if (showBengali) bengaliBodyStyle(sizeSp = 12) else MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$studiedCount/$totalRules Rules • $totalQuestions Quiz Qs",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "${(ruleFraction * 100).toInt()}%",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = topicId.accentColor
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            LinearProgressIndicator(
                progress = { ruleFraction },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(7.dp)
                    .clip(CircleShape),
                color = topicId.accentColor,
                trackColor = topicId.accentColor.copy(alpha = 0.14f),
                strokeCap = StrokeCap.Round
            )

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                OutlinedButton(
                    onClick = onOpenLesson,
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                        .testTag("btn_lesson_${topicId.name.lowercase()}"),
                    shape = RoundedCornerShape(12.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp),
                    border = BorderStroke(1.dp, topicId.accentColor.copy(alpha = 0.45f))
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.MenuBook,
                        contentDescription = null,
                        tint = topicId.accentColor,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Rules",
                        style = MaterialTheme.typography.labelLarge,
                        color = topicId.accentColor
                    )
                }

                Button(
                    onClick = onStartQuiz,
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                        .testTag("btn_quiz_${topicId.name.lowercase()}"),
                    shape = RoundedCornerShape(12.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = topicId.accentColor)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Quiz,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Quiz",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}

@Composable
fun RuleStudyCard(
    rule: GrammarRule,
    accentColor: Color,
    isCompleted: Boolean,
    showBengali: Boolean,
    onToggleCompleted: () -> Unit,
    modifier: Modifier = Modifier
) {
    val borderColor by animateColorAsState(
        targetValue = if (isCompleted) CorrectGreen.copy(alpha = 0.6f) else MaterialTheme.colorScheme.outline.copy(alpha = 0.7f),
        label = "rule_border"
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("rule_card_${rule.id}"),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.2.dp, borderColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(34.dp)
                            .clip(CircleShape)
                            .background(if (isCompleted) CorrectGreen else accentColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "${rule.ruleNumber}",
                            style = MaterialTheme.typography.labelLarge,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Column {
                        Text(
                            text = rule.titleEn,
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        if (showBengali) {
                            Text(
                                text = rule.titleBn,
                                style = bengaliBodyStyle(sizeSp = 14, bold = true),
                                color = accentColor
                            )
                        }
                    }
                }

                Surface(
                    onClick = onToggleCompleted,
                    shape = RoundedCornerShape(12.dp),
                    color = if (isCompleted) CorrectGreenSoft else MaterialTheme.colorScheme.surfaceVariant,
                    modifier = Modifier
                        .minimumInteractiveComponentSize()
                        .testTag("toggle_rule_${rule.id}")
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = if (isCompleted) Icons.Filled.CheckCircle else Icons.Outlined.CheckCircle,
                            contentDescription = if (isCompleted) "Marked as studied" else "Mark as studied",
                            tint = if (isCompleted) CorrectGreen else MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(18.dp)
                        )
                        Text(
                            text = if (isCompleted) "Done" else "Study",
                            style = MaterialTheme.typography.labelSmall,
                            color = if (isCompleted) CorrectGreen else MaterialTheme.colorScheme.onSurfaceVariant,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            rule.formula?.let { formula ->
                Spacer(modifier = Modifier.height(12.dp))
                Surface(
                    color = accentColor.copy(alpha = 0.09f),
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(1.dp, accentColor.copy(alpha = 0.25f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.PlayArrow,
                            contentDescription = null,
                            tint = accentColor,
                            modifier = Modifier.size(18.dp)
                        )
                        Text(
                            text = formula,
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = rule.explanationEn,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            AnimatedVisibility(visible = showBengali) {
                Surface(
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            text = "সহজ বাংলায় নিয়ম:",
                            style = bengaliBodyStyle(sizeSp = 12, bold = true),
                            color = accentColor
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = rule.explanationBn,
                            style = bengaliBodyStyle(sizeSp = 14),
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }

            if (rule.examples.isNotEmpty()) {
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Examples / উদাহরণ:",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(6.dp))
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    rule.examples.forEach { example ->
                        Surface(
                            color = MaterialTheme.colorScheme.background,
                            shape = RoundedCornerShape(12.dp),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.6f)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(
                                    text = example.sentenceEn,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                if (showBengali) {
                                    Text(
                                        text = example.sentenceBn,
                                        style = bengaliBodyStyle(sizeSp = 13),
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.padding(top = 3.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.height(6.dp))
                                Surface(
                                    color = accentColor.copy(alpha = 0.12f),
                                    shape = RoundedCornerShape(6.dp)
                                ) {
                                    Text(
                                        text = "Key: ${example.focusNote}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = accentColor,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
