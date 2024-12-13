package com.athena.features.pokedex.domain.usecase

import com.athena.features.pokedex.domain.model.Pokemon
import com.athena.features.pokedex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokedexUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    fun getPokemons(page: Int): Flow<List<Pokemon>> {
        return pokemonRepository.getPokemons(page)
    }
}