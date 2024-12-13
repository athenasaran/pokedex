package com.athena.features.details.di

import com.athena.features.details.data.remote.api.PokemonDetailsApi
import com.athena.features.details.data.remote.datasource.PokemonDetailsDataSource
import com.athena.features.details.data.repository.PokemonDetailsRepositoryImpl
import com.athena.features.details.domain.repository.PokemonDetailsRepository
import com.athena.features.details.domain.usecase.PokemonDetailsUseCase
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
    fun provideDataSource(api: PokemonDetailsApi): PokemonDetailsDataSource = PokemonDetailsDataSource(api)

    @Provides
    fun providePokemonDetailsRepository(dataSource: PokemonDetailsDataSource): PokemonDetailsRepository =
        PokemonDetailsRepositoryImpl(dataSource)

    @Provides
    fun providePokemonDetailsUseCase(repository: PokemonDetailsRepository): PokemonDetailsUseCase =
        PokemonDetailsUseCase(repository)
}