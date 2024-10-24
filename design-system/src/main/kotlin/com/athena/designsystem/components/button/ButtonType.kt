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
    val colorButtonBackground: Color
) {
    ALL_TYPES(
        colorButtonText = White,
        buttonText = R.string.all_types,
        colorButtonBackground = Gray300
    ),
    WATER(colorButtonText = White, buttonText = R.string.water, colorButtonBackground = Blue200),
    DRAGON(colorButtonText = White, buttonText = R.string.dragon, colorButtonBackground = Blue300),
    ELECTRIC(
        colorButtonText = White,
        buttonText = R.string.electric,
        colorButtonBackground = Yellow100
    ),
    FAIRY(colorButtonText = White, buttonText = R.string.fairy, colorButtonBackground = Pink100),
    GHOST(colorButtonText = White, buttonText = R.string.ghost, colorButtonBackground = Purple100),
    FIRE(colorButtonText = White, buttonText = R.string.fire, colorButtonBackground = Orange200),
    ICE(colorButtonText = White, buttonText = R.string.ice, colorButtonBackground = Teal100),
    GRASS(colorButtonText = White, buttonText = R.string.grass, colorButtonBackground = Green100),
    BUG(colorButtonText = White, buttonText = R.string.bug, colorButtonBackground = Green200),
    FIGHTING(
        colorButtonText = White,
        buttonText = R.string.fighting,
        colorButtonBackground = Red100
    ),
    NORMAL(colorButtonText = White, buttonText = R.string.normal, colorButtonBackground = Gray200),
    DARK(colorButtonText = White, buttonText = R.string.dark, colorButtonBackground = Gray300),
    STEEL(colorButtonText = White, buttonText = R.string.steel, colorButtonBackground = Gray100),
    ROCK(colorButtonText = White, buttonText = R.string.rock, colorButtonBackground = Beige100),
    PSYCHIC(colorButtonText = White, buttonText = R.string.psychic, colorButtonBackground = Red200),
    GROUND(
        colorButtonText = White,
        buttonText = R.string.ground,
        colorButtonBackground = Orange100
    ),
    POISON(
        colorButtonText = White,
        buttonText = R.string.poison,
        colorButtonBackground = Purple100
    ),
    FLYING(colorButtonText = White, buttonText = R.string.flying, colorButtonBackground = Blue100)
}