package com.athena.navigation.routes

import kotlinx.serialization.Serializable

/**
 * Type-safe route definitions for the Pokedex app.
 *
 * Each destination is a [Serializable] class, enabling compile-time safe navigation
 * with Jetpack Navigation Compose 2.8+.
 *
 * Usage:
 * ```
 * // Navigate
 * navController.navigate(AppRoute.PokemonDetails(pokemonName = "pikachu"))
 *
 * // Register in NavHost
 * composable<AppRoute.Pokedex> { ... }
 *
 * // Extract arguments
 * val route: AppRoute.PokemonDetails = backStackEntry.toRoute()
 * ```
 */
@Serializable
sealed interface AppRoute {

    /** Pokedex list screen (bottom nav tab, start destination). */
    @Serializable
    data object Pokedex : AppRoute

    /** Regions screen (bottom nav tab). */
    @Serializable
    data object Regions : AppRoute

    /** Favorites screen (bottom nav tab). */
    @Serializable
    data object Favorite : AppRoute

    /** Account screen (bottom nav tab). */
    @Serializable
    data object Account : AppRoute

    /** Pokemon detail screen. Receives the pokemon name as a navigation argument. */
    @Serializable
    data class PokemonDetails(val pokemonName: String) : AppRoute
}
