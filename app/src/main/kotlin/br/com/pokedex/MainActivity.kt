package br.com.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.athena.designsystem.theme.PokedexTheme
import com.athena.features.home.presentation.view.BottomBar
import com.athena.features.navigation.AppNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        setContent {
            PokedexTheme {
                val navController = rememberNavController()
                var showBottomBar by remember { mutableStateOf(true) }
                val navBackStackEntry by navController.currentBackStackEntryAsState()

                Scaffold(
                    bottomBar = {
                        AnimatedVisibility(showBottomBar) {
                            BottomBar(navController)
                        }
                    }
                ) { innerPadding ->
                    AppNavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        onRouteSelected = { showBottomBar = it },
                        route = navBackStackEntry?.destination?.route ?: String()
                    )
                }
            }
        }
    }
}