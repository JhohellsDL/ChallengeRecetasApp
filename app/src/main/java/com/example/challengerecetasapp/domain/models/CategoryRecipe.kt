package com.example.challengerecetasapp.domain.models

data class CategoryRecipe(
    val id: Int,
    val name: String,
    val type: CategoryType
) {
    companion object {
        val categories = listOf(
            CategoryRecipe(0, "All", CategoryType.All),
            CategoryRecipe(1, "Breakfast", CategoryType.Breakfast),
            CategoryRecipe(2, "Lunch", CategoryType.Lunch),
            CategoryRecipe(3, "Dinner", CategoryType.Dinner),
            CategoryRecipe(4, "Dessert", CategoryType.Dessert),
            CategoryRecipe(5, "Drinks", CategoryType.Drinks)
        )
    }
}