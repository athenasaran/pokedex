package com.athena.pokedex.di

import com.athena.domain.repository.details.PokemonDetailsRepository
import com.athena.domain.repository.pokedex.PokedexRepository
import com.athena.domain.repository.regions.RegionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.mockk.mockk
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object FakePokedexModule {

    @Singleton
    @Provides
    fun bindPokemonRepository(): PokedexRepository {
        return mockk<PokedexRepository>()
    }

    @Provides
    fun bindPokemonDetailsRepository(): PokemonDetailsRepository {
        return mockk<PokemonDetailsRepository>()
    }

    @Provides
    fun bindRegionRepository(): RegionRepository {
        return mockk<RegionRepository>()
    }
}