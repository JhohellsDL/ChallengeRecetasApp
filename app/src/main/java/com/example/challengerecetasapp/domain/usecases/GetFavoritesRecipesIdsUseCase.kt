package com.example.challengerecetasapp.domain.usecases

import com.example.challengerecetasapp.domain.repositories.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetFavoritesRecipesIdsUseCase(
    private val repository: RecipeRepository
) {
    fun execute(): Flow<List<Int>> {
        return repository.getFavoriteRecipes().map {
            it.map { it.recipeId }
        }
    }
}