package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

private val LightColorScheme = lightColorScheme(
    primary = EmeraldPrimary,
    onPrimary = EmeraldOnPrimary,
    primaryContainer = EmeraldPrimaryContainer,
    onPrimaryContainer = EmeraldOnPrimaryContainer,
    secondary = MarigoldSecondary,
    onSecondary = MarigoldOnSecondary,
    secondaryContainer = MarigoldSecondaryContainer,
    onSecondaryContainer = MarigoldOnSecondaryContainer,
    tertiary = IndigoTertiary,
    onTertiary = IndigoOnTertiary,
    tertiaryContainer = IndigoTertiaryContainer,
    onTertiaryContainer = IndigoOnTertiaryContainer,
    background = WarmIvoryBackground,
    onBackground = InkOnBackground,
    surface = WarmSurface,
    onSurface = InkOnBackground,
    surfaceVariant = WarmSurfaceVariant,
    onSurfaceVariant = MutedInk,
    outline = OutlineSubtle,
    error = WrongRose,
    errorContainer = WrongRoseSoft
)

private val DarkColorScheme = darkColorScheme(
    primary = EmeraldDarkPrimary,
    onPrimary = EmeraldDarkOnPrimary,
    primaryContainer = EmeraldDarkContainer,
    onPrimaryContainer = EmeraldDarkOnContainer,
    secondary = MarigoldSecondaryContainer,
    onSecondary = MarigoldOnSecondaryContainer,
    secondaryContainer = DarkSecondaryContainer,
    onSecondaryContainer = MarigoldSecondaryContainer,
    tertiary = IndigoTertiaryContainer,
    onTertiary = IndigoOnTertiaryContainer,
    background = DarkCanvas,
    onBackground = DarkOnBackground,
    surface = DarkSurface,
    onSurface = DarkOnBackground,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkMutedInk,
    outline = DarkOutline,
    error = DarkError,
    errorContainer = DarkErrorContainer
)

private val GrammarShapes = Shapes(
    small = RoundedCornerShape(10.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(22.dp),
    extraLarge = RoundedCornerShape(28.dp)
)

@Composable
fun Grammar7Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = GrammarTypography,
        shapes = GrammarShapes,
        content = content
    )
}
