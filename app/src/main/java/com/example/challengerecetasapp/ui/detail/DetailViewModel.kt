package com.example.challengerecetasapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challengerecetasapp.domain.models.Recipe
import com.example.challengerecetasapp.domain.usecases.GetRecipesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val getRecipesUseCase: GetRecipesUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<DetailState>(DetailState.Loading)
    val state: StateFlow<DetailState> = _state

    fun loadRecipeById(id: Int) {
        viewModelScope.launch {
            _state.value = try {
                val recipe = getRecipesUseCase.invoke().find { it.id == id }
                if (recipe != null) {
                    DetailState.Success(recipe)
                } else {
                    DetailState.Error("Receta no encontrada")
                }
            } catch (_: Exception) {
                DetailState.Error("Error al cargar la receta")
            }
        }
    }
}

sealed class DetailState {
    object Loading : DetailState()
    data class Success(val recipe: Recipe) : DetailState()
    data class Error(val message: String) : DetailState()
}