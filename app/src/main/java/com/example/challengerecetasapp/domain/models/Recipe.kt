package com.example.challengerecetasapp.domain.models

import com.example.challengerecetasapp.utils.EMPTY

data class Recipe(
    val id: Int = 0,
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
    val isFavorite: Boolean = false,
    val categoryCode: String = EMPTY,
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val createdAt: String = EMPTY
)