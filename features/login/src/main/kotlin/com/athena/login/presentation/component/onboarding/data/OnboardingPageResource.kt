package com.athena.login.presentation.component.onboarding.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.athena.features.login.R
import com.athena.designsystem.R as DesignSystemR

internal enum class OnboardingPageResource(
    val title: @Composable () -> String,
    val subtitle: @Composable () -> String,
    val image: @Composable () -> Painter,
    val buttonText: @Composable () -> String,
    val text: (@Composable () -> String)? = null,
) {
    FIRST_PAGE(
        title = {
            stringResource(R.string.onboarding_title_all_pokemon)
        },
        subtitle = {
            stringResource(R.string.onboarding_description_all_generations)
        },
        image = {
            painterResource(DesignSystemR.drawable.img_two_people)
        },
        buttonText = {
            stringResource(R.string.continue_button)
        }
    ),
    SECOND_PAGE(
        title = {
            stringResource(R.string.onboarding_title_updated_pokedex)
        },
        subtitle = {
            stringResource(R.string.onboarding_description_save_profile)
        },
        image = {
            painterResource(DesignSystemR.drawable.img_girl)
        },
        buttonText = {
            stringResource(R.string.onboarding_title_lets_start)
        }
    ),
    THIRD_PAGE(
        title = {
            stringResource(R.string.onboarding_title_ready_for_adventure)
        },
        subtitle = {
            stringResource(R.string.onboarding_description_create_account)
        },
        image = {
            painterResource(DesignSystemR.drawable.img_girl_and_boy)
        },
        buttonText = {
            stringResource(R.string.create_account_button)
        },
        text = {
            stringResource(R.string.already_have_account_button)
        }
    ),
}