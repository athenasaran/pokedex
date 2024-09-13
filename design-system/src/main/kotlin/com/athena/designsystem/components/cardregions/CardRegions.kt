package com.athena.designsystem.components.cardregions

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.athena.designsystem.R
import com.athena.designsystem.theme.White

@Composable
fun CardRegions(modifier: Modifier = Modifier, regions: Regions) {
    Box(
        modifier = with(modifier) {
            fillMaxWidth()
                .heightIn(min = 120.dp)
                .clip(shape = RoundedCornerShape(12.dp))
                .paint(
                    painterResource(id = regions.backgroundImage),
                    contentScale = ContentScale.FillBounds
                )
        }
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = regions.nameRegion,
                    color = White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(text = regions.generationRegion, color = Color.Gray, fontSize = 11.sp)
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                regions.pokemonImages.forEach { pokemonImage ->
                    Image(
                        painter = painterResource(id = pokemonImage),
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
    CardRegions(
        regions = Regions(
            nameRegion = "Unova",
            generationRegion = "Generation V",
            backgroundImage = R.drawable.region_unova,
            pokemonImages = listOf(
                R.drawable.ic_pin_selected,
                R.drawable.ic_heart_selected,
                R.drawable.ic_person_selected
            )
        )
    )
}

data class Regions(
    val nameRegion: String,
    val generationRegion: String,
    @DrawableRes val backgroundImage: Int,
    @DrawableRes val pokemonImages: List<Int>
)