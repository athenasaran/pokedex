package com.athena.data.di.pokedex

import com.athena.data.local.pokedex.datasource.PokemonLocalDataSource
import com.athena.data.remote.pokedex.api.PokemonApi
import com.athena.data.remote.pokedex.datasource.PokemonRemoteDataSource
import com.athena.data.repository.pokedex.PokemonRepositoryImpl
import com.athena.domain.repository.pokedex.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PokedexRemoteModule {
    @Singleton
    @Provides
    fun providePokemonApi(retrofit: Retrofit): PokemonApi = retrofit.create(PokemonApi::class.java)

    @Singleton
    @Provides
    fun providePokemonRepository(
        pokemonRemoteDataSource: PokemonRemoteDataSource,
        pokemonLocalDataSource: PokemonLocalDataSource
    ): PokemonRepository = PokemonRepositoryImpl(pokemonRemoteDataSource, pokemonLocalDataSource)
}