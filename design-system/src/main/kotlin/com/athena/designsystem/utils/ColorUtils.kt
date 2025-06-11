package com.athena.designsystem.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.palette.graphics.Palette
import coil3.Bitmap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun extractDominantColorFromBitmap(bitmap: Bitmap): Color {
    return withContext(Dispatchers.Default) {
        val palette = Palette.from(bitmap).generate()
        val mutedColor = palette.getMutedColor(palette.getDominantColor(Color.Gray.toArgb()))
        return@withContext Color(mutedColor)
    }
}