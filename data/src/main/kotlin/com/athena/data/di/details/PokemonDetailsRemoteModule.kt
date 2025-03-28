package com.athena.data.di.details

import com.athena.data.remote.details.api.PokemonDetailsApi
import com.athena.data.repository.details.PokemonDetailsRepositoryImpl
import com.athena.domain.repository.details.PokemonDetailsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@InstallIn(ViewModelComponent::class)
@Module
interface PokemonDetailsRemoteModule {

    companion object {
        @Provides
        fun providePokemonDetailsApi(retrofit: Retrofit): PokemonDetailsApi = retrofit.create(PokemonDetailsApi::class.java)
    }

    @Binds
    fun providePokemonDetailsRepository(
        pokemonDetailsRepositoryImpl: PokemonDetailsRepositoryImpl
    ): PokemonDetailsRepository
}