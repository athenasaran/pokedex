package com.athena.features.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.athena.designsystem.R
import com.athena.designsystem.components.bottombar.BottomNavItem
import com.athena.designsystem.components.bottombar.SHOULD_DISPLAY_BOTTOM_BAR
import com.athena.features.account.presentation.view.AccountScreen
import com.athena.features.details.presentation.view.PokemonDetailsRoute
import com.athena.features.favorite.presentation.view.FavoriteScreen
import com.athena.features.pokedex.presentation.view.PokedexRoute
import com.athena.features.regions.presentation.view.RegionsRoute

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppNavDestinations.POKEDEX_ROUTE
) {
    SharedTransitionLayout {
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = modifier
        ) {

            composable(route = AppNavDestinations.POKEDEX_ROUTE) {
                PokedexRoute(viewModel = hiltViewModel(), animatedVisibilityScope = this) {
                    navController.navigate("pokemon-details/${it}")
                }
            }

            composable(route = AppNavDestinations.REGIONS_ROUTE) {
                RegionsRoute(hiltViewModel())
            }

            composable(route = AppNavDestinations.FAVORITE_ROUTE) {
                FavoriteScreen()
            }

            composable(route = AppNavDestinations.ACCOUNT_ROUTE) {
                AccountScreen()
            }

            composable(route = "pokemon-details/{pokemonName}", arguments = listOf(
                navArgument(SHOULD_DISPLAY_BOTTOM_BAR) {
                    defaultValue = false
                    type = NavType.BoolType
                }
            )) { backStackEntry ->
                val pokemonName = backStackEntry.arguments?.getString("pokemonName")

                PokemonDetailsRoute(
                    viewModel = hiltViewModel(),
                    animatedVisibilityScope = this,
                    pokemonId = pokemonName ?: "bulbasaur"
                ) {
                    navController.popBackStack()
                }
            }
        }
    }
}

val bottomNavItems = listOf(
    BottomNavItem(
        title = "Pokedéx",
        route = AppNavDestinations.POKEDEX_ROUTE,
        iconSelected = R.drawable.ic_pokebola_selected,
        iconUnselected = R.drawable.ic_pokebola
    ),
    BottomNavItem(
        title = "Regions",
        route = AppNavDestinations.REGIONS_ROUTE,
        iconSelected = R.drawable.ic_pin_selected,
        iconUnselected = R.drawable.ic_pokepin,
    ),
    BottomNavItem(
        title = "Favorite",
        route = AppNavDestinations.FAVORITE_ROUTE,
        iconSelected = R.drawable.ic_heart_selected,
        iconUnselected = R.drawable.ic_pokeheart
    ),
    BottomNavItem(
        title = "Account",
        route = AppNavDestinations.ACCOUNT_ROUTE,
        iconSelected = R.drawable.ic_person_selected,
        iconUnselected = R.drawable.ic_person,
    )
)

internal object AppNavDestinations {
    const val POKEDEX_ROUTE = "pokedex"
    const val REGIONS_ROUTE = "regions"
    const val FAVORITE_ROUTE = "favorite"
    const val ACCOUNT_ROUTE = "account"
}