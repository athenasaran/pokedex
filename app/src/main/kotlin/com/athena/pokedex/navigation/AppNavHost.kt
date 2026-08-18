package com.athena.pokedex.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.athena.account.navigation.accountNavGraph
import com.athena.designsystem.components.bottombar.BottomNavItem
import com.athena.designsystem.utils.DesignSystemDrawableRes
import com.athena.details.navigation.detailsNavGraph
import com.athena.favorite.navigation.favoriteNavGraph
import com.athena.navigation.routes.AppRoute
import com.athena.navigation.routes.requireRoutePattern
import com.athena.regions.navigation.regionsNavGraph

/**
 * Assembles the top-level NavHost by composing feature navigation graphs.
 *
 * Each feature module exposes a [NavGraphBuilder] extension function that registers
 * its screens. The app module only maps feature callbacks to navigation actions —
 * it does not own any route strings.
 */
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: AppRoute = AppRoute.Pokedex,
) {
    SharedTransitionLayout {
        val scope = this
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = modifier,
        ) {
            pokedexNavGraph(
                scope = scope,
                onPokemonClick = { pokemonName ->
                    navController.navigate(AppRoute.PokemonDetails(pokemonName))
                },
            )

            regionsNavGraph()

            favoriteNavGraph(scope = scope)

            accountNavGraph()

            detailsNavGraph(
                scope = scope,
                onBack = { navController.popBackStack() },
            )
        }
    }
}

/**
 * Bottom navigation items keyed by type-safe route patterns.
 *
 * Uses [requireRoutePattern] to derive the exact route string that Navigation
 * Compose uses internally for each [AppRoute] type — no raw strings or
 * null-assertions.
 */
internal val bottomNavItems = listOf(
    BottomNavItem(
        title = "Pokedéx",
        route = requireRoutePattern<AppRoute.Pokedex>(),
        iconSelected = DesignSystemDrawableRes.ic_pokeball_selected,
        iconUnselected = DesignSystemDrawableRes.ic_pokeball,
    ),
    BottomNavItem(
        title = "Regions",
        route = requireRoutePattern<AppRoute.Regions>(),
        iconSelected = DesignSystemDrawableRes.ic_pin_selected,
        iconUnselected = DesignSystemDrawableRes.ic_pokepin,
    ),
    BottomNavItem(
        title = "Favorite",
        route = requireRoutePattern<AppRoute.Favorite>(),
        iconSelected = DesignSystemDrawableRes.ic_heart_selected,
        iconUnselected = DesignSystemDrawableRes.ic_pokeheart,
    ),
    BottomNavItem(
        title = "Account",
        route = requireRoutePattern<AppRoute.Account>(),
        iconSelected = DesignSystemDrawableRes.ic_person_selected,
        iconUnselected = DesignSystemDrawableRes.ic_person,
    ),
)
