package com.athena.login.presentation.component.onboarding.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.athena.designsystem.theme.PokedexTheme
import com.athena.designsystem.theme.Typography
import com.athena.login.presentation.component.onboarding.data.OnboardingPageResource

@Composable
internal fun OnboardingHolder(
    modifier: Modifier = Modifier,
    onboardingPageResource: OnboardingPageResource
) {
    Column(
        modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = onboardingPageResource.image.invoke(),
            modifier = Modifier.size(250.dp),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Text(
            text = onboardingPageResource.title.invoke(),
            modifier = Modifier.padding(top = 24.dp),
            style = Typography.titleMedium,
        )
        Text(
            text = onboardingPageResource.subtitle.invoke(),
            style = Typography.bodySmall,
            modifier = Modifier.padding(top = 12.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun OnboardingHolderPreview() {
    PokedexTheme {
        Surface {
            OnboardingHolder(
                onboardingPageResource = OnboardingPageResource.FIRST_PAGE
            )
        }
    }
}