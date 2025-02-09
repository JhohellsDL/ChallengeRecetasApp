package com.example.challengerecetasapp.ui.home
import app.cash.turbine.test
import com.example.challengerecetasapp.domain.models.Recipe
import com.example.challengerecetasapp.domain.usecases.GetRecipesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.`when`
import org.mockito.kotlin.verify

@OptIn(ExperimentalCoroutinesApi::class)
class RecipeViewModelTest {
    private lateinit var getRecipesUseCase: GetRecipesUseCase
    private lateinit var viewModel: RecipeViewModel

    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        getRecipesUseCase = mock()
        viewModel = RecipeViewModel(getRecipesUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loadRecipes should update recipes StateFlow`() = runTest {
        val recipes = listOf(
            Recipe(id = 1, title = "Pizza", description = "Deliciosa pizza"),
            Recipe(id = 2, title = "Sushi", description = "Sushi fresco")
        )

        `when`(getRecipesUseCase.invoke()).thenReturn(recipes)

        viewModel.recipes.test {
            assertEquals(recipes, awaitItem())
            expectNoEvents()
        }

        verify(getRecipesUseCase, times(1)).invoke()
    }

    @Test
    fun `loadRecipes should update recipes StateFlow with empty list when use case returns empty list`() = runTest {
        `when`(getRecipesUseCase.invoke()).thenReturn(emptyList())

        viewModel.recipes.test {
            assertEquals(emptyList<Recipe>(), awaitItem())
            expectNoEvents()
        }

        verify(getRecipesUseCase).invoke()
    }
}