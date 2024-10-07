package com.athena.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun PokedexTheme(
    isDarkModeAvailable: Boolean = false,
    content: @Composable () -> Unit
) {
    if (isDarkModeAvailable.not()) {
        MaterialTheme(
            colorScheme = ColorPalette,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}
