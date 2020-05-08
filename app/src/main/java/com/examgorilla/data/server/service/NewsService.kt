package com.examgorilla.data.server.service

import com.examgorilla.data.dto.RecipeItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipesService {
    @GET("recipes")
    suspend fun fetchRecipes():Response<List<RecipeItem>>

    @GET("recipes/{user_id}")
    suspend fun fetchRecipesid(@Path("user_id") category: String):Response<List<RecipeItem>>
}
