package com.example.challengerecetasapp.domain.models

sealed class RecipeLevel(val name: String) {
    object VeryEasy : RecipeLevel("Muy Bajo")
    object Easy : RecipeLevel("Bajo")
    object Mid : RecipeLevel("Medio")
    object Hard : RecipeLevel("Alto")
    object VeryHard : RecipeLevel("Muy Alto")
    object Invalid : RecipeLevel("Índice no válido")
}

fun getRecipeLevel(index: Int): RecipeLevel {
    return when (index) {
        0,1 -> RecipeLevel.VeryEasy
        2 -> RecipeLevel.Easy
        3 -> RecipeLevel.Mid
        4 -> RecipeLevel.Hard
        5 -> RecipeLevel.VeryHard
        else -> RecipeLevel.Invalid
    }
}