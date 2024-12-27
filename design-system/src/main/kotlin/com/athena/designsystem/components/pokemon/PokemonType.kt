package com.athena.designsystem.components.pokemon

import androidx.compose.ui.graphics.Color
import com.athena.designsystem.R
import com.athena.designsystem.theme.Beige100
import com.athena.designsystem.theme.Beige150
import com.athena.designsystem.theme.Blue100
import com.athena.designsystem.theme.Blue150
import com.athena.designsystem.theme.Blue200
import com.athena.designsystem.theme.Blue250
import com.athena.designsystem.theme.Blue300
import com.athena.designsystem.theme.Blue350
import com.athena.designsystem.theme.Gray100
import com.athena.designsystem.theme.Gray150
import com.athena.designsystem.theme.Gray200
import com.athena.designsystem.theme.Gray250
import com.athena.designsystem.theme.Gray300
import com.athena.designsystem.theme.Gray350
import com.athena.designsystem.theme.Green100
import com.athena.designsystem.theme.Green150
import com.athena.designsystem.theme.Green200
import com.athena.designsystem.theme.Green250
import com.athena.designsystem.theme.Orange100
import com.athena.designsystem.theme.Orange150
import com.athena.designsystem.theme.Orange200
import com.athena.designsystem.theme.Orange250
import com.athena.designsystem.theme.Pink100
import com.athena.designsystem.theme.Pink150
import com.athena.designsystem.theme.Purple100
import com.athena.designsystem.theme.Purple150
import com.athena.designsystem.theme.Red100
import com.athena.designsystem.theme.Red150
import com.athena.designsystem.theme.Red200
import com.athena.designsystem.theme.Red250
import com.athena.designsystem.theme.Teal100
import com.athena.designsystem.theme.Teal150
import com.athena.designsystem.theme.White
import com.athena.designsystem.theme.Yellow100
import com.athena.designsystem.theme.Yellow150

enum class PokemonType(
    val colorButtonText: Color,
    val buttonText: Int,
    val colorButtonBackground: Color,
    val colorBackground: Color,
    val icon: Int? = null
) {
    ALL_TYPES(
        colorButtonText = White,
        buttonText = R.string.all_types,
        colorButtonBackground = Gray300,
        colorBackground = Gray350
    ),
    WATER(
        colorButtonText = White,
        buttonText = R.string.water,
        colorButtonBackground = Blue200,
        colorBackground = Blue250,
        icon = R.drawable.ic_water
    ),
    DRAGON(
        colorButtonText = White,
        buttonText = R.string.dragon,
        colorButtonBackground = Blue300,
        colorBackground = Blue350,
        icon = R.drawable.ic_dragon
    ),
    ELECTRIC(
        colorButtonText = White,
        buttonText = R.string.electric,
        colorButtonBackground = Yellow100,
        colorBackground = Yellow150,
        icon = R.drawable.ic_electric
    ),
    FAIRY(
        colorButtonText = White,
        buttonText = R.string.fairy,
        colorButtonBackground = Pink100,
        colorBackground = Pink150,
        icon = R.drawable.ic_fairy
    ),
    GHOST(
        colorButtonText = White,
        buttonText = R.string.ghost,
        colorButtonBackground = Purple100,
        colorBackground = Purple150,
        icon = R.drawable.ic_ghost
    ),
    FIRE(
        colorButtonText = White,
        buttonText = R.string.fire,
        colorButtonBackground = Orange200,
        colorBackground = Orange250,
        icon = R.drawable.ic_fire
    ),
    ICE(
        colorButtonText = White,
        buttonText = R.string.ice,
        colorButtonBackground = Teal100,
        colorBackground = Teal150,
        icon = R.drawable.ic_ice
    ),
    GRASS(
        colorButtonText = White,
        buttonText = R.string.grass,
        colorButtonBackground = Green100,
        colorBackground = Green150,
        icon = R.drawable.ic_grass
    ),
    BUG(
        colorButtonText = White,
        buttonText = R.string.bug,
        colorButtonBackground = Green200,
        colorBackground = Green250,
        icon = R.drawable.ic_bug
    ),
    FIGHTING(
        colorButtonText = White,
        buttonText = R.string.fighting,
        colorButtonBackground = Red100,
        colorBackground = Red150,
        icon = R.drawable.ic_fighting
    ),
    NORMAL(
        colorButtonText = White,
        buttonText = R.string.normal,
        colorButtonBackground = Gray200,
        colorBackground = Gray250,
        icon = R.drawable.ic_normal
    ),
    DARK(
        colorButtonText = White,
        buttonText = R.string.dark,
        colorButtonBackground = Gray300,
        colorBackground = Gray350,
        icon = R.drawable.ic_dark
    ),
    STEEL(
        colorButtonText = White,
        buttonText = R.string.steel,
        colorButtonBackground = Gray100,
        colorBackground = Gray150,
        icon = R.drawable.ic_steel
    ),
    ROCK(
        colorButtonText = White,
        buttonText = R.string.rock,
        colorButtonBackground = Beige100,
        colorBackground = Beige150,
        icon = R.drawable.ic_rock
    ),
    PSYCHIC(
        colorButtonText = White,
        buttonText = R.string.psychic,
        colorButtonBackground = Red200,
        colorBackground = Red250,
        icon = R.drawable.ic_psychic
    ),
    GROUND(
        colorButtonText = White,
        buttonText = R.string.ground,
        colorButtonBackground = Orange100,
        colorBackground = Orange150,
        icon = R.drawable.ic_ground
    ),
    POISON(
        colorButtonText = White,
        buttonText = R.string.poison,
        colorButtonBackground = Purple100,
        colorBackground = Purple150,
        icon = R.drawable.ic_poison
    ),
    FLYING(
        colorButtonText = White,
        buttonText = R.string.flying,
        colorButtonBackground = Blue100,
        colorBackground = Blue150,
        icon = R.drawable.ic_flying
    )
}