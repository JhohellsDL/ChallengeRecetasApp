package com.example.challengerecetasapp.domain.usecases

import com.example.challengerecetasapp.data.remote.RecipeResponse
import com.example.challengerecetasapp.domain.mappers.toRecipe
import com.example.challengerecetasapp.domain.models.Recipe
import com.example.challengerecetasapp.domain.repositories.RecipeRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.kotlin.verify

class GetRecipesUseCaseTest {

    private lateinit var repository: RecipeRepository
    private lateinit var getRecipesUseCase: GetRecipesUseCase

    @Before
    fun setUp() {
        repository = mock()
        getRecipesUseCase = GetRecipesUseCase(repository)
    }

    @Test
    fun `invoke should return mapped recipes`() = runBlocking {
        val recipeEntities = listOf(
            RecipeResponse(id = 1, name = "Pizza", description = "Deliciosa pizza"),
            RecipeResponse(id = 2, name = "Sushi", description = "Sushi fresco")
        )
        val expectedRecipes = recipeEntities.map { it.toRecipe() }
        `when`(repository.getRecipes()).thenReturn(recipeEntities)
        val result = getRecipesUseCase()
        verify(repository).getRecipes()
        assertEquals(expectedRecipes, result)
    }

    @Test
    fun `invoke should return empty list when repository returns empty list`() = runBlocking {
        `when`(repository.getRecipes()).thenReturn(emptyList())
        val result = getRecipesUseCase()
        verify(repository).getRecipes()
        assertEquals(emptyList<Recipe>(), result)
    }
}