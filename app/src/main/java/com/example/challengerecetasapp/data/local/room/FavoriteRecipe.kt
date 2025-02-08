package com.example.challengerecetasapp.data.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_recipes")
data class FavoriteRecipe(
    @PrimaryKey val recipeId: Int,
    val title: String,
    val shortDescription: String,
    val description: String,
    val ingredients: List<String>,
    val steps: List<String>,
    val servings: Int,
    val prepTime: Int,
    val cookTime: Int,
    val totalTime: Int,
    val difficulty: Int,
    val imageUrl: String,
    val categoryCode: String
)