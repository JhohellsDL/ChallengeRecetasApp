package com.example.challengerecetasapp.domain.repositories

import com.example.challengerecetasapp.data.datasource.RecipeLocalDataSource
import com.example.challengerecetasapp.data.datasource.RecipeRemoteDataSource
import com.example.challengerecetasapp.data.local.room.FavoriteRecipe

class RecipeRepository(
    private val localDataSource: RecipeLocalDataSource,
    private val remoteDataSource: RecipeRemoteDataSource
) {
    fun getFavoriteRecipes() = localDataSource.getFavoriteRecipes()

    suspend fun saveFavoriteRecipe(recipe: FavoriteRecipe) = localDataSource.saveFavoriteRecipe(recipe)

    suspend fun removeFavoriteRecipe(recipe: FavoriteRecipe) = localDataSource.removeFavoriteRecipe(recipe)

    suspend fun getRecipes() = remoteDataSource.getRecipes()
}