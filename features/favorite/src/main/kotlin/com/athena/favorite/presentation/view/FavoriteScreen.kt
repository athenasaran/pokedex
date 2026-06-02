@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.athena.favorite.presentation.view

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.athena.designsystem.components.cardfavorite.CardFavorite
import com.athena.designsystem.components.error.DefaultErrorContent
import com.athena.designsystem.components.loading.CircularLoading
import com.athena.domain.model.favorite.Favorite
import com.athena.favorite.presentation.intent.FavoriteIntent
import com.athena.favorite.presentation.state.FavoriteState
import com.athena.favorite.presentation.viewmodel.FavoriteViewModel
import com.athena.features.favorite.R
import com.athena.designsystem.R as DesignSystemR

@Composable
private fun SharedTransitionScope.FavoriteScreen(
    modifier: Modifier = Modifier,
    animatedVisibilityScope: AnimatedVisibilityScope,
    onIntent: (FavoriteIntent) -> Unit,
    state: FavoriteState
) {
    LaunchedEffect(Unit) {
        onIntent(FavoriteIntent.OnInitScreen)
    }

    when {
        state.isLoading -> {
            CircularLoading()
        }

        state.isEmpty -> {
            EmptyScreen()
        }

        else -> {
            FavoriteContent(
                modifier = modifier,
                animatedVisibilityScope = animatedVisibilityScope,
                favorites = state.favorites,
                onIntent = onIntent
            )
        }
    }
}

@Composable
private fun EmptyScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        DefaultErrorContent(
            imageError = DesignSystemR.drawable.img_not_found_favorite,
            title = stringResource(R.string.favorite_empty_title),
            modifier = modifier,
            subTitle = stringResource(R.string.favorite_empty_subtitle)
        )
    }
}

@Composable
private fun SharedTransitionScope.FavoriteContent(
    modifier: Modifier = Modifier,
    animatedVisibilityScope: AnimatedVisibilityScope,
    favorites: List<Favorite>,
    onIntent: (FavoriteIntent) -> Unit
) {
    LazyColumn(
        modifier.padding(vertical = 8.dp, horizontal = 6.dp)
    ) {
        items(
            items = favorites,
            key = { it.name }
        ) { favorite ->
            CardFavorite(
                modifier.padding(vertical = 8.dp),
                pokemonName = favorite.name,
                backgroundImage = favorite.imageUrl,
                pokemonNumber = favorite.number,
                animatedVisibilityScope = animatedVisibilityScope,
                onRemove = { name ->
                    onIntent(FavoriteIntent.OnItemDeleted(name))
                },
            )
        }
    }

}

@Composable
fun SharedTransitionScope.FavoriteRoute(
    viewModel: FavoriteViewModel,
    animatedVisibilityScope: AnimatedVisibilityScope,
) {
    val state by viewModel.screenState.collectAsStateWithLifecycle()

    FavoriteScreen(
        onIntent = viewModel::handleIntent,
        animatedVisibilityScope = animatedVisibilityScope,
        state = state
    )
}
