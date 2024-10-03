package com.athena.features.regions.data.remote.datasource

import com.athena.features.regions.data.remote.api.RegionsApi
import com.athena.features.regions.data.remote.model.RegionResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RegionsDataSourceImpl @Inject constructor(
    private val regionsApi: RegionsApi
) : RegionsDataSource {
    override fun getRegions(): Flow<List<RegionResponse>> {
        return flow {
            val regionsResponse = regionsApi.getRegions()
            emit(regionsResponse.results)
        }
    }
}