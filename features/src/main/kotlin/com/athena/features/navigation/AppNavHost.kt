package com.athena.features.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.athena.features.account.presentation.view.AccountScreen
import com.athena.features.details.presentation.view.PokemonDetailsRoute
import com.athena.features.favorite.presentation.view.FavoriteScreen
import com.athena.features.home.presentation.view.BottomNavItem
import com.athena.features.pokedex.presentation.view.PokedexRoute
import com.athena.features.regions.presentation.view.RegionsRoute

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = BottomNavItem.Pokedex.route,
    route: String,
    onRouteSelected: (Boolean) -> Unit
) {
    LaunchedEffect(route) {
        when {
            route.contains("pokemon-details") -> onRouteSelected(false)
            else -> onRouteSelected(true)
        }
    }

    SharedTransitionLayout {
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = modifier
        ) {

            composable(route = BottomNavItem.Pokedex.route) {
                PokedexRoute(viewModel = hiltViewModel(), animatedVisibilityScope = this) {
                    navController.navigate("pokemon-details/${it}")
                    onRouteSelected(BottomNavItem.Pokedex.isBottomBarEnabled)
                }
            }

            composable(route = BottomNavItem.Regions.route) {
                RegionsRoute(hiltViewModel())
                onRouteSelected(BottomNavItem.Regions.isBottomBarEnabled)
            }

            composable(route = BottomNavItem.Favorite.route) {
                FavoriteScreen()
                onRouteSelected(BottomNavItem.Favorite.isBottomBarEnabled)
            }

            composable(route = BottomNavItem.Account.route) {
                AccountScreen()
                onRouteSelected(BottomNavItem.Account.isBottomBarEnabled)
            }

            composable("pokemon-details/{pokemonName}") { backStackEntry ->
                val pokemonName = backStackEntry.arguments?.getString("pokemonName")

                PokemonDetailsRoute(
                    viewModel = hiltViewModel(),
                    animatedVisibilityScope = this,
                    pokemonId = pokemonName ?: "bulbasaur"
                ) {
                    navController.popBackStack()
                }
                onRouteSelected(false)
            }
        }
    }
}

internal object AppNavDestinations {
    const val POKEDEX_ROUTE = "pokedex"
    const val REGIONS_ROUTE = "regions"
    const val FAVORITE_ROUTE = "favorite"
    const val ACCOUNT_ROUTE = "account"
}