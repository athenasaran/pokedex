package com.athena.designsystem.components.cardregions

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.athena.designsystem.R
import com.athena.designsystem.theme.Black
import com.athena.designsystem.theme.Gray200
import com.athena.designsystem.theme.PokedexTheme
import com.athena.designsystem.theme.Typography
import com.athena.designsystem.theme.White

@Composable
fun CardRegions(
    modifier: Modifier = Modifier,
    generationRomanNumber: String,
    @DrawableRes backgroundImage: Int,
    pokemonImages: List<String>,
    nameRegion: String
) {
    val gradient = Brush.horizontalGradient(
        colors = listOf(Black, Color.Transparent),
        startX = 0f,
        endX = 1000f
    )

    Box(
        modifier = with(modifier) {
            fillMaxWidth()
                .heightIn(min = 100.dp)
                .clip(shape = RoundedCornerShape(12.dp))
                .paint(
                    painter = painterResource(id = backgroundImage),
                    contentScale = ContentScale.FillBounds
                )
                .background(gradient, alpha = 0.8f)
        }
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = nameRegion,
                    color = White,
                    style = Typography.titleMedium
                )
                Text(
                    text = stringResource(
                        R.string.generation,
                        generationRomanNumber
                    ),
                    style = Typography.labelSmall,
                    color = Gray200
                )
            }

            Row {
                pokemonImages.forEach { pokemonImage ->
                    AsyncImage(
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(62.dp),
                        model = pokemonImage,
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun CardRegionsPrev() {
    PokedexTheme {
        CardRegions(
            modifier = Modifier.padding(16.dp),
            generationRomanNumber = "V",
            backgroundImage = R.drawable.img_region_unova,
            pokemonImages = listOf(
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/yellow/1.png",
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/yellow/3.png",
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/yellow/5.png"
            ),
            nameRegion = "Unova"
        )
    }
}