package com.example.challengerecetasapp.ui.favorites

import com.example.challengerecetasapp.data.local.room.FavoriteRecipe
import com.example.challengerecetasapp.domain.usecases.GetFavoritesRecipesIdsUseCase
import com.example.challengerecetasapp.domain.usecases.GetFavoritesRecipesUseCase
import com.example.challengerecetasapp.domain.usecases.RemoveFavoriteRecipeUseCase
import com.example.challengerecetasapp.domain.usecases.SaveFavoriteRecipeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challengerecetasapp.domain.mappers.toFavoriteRecipe
import com.example.challengerecetasapp.domain.models.Recipe
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val getFavoritesRecipesUseCase: GetFavoritesRecipesUseCase,
    private val getFavoritesRecipesIdsUseCase: GetFavoritesRecipesIdsUseCase,
    private val saveFavoriteRecipeUseCase: SaveFavoriteRecipeUseCase,
    private val removeFavoriteRecipeUseCase: RemoveFavoriteRecipeUseCase
): ViewModel() {

    private val _favoritesRecipes = MutableStateFlow<List<FavoriteRecipe>>(emptyList())
    val favoritesRecipes: StateFlow<List<FavoriteRecipe>> = _favoritesRecipes.asStateFlow()

    private val _favoritesRecipesIds = MutableStateFlow<Set<Int>>(emptySet())
    val favoritesRecipesIds: StateFlow<Set<Int>> = _favoritesRecipesIds.asStateFlow()

    fun toggleFavorite(recipeItem: Recipe, recipeId: Int) {
        viewModelScope.launch {
            val updatedFavorites = _favoritesRecipesIds.value.toMutableSet()
            val isFavorite = recipeId in updatedFavorites
            if (isFavorite) updatedFavorites.remove(recipeId) else updatedFavorites.add(recipeId)

            _favoritesRecipesIds.value = updatedFavorites
            val favoriteRecipe = recipeItem.toFavoriteRecipe()
            handleFavoriteRecipe(favoriteRecipe, isFavorite)
        }
    }

    fun handleFavoriteRecipe(recipe: FavoriteRecipe, isFavorite: Boolean) {
        viewModelScope.launch {
            if (isFavorite) {
                removeFavoriteRecipeUseCase.invoke(recipe)
            } else {
                saveFavoriteRecipeUseCase.invoke(recipe)
            }
        }
    }

    init {
        loadFavoriteRecipesIds()
    }

    private fun loadFavoriteRecipesIds() {
        viewModelScope.launch {
            getFavoritesRecipesIdsUseCase.execute().collect {
                _favoritesRecipesIds.value = it.toSet()
            }
        }
    }

    fun loadFavoriteRecipes() {
        viewModelScope.launch {
            getFavoritesRecipesUseCase.invoke().collect {
                _favoritesRecipes.value = it
            }
        }
    }
}