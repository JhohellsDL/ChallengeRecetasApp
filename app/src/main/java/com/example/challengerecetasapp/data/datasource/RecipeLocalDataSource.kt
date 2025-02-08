package com.example.challengerecetasapp.data.datasource

import com.example.challengerecetasapp.data.local.room.FavoriteRecipe
import com.example.challengerecetasapp.data.local.room.FavoriteRecipeDao
import kotlinx.coroutines.flow.Flow

class RecipeLocalDataSource( private val dao: FavoriteRecipeDao ) {

    fun getFavoriteRecipes(): Flow<List<FavoriteRecipe>> = dao.getFavoriteRecipes()

    suspend fun saveFavoriteRecipe(recipe: FavoriteRecipe) = dao.saveFavoriteRecipe(recipe)

    suspend fun removeFavoriteRecipe(recipe: FavoriteRecipe) = dao.removeFavoriteRecipe(recipe)

}