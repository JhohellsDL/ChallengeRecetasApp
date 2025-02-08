package com.example.challengerecetasapp.ui.favorites

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.compose.runtime.getValue
import com.example.challengerecetasapp.data.local.room.FavoriteRecipe
import com.example.challengerecetasapp.domain.mappers.toRecipe
import com.example.challengerecetasapp.navigation.AppNavigator
import com.example.challengerecetasapp.ui.components.RecipeItem
import com.example.challengerecetasapp.ui.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject


@Composable
fun FavoritesScreen(
    navController: NavHostController,
    viewModel: FavoritesViewModel = koinViewModel(),
    homeViewModel: HomeViewModel = koinViewModel(),
    navigator: AppNavigator = koinInject()
) {
    LaunchedEffect(Unit) {
        viewModel.loadFavoriteRecipes()
    }

    val recipesFavorites: List<FavoriteRecipe> by viewModel.favoritesRecipes.collectAsState()

    LazyColumn {
        items(recipesFavorites.size) { index ->
            val recipe = recipesFavorites[index].toRecipe()
            RecipeItem(
                recipe = recipe,
                isFavorite = true,
                onFavoriteToggle = {
                    homeViewModel.toggleFavorite(recipe.id)
                },
                onClickItem = {
                    navigator.navigateToDetail(navController, recipe.id, true)
                }
            )

        }
    }
}