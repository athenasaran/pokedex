package br.com.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import br.com.pokedex.navigation.AppNavHost
import com.athena.designsystem.theme.PokedexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        setContent {
            PokedexTheme {
                val host = rememberNavController()
                AppNavHost(navController = host)
            }
        }
    }
}

