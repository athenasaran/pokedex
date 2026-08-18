package com.athena.pokedex.navigation

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.athena.navigation.routes.AppRoute
import com.athena.pokedex.presentation.view.PokedexRoute

/**
 * Registers the Pokedex list screen in the navigation graph.
 *
 * [scope] is the [SharedTransitionScope] provided by [SharedTransitionLayout]
 * in the app module. It must be passed explicitly because this function is
 * called from within [NavGraphBuilder] scope and needs access to the shared
 * transition scope for shared element animations.
 */
@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.pokedexNavGraph(
    scope: SharedTransitionScope,
    onPokemonClick: (String) -> Unit,
) {
    composable<AppRoute.Pokedex> {
        with(scope) {
            PokedexRoute(
                viewModel = hiltViewModel(),
                animatedVisibilityScope = this@composable as AnimatedVisibilityScope,
                onItemClicked = onPokemonClick,
            )
        }
    }
}
