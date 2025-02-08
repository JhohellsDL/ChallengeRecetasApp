package com.example.challengerecetasapp.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavType
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.challengerecetasapp.ui.components.RecipesNavigationBar
import com.example.challengerecetasapp.ui.detail.DetailScreen
import com.example.challengerecetasapp.ui.favorites.FavoritesScreen
import com.example.challengerecetasapp.ui.home.HomeScreen
import com.example.challengerecetasapp.ui.map.MapScreen
import com.example.challengerecetasapp.ui.onboarding.OnboardingScreen
import com.example.challengerecetasapp.ui.splash.SplashScreen
import com.google.android.gms.maps.model.LatLng

@Composable
fun RecipesNavHost(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = {
            if (isBottomNavVisible(navController = navController)) {
                RecipesNavigationBar(navController = navController)
            }
        },
        modifier = Modifier.fillMaxSize()
            .background(colorScheme.background)
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = RecipeRoute.Splash.route,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            composable(RecipeRoute.Splash.route) {
                SplashScreen(navController)
            }
            composable(RecipeRoute.Onboarding.route) {
                OnboardingScreen(navController)
            }
            composable(RecipeRoute.Home.route) {
                HomeScreen(navController)
            }
            composable(RecipeRoute.Favorites.route) {
                FavoritesScreen(navController)
            }
            composable(
                route = RecipeRoute.Detail.route,
                arguments = listOf(
                    navArgument("recipeId") { type = NavType.IntType },
                    navArgument("isFavorite") { type = NavType.BoolType }
                )
            ) {
                val recipeId = it.arguments?.getInt("recipeId") ?: 0
                val isFavorite = it.arguments?.getBoolean("isFavorite") == true
                DetailScreen(
                    navController = navController,
                    recipeId = recipeId,
                    isFavorite = isFavorite
                )
            }
            composable(
                RecipeRoute.Map.route,
                arguments = listOf(
                    navArgument("lat") { type = NavType.FloatType },
                    navArgument("lng") { type = NavType.FloatType }
                )
            ) {
                val lat = it.arguments?.getFloat("lat") ?: 0f
                val lng = it.arguments?.getFloat("lng") ?: 0f
                MapScreen(navController, LatLng(lat.toDouble(), lng.toDouble()))
            }
        }
    }
}

@Composable
fun isBottomNavVisible(navController: NavHostController): Boolean {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    return when (currentBackStackEntry?.destination?.route) {
        RecipeRoute.Home.route,
        RecipeRoute.Favorites.route -> true

        else -> false
    }
}