package com.athena.features.favorite.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.athena.designsystem.R
import com.athena.designsystem.components.error.DefaultErrorContent

@Composable
fun FavoriteScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        DefaultErrorContent(
            imageError = R.drawable.img_not_found_favorite,
            title = "You haven't favorited any Pokémon :( ",
            modifier = modifier,
            subTitle = "Click on the heart icon of your favorite Pokémon and they will appear here."
        )
    }
}