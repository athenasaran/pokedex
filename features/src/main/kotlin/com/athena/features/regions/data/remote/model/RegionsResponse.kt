package com.athena.features.regions.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegionsResponse(
    @SerialName("results") val results: List<RegionResponse>
)

@Serializable
data class RegionResponse(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String
)