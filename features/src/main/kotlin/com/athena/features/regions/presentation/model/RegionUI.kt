package com.athena.features.regions.presentation.model

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
        val generationRomanNumeral = it.generationRomanNumber

        RegionUI(
            nameRegion = it.name,
            generationRomanNumeral = generationRomanNumeral,
            backgroundImage = generateBackgroundImage(generationRomanNumeral),
            pokemonImages = generateImagesRegions(generationRomanNumeral)
        )
    }
}

private fun generateImagesRegions(romanNumber: String): List<String> {
    val images = mutableListOf<String>()
    val romanNumberLower = romanNumber.lowercase(Locale.ROOT)
    val type = generateUrl(romanNumber)

    val random = (1..100).random()
    for (i in random..random + 2) {
        images.add("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-${romanNumberLower}/$type/$i.png")
    }

    return images
}

private fun generateBackgroundImage(romanNumber: String): Int {
    return when (romanNumber) {
        "I" -> R.drawable.img_region_kanto
        "II" -> R.drawable.img_region_johto
        "III" -> R.drawable.img_region_hoenn
        "IV" -> R.drawable.img_region_sinnoh
        "V" -> R.drawable.img_region_unova
        "VI" -> R.drawable.img_region_kalos
        "VII" -> R.drawable.img_region_alola
        "VIII" -> R.drawable.img_region_galar
        else -> R.drawable.img_region_kanto
    }
}

private fun generateUrl(romanNumber: String): String {
    return when (romanNumber) {
        "I" -> "yellow/transparent"
        "II" -> "gold/transparent"
        "III" -> "firered-leafgreen"
        "IV" -> "heartgold-soulsilver"
        "V" -> "black-white"
        "VI" -> "omegaruby-alphasapphire"
        "VII" -> "ultra-sun-ultra-moon/shiny"
        "VIII" -> "icons"
        else -> "yellow"
    }
}
