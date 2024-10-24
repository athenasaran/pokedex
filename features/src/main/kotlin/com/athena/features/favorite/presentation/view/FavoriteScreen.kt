package com.athena.features.favorite.presentation.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.athena.designsystem.R
import com.athena.designsystem.components.error.DefaultErrorContent

@Composable
fun FavoriteScreen(modifier: Modifier = Modifier) {
    DefaultErrorContent(
        imageError = R.drawable.img_not_found_favorite,
        title = "You haven't favorited any Pokémon :( ",
        modifier = modifier,
        subTitle = "Click on the heart icon of your favorite Pokémon and they will appear here."
    )
}