package com.athena.features.pokedex.data.local.datasource

import com.athena.features.pokedex.data.local.dao.PokemonDao
import com.athena.features.pokedex.data.local.model.PokemonEntity
import com.athena.features.pokedex.domain.model.Pokemon
import javax.inject.Inject

class PokemonLocalDataSource @Inject constructor(
    private val pokemonDao: PokemonDao
) {
    suspend fun getPokemons(page: Int) = pokemonDao.getPokemons(page).map { it.toModel() }

    suspend fun insertAll(pokemons: List<Pokemon>, page: Int) = pokemonDao.insertAll(pokemons.map { it.toEntity(page) })

    suspend fun getAllPokemons(page: Int) = pokemonDao.getAllPokemons(page).map { it.toModel() }

    private fun Pokemon.toEntity(page: Int) = PokemonEntity(
        name = name,
        imageUrl = imageUrl,
        page = page,
        id = id
    )

    private fun PokemonEntity.toModel() = Pokemon(
        name = name,
        imageUrl = imageUrl,
        id = id
    )
}