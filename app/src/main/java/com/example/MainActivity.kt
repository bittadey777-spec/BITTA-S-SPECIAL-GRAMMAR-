package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.automirrored.outlined.MenuBook
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.outlined.BarChart
import androidx.compose.material.icons.outlined.EditNote
import androidx.compose.material.icons.outlined.Quiz
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.GrammarCurriculumRepository
import com.example.model.TopicProgress
import com.example.ui.screens.CompositionDetailScreen
import com.example.ui.screens.HomeLearnScreen
import com.example.ui.screens.ProgressScreen
import com.example.ui.screens.QuizHubScreen
import com.example.ui.screens.QuizPlayerScreen
import com.example.ui.screens.TopicLessonScreen
import com.example.ui.screens.WritingGuideScreen
import com.example.ui.theme.Grammar7Theme
import com.example.viewmodel.AppDestination
import com.example.viewmodel.GrammarViewModel
import com.example.viewmodel.MainTab

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Grammar7Theme {
                GrammarAppRoot()
            }
        }
    }
}

private fun tabIcons(tab: MainTab): Pair<ImageVector, ImageVector> = when (tab) {
    MainTab.LEARN -> Icons.AutoMirrored.Filled.MenuBook to Icons.AutoMirrored.Outlined.MenuBook
    MainTab.PRACTICE -> Icons.Filled.Quiz to Icons.Outlined.Quiz
    MainTab.WRITING -> Icons.Filled.EditNote to Icons.Outlined.EditNote
    MainTab.PROGRESS -> Icons.Filled.BarChart to Icons.Outlined.BarChart
}

@Composable
fun GrammarAppRoot(
    viewModel: GrammarViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    AnimatedContent(
        targetState = uiState.destination,
        transitionSpec = { fadeIn() togetherWith fadeOut() },
        label = "root_destination"
    ) { destination ->
        when (destination) {
            AppDestination.Home -> {
                BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
                    val useRail = maxWidth >= 680.dp

                    if (useRail) {
                        Scaffold(
                            contentWindowInsets = WindowInsets.safeDrawing,
                            containerColor = MaterialTheme.colorScheme.background
                        ) { innerPadding ->
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding)
                            ) {
                                NavigationRail(
                                    modifier = Modifier.fillMaxHeight(),
                                    containerColor = MaterialTheme.colorScheme.surface
                                ) {
                                    MainTab.entries.forEach { tab ->
                                        val selected = uiState.currentTab == tab
                                        val (selectedIcon, unselectedIcon) = tabIcons(tab)
                                        NavigationRailItem(
                                            selected = selected,
                                            onClick = { viewModel.selectTab(tab) },
                                            modifier = Modifier.testTag("nav_tab_${tab.name.lowercase()}"),
                                            icon = {
                                                Icon(
                                                    imageVector = if (selected) selectedIcon else unselectedIcon,
                                                    contentDescription = tab.titleEn
                                                )
                                            },
                                            label = {
                                                Text(
                                                    text = if (uiState.showBengaliHelpers) tab.titleBn else tab.titleEn,
                                                    style = MaterialTheme.typography.labelSmall
                                                )
                                            }
                                        )
                                    }
                                }
                                Box(modifier = Modifier.weight(1f)) {
                                    HomeTabContent(uiState.currentTab, viewModel, uiState)
                                }
                            }
                        }
                    } else {
                        Scaffold(
                            contentWindowInsets = WindowInsets.safeDrawing,
                            containerColor = MaterialTheme.colorScheme.background,
                            bottomBar = {
                                NavigationBar(
                                    containerColor = MaterialTheme.colorScheme.surface
                                ) {
                                    MainTab.entries.forEach { tab ->
                                        val selected = uiState.currentTab == tab
                                        val (selectedIcon, unselectedIcon) = tabIcons(tab)
                                        NavigationBarItem(
                                            selected = selected,
                                            onClick = { viewModel.selectTab(tab) },
                                            modifier = Modifier.testTag("nav_tab_${tab.name.lowercase()}"),
                                            icon = {
                                                Icon(
                                                    imageVector = if (selected) selectedIcon else unselectedIcon,
                                                    contentDescription = tab.titleEn
                                                )
                                            },
                                            label = {
                                                Text(
                                                    text = if (uiState.showBengaliHelpers) tab.titleBn else tab.titleEn,
                                                    style = MaterialTheme.typography.labelSmall
                                                )
                                            }
                                        )
                                    }
                                }
                            }
                        ) { innerPadding ->
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding)
                            ) {
                                HomeTabContent(uiState.currentTab, viewModel, uiState)
                            }
                        }
                    }
                }
            }

            is AppDestination.TopicLesson -> {
                val topicProgress = uiState.topicProgress[destination.topicId]
                    ?: TopicProgress(destination.topicId)
                TopicLessonScreen(
                    topicId = destination.topicId,
                    progress = topicProgress,
                    showBengali = uiState.showBengaliHelpers,
                    onToggleBengali = { viewModel.toggleBengaliHelpers(it) },
                    onToggleRuleCompleted = { ruleId ->
                        viewModel.toggleRuleCompleted(destination.topicId, ruleId)
                    },
                    onStartQuiz = { viewModel.startTopicQuiz(destination.topicId) },
                    onOpenWritingTab = { viewModel.selectTab(MainTab.WRITING) },
                    onBack = { viewModel.navigateBack() }
                )
            }

            is AppDestination.QuizSession -> {
                val activeQuiz = uiState.activeQuiz
                if (activeQuiz != null) {
                    QuizPlayerScreen(
                        quizState = activeQuiz,
                        showBengali = uiState.showBengaliHelpers,
                        onSelectMcq = { viewModel.selectMcqOption(it) },
                        onUpdateBlank = { viewModel.updateBlankInput(it) },
                        onToggleHint = { viewModel.toggleHint() },
                        onSubmitAnswer = { viewModel.submitAnswer() },
                        onNextQuestion = { viewModel.nextQuestionOrFinish() },
                        onRetryQuiz = { viewModel.retryQuiz() },
                        onOpenRules = activeQuiz.topicId?.let { topic ->
                            { viewModel.openTopicLesson(topic) }
                        },
                        onBack = { viewModel.navigateBack() }
                    )
                }
            }

            is AppDestination.CompositionDetail -> {
                val guide = GrammarCurriculumRepository.getCompositionGuideById(destination.guideId)
                if (guide != null) {
                    CompositionDetailScreen(
                        guide = guide,
                        showBengali = uiState.showBengaliHelpers,
                        onBack = { viewModel.navigateBack() }
                    )
                }
            }
        }
    }
}

@Composable
private fun HomeTabContent(
    currentTab: MainTab,
    viewModel: GrammarViewModel,
    uiState: com.example.viewmodel.GrammarUiState
) {
    when (currentTab) {
        MainTab.LEARN -> HomeLearnScreen(
            uiState = uiState,
            onToggleBengali = { viewModel.toggleBengaliHelpers(it) },
            onOpenTopicLesson = { viewModel.openTopicLesson(it) },
            onStartTopicQuiz = { viewModel.startTopicQuiz(it) },
            onStartMixedChallenge = { viewModel.startMixedChallenge() }
        )
        MainTab.PRACTICE -> QuizHubScreen(
            uiState = uiState,
            onSelectFilter = { viewModel.setQuizFilter(it) },
            onStartTopicQuiz = { viewModel.startTopicQuiz(it) },
            onStartMixedChallenge = { viewModel.startMixedChallenge() }
        )
        MainTab.WRITING -> WritingGuideScreen(
            showBengali = uiState.showBengaliHelpers,
            onOpenGuide = { viewModel.openCompositionGuide(it) },
            onStartWritingQuiz = { viewModel.startTopicQuiz(com.example.model.TopicId.COMPOSITION) }
        )
        MainTab.PROGRESS -> ProgressScreen(
            uiState = uiState,
            onToggleBengali = { viewModel.toggleBengaliHelpers(it) },
            onResetProgress = { viewModel.resetAllProgress() }
        )
    }
}
