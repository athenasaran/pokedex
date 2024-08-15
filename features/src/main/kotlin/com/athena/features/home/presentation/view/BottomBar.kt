package com.athena.features.home.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.Pokedex,
        BottomNavItem.Regions,
        BottomNavItem.Favorite,
        BottomNavItem.Account
    )

    NavigationBar {
        items.forEach { item ->
            NavigationItem(item = item, navController = navController)
        }
    }
}

@Composable
fun RowScope.NavigationItem(item: BottomNavItem, navController: NavController) {
    val selected = navController.getCurrentRoute() == item.route

    NavigationBarItem(
        selected = selected,
        onClick = navigate(item, navController),
        icon = {
            Image(
                painter = painterResource(id = if (selected) item.iconSelected else item.iconUnselected),
                contentDescription = null
            )
        }
    )
}

@Composable
fun navigate(item: BottomNavItem, navController: NavController): (() -> Unit) = {
    navController.navigate(item.route) {
        navController.graph.startDestinationRoute?.let { route ->
            popUpTo(route) { saveState = true }
        }
        launchSingleTop = true
        restoreState = true
    }
}

@Composable
private fun NavController.getCurrentRoute(): String? {
    val navBackStackEntry by currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}