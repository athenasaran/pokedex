package com.athena.data.remote.regions.api

import com.athena.data.remote.regions.model.RegionsResponse
import retrofit2.http.GET

interface RegionsApi {
    @GET("region/?limit=8")
    suspend fun getRegions(): RegionsResponse
}