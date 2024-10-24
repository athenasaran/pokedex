package com.athena.designsystem.components.error

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.athena.designsystem.R
import com.athena.designsystem.components.button.ButtonDefault
import com.athena.designsystem.theme.Blue100
import com.athena.designsystem.theme.Typography
import com.athena.designsystem.theme.White

@Composable
fun DefaultErrorContent(
    @DrawableRes imageError: Int,
    title: String,
    subTitle: String? = null,
    buttonTitle: String? = null,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        Image(
            painter = painterResource(id = imageError),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Text(text = title, style = Typography.titleLarge, textAlign = TextAlign.Center)
        subTitle?.let {
            Text(
                text = it,
                style = Typography.labelMedium,
                textAlign = TextAlign.Center
            )
        }
        buttonTitle?.let {
            onClick?.let {
                ButtonDefault(
                    title = buttonTitle,
                    backgroundColor = White,
                    titleColor = Blue100,
                    onClick = onClick
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DontHaveFavoritePreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        DefaultErrorContent(
            imageError = R.drawable.img_not_found_favorite,
            title = "You haven't favorite any Pokémon :( ",
            subTitle = "Click on the heart icon of your favorite Pokémon and they will appear here.",
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun LoginForFavoritePreview() {
    DefaultErrorContent(
        imageError = R.drawable.img_login_favorite,
        title = "You need to login to favorite Pokémon.",
        subTitle = "For access this feature, you need to login or create an account. Do it now!",
        buttonTitle = "Sign In or Register",
        onClick = {}
    )
}