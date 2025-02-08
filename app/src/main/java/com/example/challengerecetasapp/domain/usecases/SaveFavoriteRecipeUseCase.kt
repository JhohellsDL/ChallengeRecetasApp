package com.example.challengerecetasapp.domain.usecases

import com.example.challengerecetasapp.data.local.room.FavoriteRecipe
import com.example.challengerecetasapp.domain.repositories.RecipeRepository

class SaveFavoriteRecipeUseCase(
    private val repository: RecipeRepository
) {
    suspend fun invoke(recipe: FavoriteRecipe) = repository.saveFavoriteRecipe(recipe = recipe)
}