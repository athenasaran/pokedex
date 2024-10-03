package com.athena.features.regions.di

import com.athena.features.regions.data.remote.api.RegionsApi
import com.athena.features.regions.data.remote.datasource.RegionsDataSource
import com.athena.features.regions.data.remote.datasource.RegionsDataSourceImpl
import com.athena.features.regions.data.repository.RegionRepositoryImpl
import com.athena.features.regions.domain.repository.RegionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@InstallIn(ViewModelComponent::class)
@Module
class RegionsModule {

    @Provides
    fun provideRegionsApi(retrofit: Retrofit) = retrofit.create(RegionsApi::class.java)

    @Provides
    fun provideRegionsDataSource(regionsApi: RegionsApi): RegionsDataSource {
        return RegionsDataSourceImpl(regionsApi)
    }

    @Provides
    fun provideRegionsRepository(regionsDataSource: RegionsDataSource): RegionRepository {
        return RegionRepositoryImpl(regionsDataSource)
    }
}