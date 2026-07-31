package com.athena.regions.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.athena.navigation.routes.AppRoute
import com.athena.regions.presentation.view.RegionsRoute

/**
 * Registers the Regions screen in the navigation graph.
 */
fun NavGraphBuilder.regionsNavGraph() {
    composable<AppRoute.Regions> {
        RegionsRoute(viewModel = hiltViewModel())
    }
}
