package com.example.challengerecetasapp.data.remote

import com.google.gson.annotations.SerializedName

data class RecipeResponse (
    @SerializedName("id") val id: Int = 0,
    @SerializedName("title") val name: String = "",
    @SerializedName("description") val description: String = "",
    @SerializedName("short_description") val shortDescription: String = "",
    @SerializedName("ingredients") val ingredients: List<String> = emptyList(),
    @SerializedName("steps") val steps: List<String> = emptyList(),
    @SerializedName("servings") val servings: Int = 0,
    @SerializedName("prep_time") val prepTime: Int = 0,
    @SerializedName("cook_time") val cookTime: Int = 0,
    @SerializedName("total_time") val totalTime: Int = 0,
    @SerializedName("difficulty") val difficulty: Int = 0,
    @SerializedName("image") val imageUrl: String = "",
    @SerializedName("is_favorite") val isFavorite: Boolean = false,
    @SerializedName("category_code") val categoryCode: String = "",
    @SerializedName("latitude") val latitude: Double = 0.0,
    @SerializedName("longitude") val longitude: Double = 0.0,
    @SerializedName("origin") val createdAt: String = "",
)