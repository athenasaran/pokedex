package com.athena.features.details.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["name", "pokemonName"])
data class AbilityEntity(
    @ColumnInfo("name") val name: String,
    @ColumnInfo("pokemonName") val pokemonName: String
)