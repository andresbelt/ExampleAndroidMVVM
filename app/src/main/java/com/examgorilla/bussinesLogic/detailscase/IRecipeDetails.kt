package com.examgorilla.bussinesLogic.detailscase

import androidx.lifecycle.MutableLiveData
import com.examgorilla.data.Resource
import com.examgorilla.data.dto.RecipeDetailItem
import com.examgorilla.data.dto.RecipeItem

interface IRecipeDetails {
    fun getIdDetails(id: String)
    val recipesLiveData: MutableLiveData<Resource<RecipeDetailItem>>
}