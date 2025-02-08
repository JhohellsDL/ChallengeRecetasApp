package com.example.challengerecetasapp.domain.mappers

import com.example.challengerecetasapp.data.local.room.FavoriteRecipe
import com.example.challengerecetasapp.data.remote.RecipeResponse
import com.example.challengerecetasapp.domain.models.Recipe

fun FavoriteRecipe.toRecipe(): Recipe {
    return Recipe(
        id = recipeId,
        title = title,
        shortDescription = shortDescription,
        description = description,
        ingredients = ingredients,
        steps = steps,
        servings = servings,
        prepTime = prepTime,
        cookTime = cookTime,
        totalTime = totalTime,
        difficulty = difficulty,
        imageUrl = imageUrl,
        categoryCode = categoryCode,
        isFavorite = true
    )
}

fun RecipeResponse.toRecipe(): Recipe {
    return Recipe(
        id = id,
        title = name,
        shortDescription = shortDescription,
        description = description,
        ingredients = ingredients,
        steps = steps,
        servings = servings,
        prepTime = prepTime,
        cookTime = cookTime,
        totalTime = totalTime,
        difficulty = difficulty,
        imageUrl = imageUrl,
        isFavorite = isFavorite,
        categoryCode = categoryCode
    )
}


fun Recipe.toFavoriteRecipe(): FavoriteRecipe {
    return FavoriteRecipe(
        recipeId = id,
        title = title,
        shortDescription = shortDescription,
        description = description,
        ingredients = ingredients,
        steps = steps,
        servings = servings,
        prepTime = prepTime,
        cookTime = cookTime,
        totalTime = totalTime,
        difficulty = difficulty,
        imageUrl = imageUrl,
        categoryCode = categoryCode
    )
}