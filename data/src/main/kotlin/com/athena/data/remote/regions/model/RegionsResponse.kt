@file:OptIn(InternalSerializationApi::class)

package com.athena.data.remote.regions.model

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class RegionsResponse(
    @SerialName("results") val results: List<RegionResponse>
)

@Serializable
internal data class RegionResponse(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String
)