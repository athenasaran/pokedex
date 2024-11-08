package com.athena.features.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.athena.features.account.presentation.view.AccountScreen
import com.athena.features.favorite.presentation.view.FavoriteScreen
import com.athena.features.home.presentation.view.BottomNavItem
import com.athena.features.pokedex.presentation.view.PokedexRoute
import com.athena.features.regions.presentation.view.RegionsRoute

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = BottomNavItem.Pokedex.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(route = BottomNavItem.Pokedex.route) {
            PokedexRoute(hiltViewModel())
        }

        composable(route = BottomNavItem.Regions.route) {
            RegionsRoute(hiltViewModel())
        }

        composable(route = BottomNavItem.Favorite.route) {
            FavoriteScreen()
        }

        composable(route = BottomNavItem.Account.route) {
            AccountScreen()
        }
    }
}

internal object AppNavDestinations {
    const val POKEDEX_ROUTE = "pokedex"
    const val REGIONS_ROUTE = "regions"
    const val FAVORITE_ROUTE = "favorite"
    const val ACCOUNT_ROUTE = "account"
}