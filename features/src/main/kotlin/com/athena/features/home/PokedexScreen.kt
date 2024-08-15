package com.athena.features.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PokedexScreen(modifier: Modifier = Modifier) {
    Text("Pokedex", modifier = modifier.padding(16.dp))
}