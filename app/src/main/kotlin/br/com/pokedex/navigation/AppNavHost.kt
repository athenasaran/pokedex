package br.com.pokedex.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.athena.features.navigation.favorite
import com.athena.features.navigation.homeRoute

@Composable
fun AppNavHost(navController: NavHostController, startDestination: String = "home/") {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier
    ) {
        this.homeRoute()
        this.favorite()
    }
}