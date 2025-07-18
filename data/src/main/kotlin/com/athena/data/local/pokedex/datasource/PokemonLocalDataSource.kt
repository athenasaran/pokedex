package com.athena.data.local.pokedex.datasource

import com.athena.data.local.pokedex.dao.PokemonDao
import com.athena.data.local.pokedex.model.PokemonEntity
import com.athena.data.local.pokedex.model.PokemonHomeDTO
import com.athena.domain.model.pokedex.Pokemon
import javax.inject.Inject

class PokemonLocalDataSource @Inject constructor(
    private val pokemonDao: PokemonDao
) {
    suspend fun getPokemonsInPage(page: Int) = pokemonDao.getPokemons(page)

    suspend fun insertAll(pokemons: List<Pokemon>, page: Int) = pokemonDao.insertAll(pokemons.map { it.toEntity(page) })

    suspend fun getAllPokemons(page: Int) = pokemonDao.getAllPokemons(page).map { it.toModel() }

    private fun Pokemon.toEntity(page: Int) = PokemonEntity(
        name = name,
        imageUrl = imageUrl,
        page = page,
        id = id
    )

    private fun PokemonHomeDTO.toModel() = Pokemon(
        name = name,
        imageUrl = imageUrl,
        isFavorite = isFavorite,
        id = id
    )
}