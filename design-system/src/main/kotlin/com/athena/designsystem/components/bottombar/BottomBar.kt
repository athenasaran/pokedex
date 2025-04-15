package com.athena.designsystem.components.bottombar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.athena.designsystem.theme.Blue100

const val SHOULD_DISPLAY_BOTTOM_BAR = "should_display_bottom_bar"

@Composable
fun BottomBar(
    navController: NavController,
    items: List<BottomNavItem>
) {
    var showBottomBar by remember { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    currentDestination?.arguments?.get(SHOULD_DISPLAY_BOTTOM_BAR)?.defaultValue.let {
        showBottomBar = it as? Boolean ?: true
    }
    AnimatedVisibility(showBottomBar) {
        NavigationBar {
            items.forEach { item ->
                NavigationItem(item = item, navController = navController)
            }
        }
    }
}

@Composable
private fun RowScope.NavigationItem(item: BottomNavItem, navController: NavController) {
    val selected = navController.getCurrentRoute() == item.route
    val animatedSize by animateDpAsState(
        targetValue = if (selected) 30.dp else 25.dp,
        label = "",
        animationSpec = tween(400)
    )

    NavigationBarItem(
        interactionSource = remember { MutableInteractionSource() },
        selected = selected,
        onClick = navigate(item, navController),
        icon = {
            Image(
                modifier = Modifier.size(animatedSize),
                painter = painterResource(id = if (selected) item.iconSelected else item.iconUnselected),
                contentDescription = null
            )
        },
        label = {
            Text(text = item.title, color = if (selected) Blue100 else Color.Transparent)
        },
        colors = NavigationBarItemDefaults.colors().copy(selectedIndicatorColor = Color.Transparent)
    )
}

@Composable
private fun navigate(item: BottomNavItem, navController: NavController): (() -> Unit) = {
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