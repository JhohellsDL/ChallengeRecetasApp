package com.example.challengerecetasapp.data.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.challengerecetasapp.utils.EMPTY

@Entity(tableName = "favorite_recipes")
data class FavoriteRecipe(
    @PrimaryKey val recipeId: Int,
    val title: String = EMPTY,
    val shortDescription: String = EMPTY,
    val description: String = EMPTY,
    val ingredients: List<String> = emptyList(),
    val steps: List<String> = emptyList(),
    val servings: Int = 0,
    val prepTime: Int = 0,
    val cookTime: Int = 0,
    val totalTime: Int = 0,
    val difficulty: Int = 0,
    val imageUrl: String = EMPTY,
    val categoryCode: String = EMPTY,
)