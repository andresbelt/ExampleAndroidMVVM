package com.examgorilla.bussinesLogic

import androidx.lifecycle.MutableLiveData
import com.examgorilla.data.Resource
import com.examgorilla.data.dto.RecipeItem

interface RecipeCase {
    fun getRecipes()
    fun searchByTitle(keyWord: String): RecipeItem?
    val recipesLiveData: MutableLiveData<Resource<List<RecipeItem>>>
}