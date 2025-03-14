package com.athena.data.di.details

import com.athena.data.local.details.datasource.PokemonDetailsLocalDataSource
import com.athena.data.remote.details.api.PokemonDetailsApi
import com.athena.data.remote.details.datasource.PokemonDetailsRemoteDataSource
import com.athena.data.repository.details.PokemonDetailsRepositoryImpl
import com.athena.domain.repository.details.PokemonDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PokemonDetailsRemoteModule {
    @Singleton
    @Provides
    fun providePokemonDetailsApi(retrofit: Retrofit): PokemonDetailsApi = retrofit.create(PokemonDetailsApi::class.java)

    @Singleton
    @Provides
    fun providePokemonDetailsRepository(
        pokemonDetailsRemoteDataSource: PokemonDetailsRemoteDataSource,
        pokemonDetailsLocalDataSource: PokemonDetailsLocalDataSource
    ): PokemonDetailsRepository = PokemonDetailsRepositoryImpl(pokemonDetailsRemoteDataSource, pokemonDetailsLocalDataSource)
}