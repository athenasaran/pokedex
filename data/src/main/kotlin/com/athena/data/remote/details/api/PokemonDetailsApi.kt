package com.athena.data.remote.details.api

import com.athena.data.remote.details.model.PokemonInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonDetailsApi {
    @GET("pokemon/{name}")
    suspend fun getDetailsPokemon(
        @Path("name") name: String
    ): PokemonInfo
}