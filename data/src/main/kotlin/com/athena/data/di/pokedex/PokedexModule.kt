package com.athena.data.di.pokedex

import com.athena.data.remote.pokedex.api.PokemonApi
import com.athena.data.repository.pokedex.PokemonRepositoryImpl
import com.athena.domain.repository.pokedex.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@InstallIn(ViewModelComponent::class)
@Module
interface PokedexModule {

    companion object {
        @Provides
        fun providePokemonApi(retrofit: Retrofit): PokemonApi = retrofit.create(PokemonApi::class.java)
    }

    @Binds
    fun providePokemonRepository(
        pokemonRepositoryImpl: PokemonRepositoryImpl
    ): PokemonRepository
}