package com.athena.features.details.data.remote.api

import com.athena.features.details.data.model.PokemonInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonDetailsApi {
    @GET("pokemon/{name}")
    suspend fun getDetailsPokemon(
        @Path("name") name: String
    ): PokemonInfo
}