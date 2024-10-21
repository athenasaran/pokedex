package com.athena.features.regions.presentation.model

import android.util.Log
import androidx.annotation.DrawableRes
import com.athena.designsystem.R
import com.athena.features.regions.domain.model.Region
import java.util.Locale

data class RegionUI(
    val nameRegion: String,
    val generationRomanNumeral: String,
    @DrawableRes val backgroundImage: Int,
    val pokemonImages: List<String>
)

fun List<Region>.toUI(): List<RegionUI> {
    return map {
        Log.d("Region", "RegionUI: ${it.generationRomanNumber.lowercase(Locale.ROOT)}")
        RegionUI(
            nameRegion = it.name,
            generationRomanNumeral = it.generationRomanNumber,
            backgroundImage = R.drawable.region_unova,
            pokemonImages = generateImagesRegions(it.generationRomanNumber.lowercase(Locale.ROOT))
        )
    }
}

private fun generateImagesRegions(romanNumber: String): List<String> {
    val images = mutableListOf<String>()

    for (i in 1..7 step 3) {
        images.add("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-${romanNumber}/yellow/transparent/$i.png")
    }
    Log.d("Region", "images $images")

    return images
}
