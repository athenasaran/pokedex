package com.athena.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = Blue200,
    onPrimary = White,
    background = White,
    onBackground = Blue200
)

@Composable
fun PokedexTheme(
    isDarkModeAvailable: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if (isDarkModeAvailable) {
        LightColors
    } else {
        LightColors
    }

    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}

object PokedexTheme {
    val colors: Colors
        get() = Colors

    object Colors {
        val primary = LightColors.primary
        val onPrimary = LightColors.onPrimary
    }
}
