package com.athena.features.home.presentation.view

import androidx.annotation.DrawableRes
import com.athena.designsystem.R
import com.athena.features.navigation.AppNavDestinations

sealed class BottomNavItem(
    @DrawableRes val iconSelected: Int,
    @DrawableRes val iconUnselected: Int,
    val title: String,
    val route: String
) {
    data object Pokedex : BottomNavItem(
        title = "Pokedéx",
        route = AppNavDestinations.POKEDEX_ROUTE,
        iconSelected = R.drawable.ic_pokebola_selected,
        iconUnselected = R.drawable.ic_pokebola,
    )

    data object Regions : BottomNavItem(
        title = "Regions",
        route = AppNavDestinations.REGIONS_ROUTE,
        iconSelected = R.drawable.ic_pin_selected,
        iconUnselected = R.drawable.ic_pokepin,
    )

    data object Favorite : BottomNavItem(
        title = "Favorite",
        route = AppNavDestinations.FAVORITE_ROUTE,
        iconSelected = R.drawable.ic_heart_selected,
        iconUnselected = R.drawable.ic_pokeheart
    )

    data object Account : BottomNavItem(
        title = "Account",
        route = AppNavDestinations.ACCOUNT_ROUTE,
        iconSelected = R.drawable.ic_person_selected,
        iconUnselected = R.drawable.ic_person,
    )
}
