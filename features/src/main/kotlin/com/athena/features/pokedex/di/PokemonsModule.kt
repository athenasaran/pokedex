package com.athena.features.pokedex.di

import android.app.Application
import androidx.room.Room
import com.athena.features.pokedex.data.local.dao.PokemonDao
import com.athena.features.pokedex.data.local.database.PokemonDatabase
import com.athena.features.pokedex.data.local.datasource.PokemonLocalDataSource
import com.athena.features.pokedex.data.remote.api.PokemonApi
import com.athena.features.pokedex.data.remote.datasource.PokemonRemoteDataSource
import com.athena.features.pokedex.data.repository.PokemonRepositoryImpl
import com.athena.features.pokedex.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(ViewModelComponent::class)
@Module
class PokemonsModule {
    @Provides
    fun providePokemonApi(retrofit: Retrofit): PokemonApi = retrofit.create(PokemonApi::class.java)

    @Provides
    fun providePokemonDataSource(api: PokemonApi): PokemonRemoteDataSource = PokemonRemoteDataSource(api)

    @Provides
    fun providePokemonLocalDataSource(
        pokemonDao: PokemonDao
    ): PokemonLocalDataSource = PokemonLocalDataSource(pokemonDao)


    @Provides
    fun providePokemonRepository(
        localDataSource: PokemonLocalDataSource,
        remoteDataSource: PokemonRemoteDataSource
    ): PokemonRepository = PokemonRepositoryImpl(remoteDataSource, localDataSource)
}

@InstallIn(SingletonComponent::class)
@Module
class PokedexDatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application
    ): PokemonDatabase {
        return Room
            .databaseBuilder(application, PokemonDatabase::class.java, "Pokedex.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providePokemonDao(appDatabase: PokemonDatabase): PokemonDao {
        return appDatabase.pokemonDao()
    }
}