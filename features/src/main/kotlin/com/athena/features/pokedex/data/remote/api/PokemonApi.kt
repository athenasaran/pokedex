package com.athena.features.pokedex.data.remote.api

import com.athena.features.pokedex.data.remote.model.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon")
    suspend fun getPokemons(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonListResponse
}