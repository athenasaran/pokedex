package com.athena.designsystem.components.button

import androidx.compose.ui.graphics.Color
import com.athena.designsystem.R
import com.athena.designsystem.theme.Beige100
import com.athena.designsystem.theme.Blue100
import com.athena.designsystem.theme.Blue200
import com.athena.designsystem.theme.Blue300
import com.athena.designsystem.theme.Gray100
import com.athena.designsystem.theme.Gray200
import com.athena.designsystem.theme.Gray300
import com.athena.designsystem.theme.Green100
import com.athena.designsystem.theme.Green200
import com.athena.designsystem.theme.Orange100
import com.athena.designsystem.theme.Orange200
import com.athena.designsystem.theme.Pink100
import com.athena.designsystem.theme.Purple100
import com.athena.designsystem.theme.Red100
import com.athena.designsystem.theme.Red200
import com.athena.designsystem.theme.Teal100
import com.athena.designsystem.theme.White
import com.athena.designsystem.theme.Yellow100

enum class ButtonType(
    val colorButtonText: Color,
    val buttonText: Int,
    val colorButtonBackground: Color,
    val icon: Int? = null
) {
    ALL_TYPES(
        colorButtonText = White,
        buttonText = R.string.all_types,
        colorButtonBackground = Gray300
    ),
    WATER(
        colorButtonText = White,
        buttonText = R.string.water,
        colorButtonBackground = Blue200,
        icon = R.drawable.ic_water
    ),
    DRAGON(
        colorButtonText = White,
        buttonText = R.string.dragon,
        colorButtonBackground = Blue300,
        icon = R.drawable.ic_dragon
    ),
    ELECTRIC(
        colorButtonText = White,
        buttonText = R.string.electric,
        colorButtonBackground = Yellow100,
        icon = R.drawable.ic_electric
    ),
    FAIRY(
        colorButtonText = White,
        buttonText = R.string.fairy,
        colorButtonBackground = Pink100,
        icon = R.drawable.ic_fairy
    ),
    GHOST(
        colorButtonText = White,
        buttonText = R.string.ghost,
        colorButtonBackground = Purple100,
        icon = R.drawable.ic_ghost
    ),
    FIRE(
        colorButtonText = White,
        buttonText = R.string.fire,
        colorButtonBackground = Orange200,
        icon = R.drawable.ic_fire
    ),
    ICE(
        colorButtonText = White,
        buttonText = R.string.ice,
        colorButtonBackground = Teal100,
        icon = R.drawable.ic_ice
    ),
    GRASS(
        colorButtonText = White,
        buttonText = R.string.grass,
        colorButtonBackground = Green100,
        icon = R.drawable.ic_grass
    ),
    BUG(
        colorButtonText = White,
        buttonText = R.string.bug,
        colorButtonBackground = Green200,
        icon = R.drawable.ic_bug
    ),
    FIGHTING(
        colorButtonText = White,
        buttonText = R.string.fighting,
        colorButtonBackground = Red100,
        icon = R.drawable.ic_fighting
    ),
    NORMAL(
        colorButtonText = White,
        buttonText = R.string.normal,
        colorButtonBackground = Gray200,
        icon = R.drawable.ic_normal
    ),
    DARK(
        colorButtonText = White,
        buttonText = R.string.dark,
        colorButtonBackground = Gray300,
        icon = R.drawable.ic_dark
    ),
    STEEL(
        colorButtonText = White,
        buttonText = R.string.steel,
        colorButtonBackground = Gray100,
        icon = R.drawable.ic_steel
    ),
    ROCK(
        colorButtonText = White,
        buttonText = R.string.rock,
        colorButtonBackground = Beige100,
        icon = R.drawable.ic_rock
    ),
    PSYCHIC(
        colorButtonText = White,
        buttonText = R.string.psychic,
        colorButtonBackground = Red200,
        icon = R.drawable.ic_psychic
    ),
    GROUND(
        colorButtonText = White,
        buttonText = R.string.ground,
        colorButtonBackground = Orange100,
        icon = R.drawable.ic_ground
    ),
    POISON(
        colorButtonText = White,
        buttonText = R.string.poison,
        colorButtonBackground = Purple100,
        icon = R.drawable.ic_poison
    ),
    FLYING(
        colorButtonText = White,
        buttonText = R.string.flying,
        colorButtonBackground = Blue100,
        icon = R.drawable.ic_flying
    )
}