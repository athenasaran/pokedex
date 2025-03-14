package com.athena.data.remote.regions.datasource

import com.athena.data.remote.regions.api.RegionsApi
import com.athena.data.remote.regions.model.RegionResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RegionsDataSource @Inject constructor(
    private val regionsApi: RegionsApi
) {
    fun getRegions(): Flow<List<RegionResponse>> {
        return flow {
            val regionsResponse = regionsApi.getRegions()
            emit(regionsResponse.results)
        }
    }
}