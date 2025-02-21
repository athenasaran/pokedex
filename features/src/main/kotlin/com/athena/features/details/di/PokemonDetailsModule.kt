package com.athena.features.details.di

import com.athena.features.details.data.local.dao.PokemonDetailsDao
import com.athena.features.details.data.local.datasource.PokemonDetailsLocalDataSource
import com.athena.features.details.data.remote.api.PokemonDetailsApi
import com.athena.features.details.data.remote.datasource.PokemonDetailsRemoteDataSource
import com.athena.features.details.data.repository.PokemonDetailsRepositoryImpl
import com.athena.features.details.domain.repository.PokemonDetailsRepository
import com.athena.features.details.domain.usecase.PokemonDetailsUseCase
import com.athena.features.pokedex.data.local.database.PokemonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@InstallIn(ViewModelComponent::class)
@Module
class PokemonDetailsModule {
    @Provides
    fun providePokemonDetailsApi(retrofit: Retrofit): PokemonDetailsApi = retrofit.create(PokemonDetailsApi::class.java)

    @Provides
    fun provideRemoteDataSource(api: PokemonDetailsApi): PokemonDetailsRemoteDataSource = PokemonDetailsRemoteDataSource(api)

    @Provides
    fun providePokemonDetailsRepository(
        pokemonDetailsRemoteDataSource: PokemonDetailsRemoteDataSource,
        pokemonDetailsLocalDataSource: PokemonDetailsLocalDataSource
    ): PokemonDetailsRepository =
        PokemonDetailsRepositoryImpl(pokemonDetailsRemoteDataSource, pokemonDetailsLocalDataSource)

    @Provides
    fun providePokemonDetailsUseCase(repository: PokemonDetailsRepository): PokemonDetailsUseCase =
        PokemonDetailsUseCase(repository)

    @Provides
    fun providePokemonDetailsDao(database: PokemonDatabase): PokemonDetailsDao = database.pokemonDetailsDao()

    @Provides
    fun provideLocalDataSource(pokemonDetailsDao: PokemonDetailsDao): PokemonDetailsLocalDataSource =
        PokemonDetailsLocalDataSource(pokemonDetailsDao)
}