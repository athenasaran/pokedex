package com.athena.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp
import com.athena.designsystem.R

val PoppinsFontFamily = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, FontWeight.Bold),
)

val defaultTextStyle = TextStyle(
    fontFamily = PoppinsFontFamily,
    platformStyle = PlatformTextStyle(
        includeFontPadding = false
    ),
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.None
    )
)

val Typography = Typography(
    displayLarge = defaultTextStyle.copy(
        fontSize = 34.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 40.sp
    ),
    headlineLarge = defaultTextStyle.copy(
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 32.sp
    ),
    titleLarge = defaultTextStyle.copy(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 28.sp
    ),
    titleMedium = defaultTextStyle.copy(
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 24.sp
    ),
    bodyLarge = defaultTextStyle.copy(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 24.sp
    ),
    bodyMedium = defaultTextStyle.copy(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp
    ),
    labelLarge = defaultTextStyle.copy(
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 20.sp
    ),
    labelMedium = defaultTextStyle.copy(
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 16.sp
    ),
    labelSmall = defaultTextStyle.copy(
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 16.sp
    )
)