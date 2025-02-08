package com.example.challengerecetasapp.navigation

import androidx.navigation.NavController

interface AppNavigator {
    fun navigateToHome(navController: NavController, route: RecipeRoute)
    fun navigateToOnboarding(navController: NavController)
    fun navigateToDetail(navController: NavController, recipeId: Int, isFavorite: Boolean = false)
    fun navigateToMap(navController: NavController, lat: Double, lng: Double)
}