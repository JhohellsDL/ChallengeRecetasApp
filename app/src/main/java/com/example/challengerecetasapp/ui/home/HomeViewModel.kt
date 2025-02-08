package com.example.challengerecetasapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challengerecetasapp.domain.models.Recipe
import com.example.challengerecetasapp.ui.favorites.FavoritesViewModel

class HomeViewModel(
    private val recipeViewModel: RecipeViewModel,
    private val favoritesViewModel: FavoritesViewModel
) : ViewModel() {

    var recipes = recipeViewModel.recipes
    var favorites = favoritesViewModel.favoritesRecipesIds

    private var _randomRecipe: MutableLiveData<Recipe> = MutableLiveData()
    val randomRecipe: LiveData<Recipe> = _randomRecipe

    fun toggleFavorite(recipeId: Int) {
        val recipe = recipes.value.find { it.id == recipeId } ?: Recipe()
        favoritesViewModel.toggleFavorite(recipe, recipeId)
    }

    fun randomRecipe(recipes: List<Recipe>) {
        _randomRecipe.value = recipes.random()
    }
}