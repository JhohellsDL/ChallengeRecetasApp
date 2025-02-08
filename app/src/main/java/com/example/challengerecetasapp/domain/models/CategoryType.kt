package com.example.challengerecetasapp.domain.models

import com.example.challengerecetasapp.R

sealed class CategoryType(val code: String) {
    object All : CategoryType("All")
    object Breakfast : CategoryType("Breakfast")
    object Lunch : CategoryType("Lunch")
    object Dinner : CategoryType("Dinner")
    object Dessert : CategoryType("Dessert")
    object Drinks : CategoryType("Drinks")

    fun getImageResource(): Int {
        return when (this) {
            All -> R.drawable.img_all_food
            Breakfast -> R.drawable.img_breakfast
            Lunch -> R.drawable.img_lunch
            Dinner -> R.drawable.img_dinner
            Dessert -> R.drawable.img_desserts
            Drinks -> R.drawable.img_drinks
        }
    }
}
