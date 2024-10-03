package com.athena.features.regions.data.remote.api

import com.athena.features.regions.data.remote.model.RegionsResponse
import retrofit2.http.GET

interface RegionsApi {
    @GET("region/?limit=8")
    suspend fun getRegions(): RegionsResponse
}