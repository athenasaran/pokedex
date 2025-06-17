package com.athena.pokedex.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.athena.android_testing.activity.HiltActivity
import com.athena.domain.model.pokedex.Pokemon
import com.athena.domain.repository.pokedex.PokedexRepository
import com.athena.features.pokedex.presentation.view.PokedexRoute
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.coEvery
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@OptIn(ExperimentalSharedTransitionApi::class)
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class PokedexScreenTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<HiltActivity>()

    @Inject
    lateinit var pokedexRepository: PokedexRepository

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun given_an_empty_list_when_pokedex_screen_its_visible_then_should_not_show_card() = runTest {
        coEvery { pokedexRepository.getPokemons(0) } returns flowOf(emptyList())

        composeTestRule.setContent {
            SharedTransitionLayout {
                AnimatedVisibility(visible = true) {
                    PokedexRoute(
                        viewModel = hiltViewModel(),
                        animatedVisibilityScope = this
                    ) {}
                }
            }
        }

        composeTestRule.awaitIdle()
        composeTestRule.onNodeWithText("Bulbasaur").assertIsNotDisplayed()
    }

    @Test
    fun given_a_list_of_pokemon_when_pokedex_screen_its_visible_then_should_show_card() = runTest {
        coEvery { pokedexRepository.getPokemons(0) } returns flowOf(
            listOf(
                Pokemon(
                    id = "1",
                    name = "Bulbasaur",
                    imageUrl = "https://example.com/bulbasaur.png"
                )
            )
        )

        composeTestRule.setContent {
            SharedTransitionLayout {
                AnimatedVisibility(visible = true) {
                    PokedexRoute(
                        viewModel = hiltViewModel(),
                        animatedVisibilityScope = this
                    ) {}
                }
            }
        }

        composeTestRule.awaitIdle()
        composeTestRule.onNodeWithText("Bulbasaur").assertIsDisplayed()
    }
}