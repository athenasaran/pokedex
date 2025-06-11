package com.athena.data.local.favorite.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.athena.data.local.pokedex.model.PokemonEntity

@Entity(
    tableName = "favorites",
    foreignKeys = [ForeignKey(
        entity = PokemonEntity::class,
        parentColumns = ["name"],
        childColumns = ["pokemonName"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class FavoritesEntity(
    @PrimaryKey
    @ColumnInfo("pokemonName")
    val pokemonName: String
)
