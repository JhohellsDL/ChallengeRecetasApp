package com.example.challengerecetasapp.domain.usecases

import com.example.challengerecetasapp.domain.repositories.RecipeRepository

class GetFavoritesRecipesUseCase(
    private val repository: RecipeRepository
) {
    operator fun invoke() = repository.getFavoriteRecipes()
}