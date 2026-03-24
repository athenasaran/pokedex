package com.athena.pokedex.di

import android.app.Application
import androidx.core.content.ContextCompat.getString
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import com.athena.pokedex.R
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object MainModule {
    @Provides
    fun provideGoogleIdOptions(application: Application): GetGoogleIdOption {
        return GetGoogleIdOption.Builder()
            .setServerClientId(getString(application, R.string.default_web_client_id))
            .setFilterByAuthorizedAccounts(false)
            .build()
    }

    @Provides
    fun provideGetCredentialRequest(option: GetGoogleIdOption): GetCredentialRequest {
        return GetCredentialRequest.Builder()
            .addCredentialOption(option)
            .build()
    }

    @Provides
    fun provideCredentialManager(application: Application): CredentialManager {
        return CredentialManager.create(application)
    }

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return Firebase.auth
    }
}