package com.athena.designsystem.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.athena.designsystem.R
import com.athena.designsystem.components.pokemon.PokemonType
import com.athena.designsystem.theme.Typography

@Composable
fun ButtonCategories(
    type: PokemonType,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    ButtonDefault(
        title = stringResource(type.buttonText),
        backgroundColor = type.colorButtonBackground,
        titleColor = type.colorButtonText,
        modifier = modifier.width(400.dp),
        onClick = onClick
    )
}

@Composable
fun ButtonLargePokedex(
    type: PokemonType,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    ButtonDefault(
        title = stringResource(type.buttonText),
        backgroundColor = type.colorButtonBackground,
        titleColor = type.colorButtonText,
        iconRight = type.icon,
        modifier = modifier.width(330.dp),
        onClick = onClick
    )
}

@Composable
fun ButtonSmallPokedex(
    type: PokemonType,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    ButtonDefault(
        title = stringResource(type.buttonText),
        backgroundColor = type.colorButtonBackground,
        titleColor = type.colorButtonText,
        iconRight = type.icon,
        modifier = modifier.width(110.dp),
        onClick = onClick
    )
}

@Composable
fun ButtonDefault(
    title: String,
    backgroundColor: Color,
    titleColor: Color,
    @DrawableRes iconLeft: Int? = null,
    @DrawableRes iconRight: Int? = null,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(
        color = backgroundColor,
        contentColor = titleColor,
        shape = RoundedCornerShape(size = 32.dp),
        modifier = modifier
            .padding(4.dp)
            .heightIn(42.dp),
        onClick = onClick
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(start = 16.dp)
        ) {
            Text(text = title, style = Typography.bodyMedium)
        }

        Box(contentAlignment = Alignment.CenterEnd, modifier = Modifier.padding(end = 8.dp)) {
            iconLeft?.let {
                Image(
                    painter = painterResource(id = it),
                    contentDescription = null
                )
            }
        }
        Box(contentAlignment = Alignment.CenterStart, modifier = Modifier.padding(start = 8.dp)) {
            iconRight?.let {
                Image(
                    painter = painterResource(id = it),
                    contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
fun ButtonDefaultPreview() {
    ButtonDefault(
        title = "Button",
        backgroundColor = Color.Red,
        titleColor = Color.White,
        modifier = Modifier.fillMaxWidth(),
        onClick = { }
    )
}

@Preview
@Composable
fun ButtonCategoriesPreview() {
    ButtonCategories(
        type = PokemonType.ICE,
        onClick = {}
    )
}

@Preview
@Composable
fun ButtonDefaultWithIconsPreview() {
    Row() {
        ButtonDefault(
            title = "Button",
            backgroundColor = Color.Red,
            titleColor = Color.White,
            iconRight = R.drawable.ic_pokepin,
            modifier = Modifier.widthIn(200.dp),
            onClick = { }
        )
        ButtonDefault(
            title = "Button",
            backgroundColor = Color.Red,
            titleColor = Color.White,
            iconLeft = R.drawable.ic_pokepin,
            modifier = Modifier.widthIn(200.dp),
            onClick = { }
        )
    }
}

@Preview
@Composable
fun ButtonlargePokedexPreview() {
    LazyColumn(
        modifier = Modifier.padding(vertical = 16.dp),
    ) {
        items(PokemonType.entries.size) { index ->
            ButtonLargePokedex(
                type = PokemonType.entries[index],
                onClick = {}
            )
        }
    }
}

@Preview
@Composable
fun ButtonSmallPokedexPreview() {
    LazyColumn(
        modifier = Modifier.padding(vertical = 16.dp),
    ) {
        items(PokemonType.entries.size) { index ->
            ButtonSmallPokedex(
                type = PokemonType.entries[index],
                onClick = {}
            )
        }
    }
}