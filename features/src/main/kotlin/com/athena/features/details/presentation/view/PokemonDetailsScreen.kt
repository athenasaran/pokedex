@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.athena.features.details.presentation.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.allowHardware
import coil3.toBitmap
import com.athena.designsystem.components.button.ButtonSmallPokedex
import com.athena.designsystem.components.pokemon.PokemonType
import com.athena.designsystem.theme.Black
import com.athena.designsystem.theme.Typography
import com.athena.designsystem.utils.extractDominantColorFromBitmap
import com.athena.features.R
import com.athena.features.details.domain.model.PokemonDetails
import com.athena.features.details.domain.model.Type
import com.athena.features.details.presentation.intent.PokemonDetailsIntent
import com.athena.features.details.presentation.state.PokemonDetailsState
import com.athena.features.details.presentation.viewmodel.PokemonDetailsViewModel
import kotlinx.coroutines.launch

@Composable
private fun SharedTransitionScope.PokemonDetailsScreen(
    modifier: Modifier = Modifier,
    onIntent: (PokemonDetailsIntent) -> Unit,
    pokemonName: String,
    animatedVisibilityScope: AnimatedVisibilityScope,
    onClick: () -> Unit,
    state: PokemonDetailsState
) {
    LaunchedEffect(Unit) {
        onIntent(PokemonDetailsIntent.OnInitScreen(pokemonName))
    }

    state.pokemonDetails?.let { pokemonDetails ->
        PokemonDetailsContent(
            modifier = modifier,
            animatedVisibilityScope = animatedVisibilityScope,
            onClick = onClick,
            pokemonDetails = pokemonDetails
        )
    }
}

@Composable
private fun SharedTransitionScope.PokemonDetailsContent(
    modifier: Modifier = Modifier,
    animatedVisibilityScope: AnimatedVisibilityScope,
    pokemonDetails: PokemonDetails,
    onClick: () -> Unit
) {
    var colorBackgroundCard by remember { mutableStateOf(Color.Gray) }
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .sharedElement(
                state = rememberSharedContentState(key = pokemonDetails.name),
                animatedVisibilityScope = animatedVisibilityScope,
                boundsTransform = { _, _ -> tween(1000, easing = FastOutLinearInEasing) }
            )
            .clickable {
                onClick()
            },
    ) {
        Box(
            Modifier
                .background(colorBackgroundCard)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(vertical = 36.dp)
                    .size(150.dp),
                model = ImageRequest.Builder(context)
                    .data(pokemonDetails.urlImage)
                    .allowHardware(false)
                    .build(),
                contentDescription = null,
                onSuccess = {
                    coroutineScope.launch {
                        val bitmap = (it.result.image).toBitmap()
                        colorBackgroundCard = extractDominantColorFromBitmap(bitmap)
                    }
                }
            )
        }
        Text(
            text = pokemonDetails.name,
            style = Typography.titleLarge,
            color = Black,
            modifier = Modifier.padding(start = 8.dp)
        )
        Text(
            text = "Nº ${pokemonDetails.id}",
            style = Typography.titleSmall,
            color = Black,
            modifier = Modifier.padding(start = 8.dp)
        )
        Row {
            pokemonDetails.type.forEach { type ->
                val category = PokemonType.fromTypeName(type.name)
                ButtonSmallPokedex(category) { }
            }
        }

        Row {
            Image(painter = painterResource(R.drawable.ic_weight), contentDescription = null)
            Text(text = "Weight")
            Image(painter = painterResource(R.drawable.ic_height), contentDescription = null)
            Text(text = "Height")
        }
        Row {
            Text(text = "${pokemonDetails.weight} Kg", fontWeight = Typography.titleLarge.fontWeight)
            Text(text = "${pokemonDetails.height} m", fontWeight = Typography.titleLarge.fontWeight)
        }
        Row {
            Image(painter = painterResource(R.drawable.ic_bug), contentDescription = null)
            Text(text = "Experience")
            Image(painter = painterResource(R.drawable.ic_pokebola), contentDescription = null)
            Text(text = "Ability")
        }
        Row {
            Text(text = pokemonDetails.experience, fontWeight = Typography.titleLarge.fontWeight)
            Text(text = pokemonDetails.ability, fontWeight = Typography.titleLarge.fontWeight)
        }
    }
}

@Composable
fun SharedTransitionScope.PokemonDetailsRoute(
    viewModel: PokemonDetailsViewModel,
    animatedVisibilityScope: AnimatedVisibilityScope,
    pokemonId: String,
    onClick: () -> Unit
) {
    val state by viewModel.screenState.collectAsState()

    PokemonDetailsScreen(
        state = state,
        onIntent = viewModel::handleIntent,
        animatedVisibilityScope = animatedVisibilityScope,
        onClick = onClick,
        pokemonName = pokemonId
    )
}

@Preview(showBackground = true)
@Composable
private fun PokemonDetailsScreenPreview() {
    SharedTransitionLayout {
        AnimatedVisibility(visible = true) {
            PokemonDetailsContent(
                animatedVisibilityScope = this@AnimatedVisibility,
                pokemonDetails = PokemonDetails(
                    id = 1,
                    name = "bulbasaur",
                    urlImage = "",
                    weight = "69",
                    height = "7",
                    experience = "64",
                    type = listOf(Type("grass"), Type("water")),
                    ability = "Overgrow"
                ),
                onClick = {}
            )
        }
    }
}