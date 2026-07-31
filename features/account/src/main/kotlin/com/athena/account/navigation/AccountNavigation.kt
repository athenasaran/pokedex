package com.athena.account.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.athena.account.presentation.view.AccountScreen
import com.athena.navigation.routes.AppRoute

/**
 * Registers the Account screen in the navigation graph.
 */
fun NavGraphBuilder.accountNavGraph() {
    composable<AppRoute.Account> {
        AccountScreen()
    }
}
