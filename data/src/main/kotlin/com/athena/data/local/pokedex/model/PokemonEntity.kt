package com.athena.data.local.pokedex.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonEntity(
    @PrimaryKey @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "imageUrl") val imageUrl: String,
    @ColumnInfo(name = "page") val page: Int
)