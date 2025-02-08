package com.example.challengerecetasapp.navigation

import androidx.navigation.NavController

class AppNavigatorImpl : AppNavigator {
    override fun navigateToHome(navController: NavController, route: RecipeRoute) {
        navController.navigate(RecipeRoute.Home.route) {
            popUpTo(route.route) { inclusive = true }
        }
    }

    override fun navigateToOnboarding(navController: NavController) {
        navController.navigate(RecipeRoute.Onboarding.route) {
            popUpTo(RecipeRoute.Splash.route) { inclusive = true }
        }
    }

    override fun navigateToDetail(
        navController: NavController,
        recipeId: Int,
        isFavorite: Boolean
    ) {
        navController.navigate(RecipeRoute.Detail.createRoute(recipeId, isFavorite))
    }
}