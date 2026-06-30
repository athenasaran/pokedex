package com.athena.pokedex

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.credentials.Credential
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialException
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.athena.designsystem.components.bottombar.BottomBar
import com.athena.designsystem.theme.PokedexTheme
import com.athena.pokedex.navigation.AppNavHost
import com.athena.pokedex.navigation.bottomNavItems
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential.Companion.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import dagger.Lazy
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
internal class MainActivity : ComponentActivity() {
    @Inject
    lateinit var auth: Lazy<FirebaseAuth>

    @Inject
    lateinit var credentialManager: Lazy<CredentialManager>

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        try {
            if (auth.get().currentUser == null) {
                launchCredentialManager()
            } else {
                Log.d("Firebase", "User already signed in: ${auth.get().currentUser}")
            }
        } catch (e: Exception) {
            Log.w("Firebase", "FirebaseAuth not ready yet, falling back to CredentialManager", e)
            launchCredentialManager()
        }

        setContent {
            PokedexTheme {
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        BottomBar(navController, bottomNavItems)
                    }
                ) { innerPadding ->
                    AppNavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController
                    )
                }
            }
        }
    }

    private fun launchCredentialManager() {
        lifecycleScope.launch {
            val webClientId = getString(R.string.default_web_client_id)

            try {
                val credential = try {
                    requestGoogleId(
                        authorizedOnly = true,
                        credentialManager = credentialManager.get(),
                        webClientId = webClientId
                    )
                } catch (_: GetCredentialException) {
                    requestGoogleId(
                        authorizedOnly = false,
                        credentialManager = credentialManager.get(),
                        webClientId = webClientId
                    )
                }
                handleSignIn(credential)
            } catch (_: GetCredentialException) {
                try {
                    val signInRequest = GetCredentialRequest.Builder()
                        .addCredentialOption(
                            GetSignInWithGoogleOption.Builder(webClientId).build()
                        )
                        .build()
                    val result =
                        credentialManager.get().getCredential(this@MainActivity, signInRequest)
                    handleSignIn(result.credential)
                } catch (e: GetCredentialException) {
                    Log.e(
                        "Error",
                        "Couldn't retrieve user's credentials: ${e.localizedMessage}",
                        e
                    )
                }
            }
        }
    }

    private suspend fun requestGoogleId(
        authorizedOnly: Boolean,
        credentialManager: CredentialManager,
        webClientId: String
    ) =
        credentialManager.getCredential(
            context = this@MainActivity,
            request = GetCredentialRequest.Builder()
                .addCredentialOption(
                    GetGoogleIdOption.Builder()
                        .setServerClientId(webClientId)
                        .setFilterByAuthorizedAccounts(authorizedOnly)
                        .build()
                )
                .build()
        ).credential

    private fun handleSignIn(credential: Credential) {
        // Check if credential is of type Google ID
        if (credential is CustomCredential && credential.type == TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
            // Create Google ID Token
            val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)

            // Sign in to Firebase with using the token
            firebaseAuthWithGoogle(googleIdTokenCredential.idToken)
            Log.d("TAG", "Credential is of type Google ID! ${googleIdTokenCredential.idToken}")
        } else {
            Log.d("TAG", "Credential is not of type Google ID!")
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.get().signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("TAG", "signInWithCredential:success")
                } else {
                    // If sign in fails, display a message to the user
                    Log.w("TAG", "signInWithCredential:failure", task.exception)
                }
            }
    }
}