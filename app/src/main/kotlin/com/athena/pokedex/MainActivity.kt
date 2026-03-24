package com.athena.pokedex

import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
//    @Inject
//    lateinit var credentialManager: CredentialManager
//
//    @Inject
//    lateinit var getCredentialRequest: GetCredentialRequest
//
//    @Inject
//    lateinit var auth2: FirebaseAuth

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        auth = Firebase.auth

        launchCredentialManager2()

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

    override fun onStart() {
        super.onStart()

    }

    private fun launchCredentialManager2() {
        lifecycleScope.launch {
            val credentialManager = CredentialManager.create(this@MainActivity)
            val webClientId = getString(R.string.default_web_client_id)
            suspend fun requestGoogleId(authorizedOnly: Boolean) =
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
            try {
                val credential = try {
                    requestGoogleId(authorizedOnly = true)
                } catch (_: GetCredentialException) {
                    requestGoogleId(authorizedOnly = false)
                }
                handleSignIn(credential)
            } catch (e: GetCredentialException) {
                try {
                    val signInRequest = GetCredentialRequest.Builder()
                        .addCredentialOption(
                            GetSignInWithGoogleOption.Builder(webClientId).build()
                        )
                        .build()
                    val result = credentialManager.getCredential(this@MainActivity, signInRequest)
                    handleSignIn(result.credential)
                } catch (e2: GetCredentialException) {
                    Log.e(
                        "Error",
                        "Couldn't retrieve user's credentials: ${e2.localizedMessage}",
                        e2
                    )
                }
            }
        }
    }

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
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("TAG", "signInWithCredential:success")
                    val user = auth.currentUser
                    Toast.makeText(this.baseContext, "${user}", Toast.LENGTH_LONG).show()
                } else {
                    // If sign in fails, display a message to the user
                    Log.w("TAG", "signInWithCredential:failure", task.exception)
                }
            }
    }

    private fun launchCredentialManager() {
        val googleIdOption = GetGoogleIdOption.Builder()
            // Your server's client ID, not your Android client ID.
            .setServerClientId(getString(R.string.default_web_client_id))
            // Only show accounts previously used to sign in.
            .setFilterByAuthorizedAccounts(true)
            .build()

        // Create the Credential Manager request
        val request = GetCredentialRequest.Builder()
            .addCredentialOption(googleIdOption)
            .build()

        lifecycleScope.launch {
            try {

                val credentialManager = CredentialManager.create(baseContext)

                // Launch Credential Manager UI
                val result = credentialManager.getCredential(
                    context = baseContext,
                    request = request
                )

                // Extract credential from the result returned by Credential Manager
                handleSignIn(result.credential)
            } catch (e: GetCredentialException) {
                Log.e("Error", "Couldn't retrieve user's credentials: ${e.localizedMessage}")
            }
        }
    }
//
//    private fun handleSignIn(credential: Credential) {
//        // Check if credential is of type Google ID
//        if (credential is CustomCredential && credential.type == TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
//            // Create Google ID Token
//            val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)
//
//            // Sign in to Firebase with using the token
//            firebaseAuthWithGoogle(googleIdTokenCredential.idToken)
//        } else {
//            Log.d("Error", "Credential is not of type Google ID!")
//        }
//    }
//// [END handle_sign_in]
//
//    // [START auth_with_google]
//    private fun firebaseAuthWithGoogle(idToken: String) {
//        val credential = GoogleAuthProvider.getCredential(idToken, null)
//        auth.signInWithCredential(credential)
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    // Sign in success, update UI with the signed-in user's information
//                    Log.d("Error", "signInWithCredential:success")
//                    val user = auth.currentUser
//                    Toast.makeText(this.baseContext, "${user}", Toast.LENGTH_LONG).show()
//                } else {
//                    // If sign in fails, display a message to the user
//                    Log.d("Error", "signInWithCredential:failure", task.exception)
//                    Toast.makeText(this.baseContext, "Error", Toast.LENGTH_LONG).show()
//                }
//            }
//    }
}