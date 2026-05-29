package com.athena.designsystem.components.cardfavorite

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.athena.designsystem.components.cardpokedex.CardPokedex

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.CardFavorite(
    modifier: Modifier = Modifier,
    pokemonName: String,
    backgroundImage: String,
    animatedVisibilityScope: AnimatedVisibilityScope,
    pokemonNumber: String,
    onRemove: (String) -> Unit = {}
) {
    val swipeToDismissBoxState = rememberSwipeToDismissBoxState(
        confirmValueChange = { value ->
            when (value) {
                SwipeToDismissBoxValue.EndToStart -> {
                    onRemove(pokemonName)
                    true
                }

                SwipeToDismissBoxValue.StartToEnd -> false
                else -> false
            }
        }
    )

    SwipeToDismissBox(
        state = swipeToDismissBoxState,
        modifier = modifier,
        enableDismissFromStartToEnd = false,
        backgroundContent = {
            if (swipeToDismissBoxState.dismissDirection == SwipeToDismissBoxValue.EndToStart &&
                swipeToDismissBoxState.currentValue != SwipeToDismissBoxValue.EndToStart
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Red),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Remove item",
                        modifier = Modifier.size(32.dp),
                        tint = Color.White
                    )
                }
            }
        }
    ) {
        CardPokedex(
            backgroundImage = backgroundImage,
            pokemonName = pokemonName,
            pokemonNumber = pokemonNumber,
            animatedVisibilityScope = animatedVisibilityScope,
            isFavorite = true,
            onClickFavorite = {
                onRemove(pokemonName)
            }
        )
    }
}