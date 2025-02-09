package com.example.challengerecetasapp.domain.usecases

import app.cash.turbine.test
import com.example.challengerecetasapp.data.local.room.FavoriteRecipe
import com.example.challengerecetasapp.domain.repositories.RecipeRepository
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.kotlin.verify

class GetFavoritesRecipesIdsUseCaseTest {

    private lateinit var repository: RecipeRepository
    private lateinit var getFavoritesRecipesIdsUseCase: GetFavoritesRecipesIdsUseCase

    @Before
    fun setUp() {
        repository = mock()
        getFavoritesRecipesIdsUseCase = GetFavoritesRecipesIdsUseCase(repository)
    }

    @Test
    fun `execute should return list of favorite recipe ids`() = runTest {
        val favoriteRecipes = listOf(
            FavoriteRecipe(recipeId = 1, title = "Pizza"),
            FavoriteRecipe(recipeId = 2, title = "Sushi"),
            FavoriteRecipe(recipeId = 3, title = "Tacos")
        )
        val expectedIds = favoriteRecipes.map { it.recipeId }

        `when`(repository.getFavoriteRecipes()).thenReturn(flowOf(favoriteRecipes))

        getFavoritesRecipesIdsUseCase.execute().test {
            assertEquals(expectedIds, awaitItem())
            awaitComplete()
        }

        verify(repository).getFavoriteRecipes()
    }

    @Test
    fun `execute should return empty list when repository returns empty list`() = runTest {
        `when`(repository.getFavoriteRecipes()).thenReturn(flowOf(emptyList()))

        getFavoritesRecipesIdsUseCase.execute().test {
            assertEquals(emptyList<Int>(), awaitItem())
            awaitComplete()
        }

        verify(repository).getFavoriteRecipes()
    }
}