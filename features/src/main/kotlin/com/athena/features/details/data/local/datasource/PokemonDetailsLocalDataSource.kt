package com.athena.features.details.data.local.datasource

import com.athena.features.details.data.local.dao.PokemonDetailsDao
import com.athena.features.details.data.local.model.AbilityEntity
import com.athena.features.details.data.local.model.PokemonDetailsEntity
import com.athena.features.details.data.local.model.TypesEntity
import com.athena.features.details.domain.model.PokemonDetails
import com.athena.features.details.domain.model.Type
import javax.inject.Inject

class PokemonDetailsLocalDataSource @Inject constructor(
    private val pokemonDetailsDao: PokemonDetailsDao
) {
    suspend fun getPokemonDetails(name: String): PokemonDetails? {
        return pokemonDetailsDao.getPokemonDetails(name)?.let {
            PokemonDetails(
                id = it.pokemonDetailsEntity.id,
                name = it.pokemonDetailsEntity.name,
                height = it.pokemonDetailsEntity.height,
                weight = it.pokemonDetailsEntity.weight,
                experience = it.pokemonDetailsEntity.experience,
                urlImage = it.pokemonDetailsEntity.urlImage,
                type = it.typesEntity.map { type -> Type(type.name) },
                ability = it.abilitiesEntity.name
            )
        }
    }

    suspend fun insertPokemonDetails(pokemonDetails: PokemonDetails) {
        pokemonDetailsDao.insertPokemonDetails(
            PokemonDetailsEntity(
                id = pokemonDetails.id,
                name = pokemonDetails.name,
                height = pokemonDetails.height,
                weight = pokemonDetails.weight,
                experience = pokemonDetails.experience,
                urlImage = pokemonDetails.urlImage
            )
        )
        pokemonDetailsDao.insertPokemonTypes(pokemonDetails.type.map {
            TypesEntity(
                name = it.name,
                pokemonName = pokemonDetails.name
            )
        })
        pokemonDetailsDao.insertPokemonAbility(
            abilityEntity = AbilityEntity(
                name = pokemonDetails.ability,
                pokemonName = pokemonDetails.name
            )
        )
    }
}