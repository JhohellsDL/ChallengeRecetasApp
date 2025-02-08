package com.example.challengerecetasapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val darkColorScheme = darkColorScheme(
    primary = Primary,
    onPrimary = OnPrimary,
    secondary = Warning,
    onSecondary = OnSecondary,
    background = DarkSurface,
    onBackground = LightBackground,
    surface = DarkBackground,
    onSurface = LightBackground,
    error = ErrorDark,
    onError = OnPrimary
)


private val lightColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = DeepMidnightBlue,
    secondary = Secondary,
    onSecondary = OnSecondary,
    background = LightBackground,
    onBackground = DarkBackground,
    surface = Silver,
    onSurface = DarkBackground,
    error = Error,
    onError = OnPrimary
)


@Composable
fun EasyRecipesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) darkColorScheme else lightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}