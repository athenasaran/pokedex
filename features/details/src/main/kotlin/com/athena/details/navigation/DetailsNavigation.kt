package com.athena.details.navigation

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.athena.details.presentation.view.PokemonDetailsRoute
import com.athena.navigation.routes.AppRoute

/**
 * Registers the Pokemon details screen in the navigation graph.
 *
 * [scope] is the [SharedTransitionScope] provided by [SharedTransitionLayout]
 * in the app module.
 */
@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.detailsNavGraph(
    scope: SharedTransitionScope,
    onBack: () -> Unit,
) {
    composable<AppRoute.PokemonDetails> { backStackEntry ->
        val route: AppRoute.PokemonDetails = backStackEntry.toRoute()

        with(scope) {
            PokemonDetailsRoute(
                viewModel = hiltViewModel(),
                animatedVisibilityScope = this@composable as AnimatedVisibilityScope,
                pokemonName = route.pokemonName,
                onClick = onBack,
            )
        }
    }
}
