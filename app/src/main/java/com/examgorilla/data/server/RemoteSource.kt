package com.examgorilla.data.server

import com.examgorilla.data.Resource
import com.examgorilla.data.dto.RecipeDetailItem
import com.examgorilla.data.dto.RecipeItem

interface Source {
    suspend fun requestRecipes(): Resource<List<RecipeItem>>
    suspend fun requestDetailRecipe(): Resource<RecipeDetailItem>
}

