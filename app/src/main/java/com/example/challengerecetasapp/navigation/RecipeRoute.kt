package com.example.challengerecetasapp.navigation

sealed class RecipeRoute(val route: String) {
    object Splash : RecipeRoute("splash")
    object Onboarding: RecipeRoute("onboarding")
    object Home : RecipeRoute("Home")
    object Favorites : RecipeRoute("favorites")
    object Detail : RecipeRoute("detail/{recipeId}/{isFavorite}") {
        fun createRoute(recipeId: Int, isFavorite: Boolean) = "detail/$recipeId/$isFavorite"
    }
}