package com.example.challengerecetasapp.domain.usecases

import com.example.challengerecetasapp.domain.mappers.toRecipe
import com.example.challengerecetasapp.domain.models.Recipe
import com.example.challengerecetasapp.domain.repositories.RecipeRepository

class GetRecipesUseCase(private val repository: RecipeRepository) {
    suspend operator fun invoke(): List<Recipe> = repository.getRecipes().map {
        it.toRecipe()
    }
}