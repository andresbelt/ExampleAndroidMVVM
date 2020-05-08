package com.examgorilla.data

import com.examgorilla.data.dto.RecipeDetailItem
import com.examgorilla.data.dto.RecipeItem
import com.examgorilla.data.server.RemoteRepository
import com.examgorilla.data.server.Source
import javax.inject.Inject

class DataRepository @Inject
constructor(
    private val remoteRepository: RemoteRepository) :
    Source {

    override suspend fun requestRecipes(): Resource<List<RecipeItem>> {
        return remoteRepository.requestRecipes()
    }

    override suspend fun requestDetailRecipe(): Resource<RecipeDetailItem> {
        return remoteRepository.requestDetailRecipe()
    }
}