package com.athena.favorite.navigation

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.athena.favorite.presentation.view.FavoriteRoute
import com.athena.navigation.routes.AppRoute

/**
 * Registers the Favorites screen in the navigation graph.
 *
 * [scope] is the [SharedTransitionScope] provided by [SharedTransitionLayout]
 * in the app module.
 */
@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.favoriteNavGraph(
    scope: SharedTransitionScope,
) {
    composable<AppRoute.Favorite> {
        with(scope) {
            FavoriteRoute(
                viewModel = hiltViewModel(),
                animatedVisibilityScope = this@composable as AnimatedVisibilityScope,
            )
        }
    }
}
