package com.athena.data.local.details.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["name", "pokemonName"])
internal data class AbilityEntity(
    @ColumnInfo("name") val name: String,
    @ColumnInfo("pokemonName") val pokemonName: String
)