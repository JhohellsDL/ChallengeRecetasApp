package com.example.challengerecetasapp.domain.models

data class CategoryRecipe(
    val id: Int,
    val name: String,
    val type: CategoryType,
    val nameFilter: String
) {
    companion object {
        val categories = listOf(
            CategoryRecipe(0, "All", CategoryType.All, "Todos"),
            CategoryRecipe(1, "Breakfast", CategoryType.Breakfast, "Desayuno"),
            CategoryRecipe(2, "Lunch", CategoryType.Lunch, "Almuerzo"),
            CategoryRecipe(3, "Dinner", CategoryType.Dinner, "Cena"),
            CategoryRecipe(4, "Dessert", CategoryType.Dessert, "Postre"),
            CategoryRecipe(5, "Drinks", CategoryType.Drinks, "Bebidas")
        )
    }
}