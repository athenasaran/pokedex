package com.athena.features.home.presentation.view

import androidx.annotation.DrawableRes
import com.athena.designsystem.R

sealed class BottomNavItem(
    @DrawableRes val iconSelected: Int,
    @DrawableRes val iconUnselected: Int,
    val title: String,
    val route: String
) {
    data object Pokedex : BottomNavItem(
        title = "Pokedéx",
        route = "pokedex",
        iconSelected = R.drawable.ic_pokebola_selected,
        iconUnselected = R.drawable.ic_pokebola,
    )

    data object Regions : BottomNavItem(
        title = "Regiões",
        route = "regions",
        iconSelected = R.drawable.ic_pin_selected,
        iconUnselected = R.drawable.ic_pokepin,
    )

    data object Favorite : BottomNavItem(
        title = "Favorito",
        route = "favorite",
        iconSelected = R.drawable.ic_heart_selected,
        iconUnselected = R.drawable.ic_pokeheart
    )

    data object Account : BottomNavItem(
        title = "Conta",
        route = "account",
        iconSelected = R.drawable.ic_person_selected,
        iconUnselected = R.drawable.ic_person,
    )
}
