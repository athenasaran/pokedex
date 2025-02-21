package com.athena.features.details.data.local.model

import androidx.room.Embedded
import androidx.room.Relation

data class PokemonDetailsCrossRef(
    @Embedded val pokemonDetailsEntity: PokemonDetailsEntity,
    @Relation(
        parentColumn = "name",
        entityColumn = "pokemonName"
    )
    val typesEntity: List<TypesEntity>,
    @Relation(
        parentColumn = "name",
        entityColumn = "pokemonName"
    )
    val abilitiesEntity: AbilityEntity,
)