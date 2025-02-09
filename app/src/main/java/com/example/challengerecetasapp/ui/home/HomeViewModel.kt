package com.example.challengerecetasapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challengerecetasapp.domain.models.Recipe
import com.example.challengerecetasapp.ui.favorites.FavoritesViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    private val recipeViewModel: RecipeViewModel,
    private val favoritesViewModel: FavoritesViewModel
) : ViewModel() {

    var recipes: StateFlow<List<Recipe>> = recipeViewModel.recipes
    var favorites: StateFlow<Set<Int>> = favoritesViewModel.favoritesRecipesIds

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private var _randomRecipe: MutableLiveData<Recipe> = MutableLiveData()
    val randomRecipe: LiveData<Recipe> = _randomRecipe

    val filteredRecipes: StateFlow<List<Recipe>> =
        combine(recipes, _searchQuery) { recipes, query ->
            if (query.isEmpty()) {
                recipes
            } else {
                recipes.filter {
                    it.title.contains(query, ignoreCase = true) ||
                            it.shortDescription.contains(query, ignoreCase = true)
                }
            }
        }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun toggleFavorite(recipeId: Int) {
        val recipe = recipes.value.find { it.id == recipeId } ?: Recipe()
        favoritesViewModel.toggleFavorite(recipe, recipeId)
    }

    fun randomRecipe(recipes: List<Recipe>) {
        _randomRecipe.value = recipes.random()
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }
}