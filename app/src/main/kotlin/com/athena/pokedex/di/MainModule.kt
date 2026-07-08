package com.athena.pokedex.di

import android.content.Context
import androidx.credentials.CredentialManager
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
internal object MainModule {
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