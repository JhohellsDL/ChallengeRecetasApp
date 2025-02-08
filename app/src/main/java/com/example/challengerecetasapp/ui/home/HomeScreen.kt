package com.example.challengerecetasapp.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import com.example.challengerecetasapp.domain.models.Recipe
import com.example.challengerecetasapp.navigation.AppNavigator
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = koinViewModel(),
    navigator: AppNavigator = koinInject()
) {

    val recipes: List<Recipe> by homeViewModel.recipes.collectAsState()
    val favorites by homeViewModel.favorites.collectAsState()
    val randomRecipe by homeViewModel.randomRecipe.observeAsState()

    fun extracted(recipeId: Int) {
        navigator.navigateToDetail(navController, recipeId, true)
    }

    LaunchedEffect(recipes) {
        if (recipes.isNotEmpty()) {
            homeViewModel.randomRecipe(recipes)
        }
    }

    HomeScreenContent(
        recipes = recipes,
        favorites = favorites,
        onFavoriteClick = homeViewModel::toggleFavorite,
        navigatorClick = ::extracted,
        onRandomClick = { homeViewModel.randomRecipe(recipes) },
        randomRecipe = randomRecipe
    )
}
