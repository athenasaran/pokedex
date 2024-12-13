package com.athena.features.details.domain.usecase

import com.athena.features.details.domain.model.PokemonDetails
import com.athena.features.details.domain.repository.PokemonDetailsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonDetailsUseCase @Inject constructor(
    private val pokemonDetailsRepository: PokemonDetailsRepository
) {
    fun getPokemonDetails(name: String): Flow<PokemonDetails> {
        return pokemonDetailsRepository.getPokemonDetails(name)
    }
}