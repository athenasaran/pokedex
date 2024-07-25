package com.athena.features.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.athena.features.favorite.FavoriteScreen
import com.athena.features.home.HomeScreen

fun NavGraphBuilder.homeRoute() {
    composable(
        route = "home/"
    ) {
        HomeScreen()
    }
}

fun NavGraphBuilder.favorite() {
    composable(
        route = "favorite/"
    ) {
        FavoriteScreen()
    }
}