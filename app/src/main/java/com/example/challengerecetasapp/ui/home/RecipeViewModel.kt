package com.example.challengerecetasapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challengerecetasapp.domain.models.Recipe
import com.example.challengerecetasapp.domain.usecases.GetRecipesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RecipeViewModel(
    private val getRecipesUseCase: GetRecipesUseCase
): ViewModel() {

    private var _recipes: MutableStateFlow<List<Recipe>> = MutableStateFlow(emptyList())
    val recipes = _recipes.asStateFlow()

    init {
        loadRecipes()
    }

    private fun loadRecipes() {
        viewModelScope.launch {
            val recipes = getRecipesUseCase.invoke()
            _recipes.value = recipes
        }
    }
}