package com.athena.features.favorite.presentation.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FavoriteScreen(modifier: Modifier = Modifier) {
    Text("Favorite", modifier = modifier.padding(16.dp))
}