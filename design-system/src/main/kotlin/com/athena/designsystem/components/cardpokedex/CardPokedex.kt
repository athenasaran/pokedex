package com.athena.designsystem.components.cardpokedex

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.athena.designsystem.R
import com.athena.designsystem.components.button.ButtonSmallPokedex
import com.athena.designsystem.components.pokemon.PokemonType
import com.athena.designsystem.theme.Black
import com.athena.designsystem.theme.PokedexTheme
import com.athena.designsystem.theme.Typography

@Composable
fun CardPokedex(
    modifier: Modifier = Modifier,
    pokemonType: List<PokemonType>,
    backgroundImage: String,
    pokemonName: String,
    pokemonNumber: String,
    onClickFavorite: () -> Unit,
    onCardClick: () -> Unit
) {
    var isFavoriteClicked by remember { mutableStateOf(false) }
    val iconFavorite = if (isFavoriteClicked) R.drawable.ic_favorite_clicked else R.drawable.ic_favorite

    Box(
        modifier = with(modifier) {
            fillMaxWidth()
                .heightIn(min = 120.dp)
                .clip(shape = RoundedCornerShape(12.dp))
                .alpha(0.8f)
                .background(color = pokemonType.first().colorBackground)
                .clickable {
                    onCardClick()
                }
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp, start = 8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Nº $pokemonNumber",
                    style = Typography.titleMedium,
                    color = Black,
                    modifier = Modifier.padding(start = 8.dp)
                )
                Text(
                    text = pokemonName,
                    style = Typography.titleLarge,
                    color = Black,
                    modifier = Modifier.padding(start = 8.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.Start
                ) {
                    pokemonType.take(2).forEach { type ->
                        ButtonSmallPokedex(
                            type = type,
                            onClick = {}
                        )
                    }
                }
            }
            Box(
                contentAlignment = Alignment.TopEnd,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp)
            ) {
                AsyncImage(
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(90.dp),
                    model = backgroundImage,
                    contentDescription = null
                )
                Image(
                    painter = painterResource(iconFavorite),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            onClickFavorite()
                            isFavoriteClicked = !isFavoriteClicked
                        }
                )
            }
        }
    }
}

@Preview
@Composable
private fun CardPokedexPrev() {
    PokedexTheme {
        CardPokedex(
            pokemonType = listOf(PokemonType.WATER, PokemonType.BUG),
            backgroundImage = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
            pokemonName = "Bulbasaur",
            pokemonNumber = "001",
            onClickFavorite = {},
            onCardClick = {}
        )
    }
}