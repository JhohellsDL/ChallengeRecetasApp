package com.example.challengerecetasapp.data.remote

import retrofit2.http.GET

interface RecipeApi {
    @GET("/recipes")
    suspend fun getRecipes(): List<RecipeResponse>
}