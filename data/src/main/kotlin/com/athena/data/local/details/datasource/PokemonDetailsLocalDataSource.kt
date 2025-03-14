package com.athena.data.local.details.datasource

import com.athena.data.local.details.dao.PokemonDetailsDao
import com.athena.data.local.details.model.AbilityEntity
import com.athena.data.local.details.model.PokemonDetailsEntity
import com.athena.data.local.details.model.TypesEntity
import com.athena.domain.model.details.PokemonDetails
import com.athena.domain.model.details.Type
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