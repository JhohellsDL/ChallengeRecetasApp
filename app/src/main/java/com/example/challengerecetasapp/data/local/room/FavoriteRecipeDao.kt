package com.example.challengerecetasapp.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteRecipeDao {

    @Query("SELECT * FROM favorite_recipes")
    fun getFavoriteRecipes(): Flow<List<FavoriteRecipe>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveFavoriteRecipe(favoriteRecipe: FavoriteRecipe)

    @Delete
    suspend fun removeFavoriteRecipe(favoriteRecipe: FavoriteRecipe)

    @Query("SELECT * FROM favorite_recipes WHERE recipeId = :id")
    suspend fun getFavoriteRecipeById(id: Int): FavoriteRecipe?

}