package com.example.challengerecetasapp.data.datasource

import com.example.challengerecetasapp.data.remote.RecipeApi
import com.example.challengerecetasapp.data.remote.RecipeResponse

class RecipeRemoteDataSource( private val api: RecipeApi ) {

    suspend fun getRecipes(): List<RecipeResponse> = api.getRecipes()
}