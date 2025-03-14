package com.athena.data.remote.pokedex.api

import com.athena.data.remote.pokedex.model.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon")
    suspend fun getPokemons(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonListResponse
}