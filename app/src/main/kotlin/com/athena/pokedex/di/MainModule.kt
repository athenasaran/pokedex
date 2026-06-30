package com.athena.pokedex.di

import android.content.Context
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
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object MainModule {
    @ActivityScoped
    @Provides
    fun provideGoogleIdOptions(@ActivityContext context: Context): GetGoogleIdOption {
        return GetGoogleIdOption.Builder()
            .setServerClientId(getString(context, R.string.default_web_client_id))
            .setFilterByAuthorizedAccounts(false)
            .build()
    }

    @ActivityScoped
    @Provides
    fun provideGetCredentialRequest(option: GetGoogleIdOption): GetCredentialRequest {
        return GetCredentialRequest.Builder()
            .addCredentialOption(option)
            .build()
    }

    @ActivityScoped
    @Provides
    fun provideCredentialManager(@ActivityContext context: Context): CredentialManager {
        return CredentialManager.create(context)
    }

    @ActivityScoped
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return Firebase.auth
    }
}