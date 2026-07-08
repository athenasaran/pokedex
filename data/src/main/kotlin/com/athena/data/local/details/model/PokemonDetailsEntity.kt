package com.athena.data.local.details.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class PokemonDetailsEntity(
    @PrimaryKey @ColumnInfo("id") val id: Int,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("height") val height: String,
    @ColumnInfo("weight") val weight: String,
    @ColumnInfo("experience") val experience: String,
    @ColumnInfo("urlImage") val urlImage: String
)