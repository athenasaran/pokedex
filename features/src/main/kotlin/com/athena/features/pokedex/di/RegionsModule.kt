package com.athena.features.pokedex.di

import com.athena.features.pokedex.data.remote.api.PokemonApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@InstallIn(ViewModelComponent::class)
@Module
class PokemonsModule {
    @Provides
    fun provideRegionsApi(retrofit: Retrofit) = retrofit.create(PokemonApi::class.java)
}