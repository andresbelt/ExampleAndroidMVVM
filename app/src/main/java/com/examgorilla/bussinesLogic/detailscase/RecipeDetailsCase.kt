package com.examgorilla.bussinesLogic.detailscase

import androidx.lifecycle.MutableLiveData
import com.examgorilla.bussinesLogic.detailscase.IRecipeDetails
import com.examgorilla.data.Resource
import com.examgorilla.data.dto.RecipeDetailItem
import com.examgorilla.data.dto.RecipeItem
import com.examgorilla.data.errors.ErrorEnum.Companion.NETWORK_ERROR
import com.examgorilla.data.server.Source
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class RecipeDetailsCase
@Inject
constructor(private val dataRepository: Source, override val coroutineContext: CoroutineContext) :
    IRecipeDetails,
    CoroutineScope {
    private val recipesMutableLiveData = MutableLiveData<Resource<RecipeDetailItem>>()
    override val recipesLiveData: MutableLiveData<Resource<RecipeDetailItem>> = recipesMutableLiveData


    override fun getIdDetails(id: String) {
        var serviceResponse: Resource<RecipeDetailItem>?
        recipesMutableLiveData.postValue(Resource.Loading())
        launch {
            try {
                serviceResponse = dataRepository.requestDetailRecipe()
                recipesMutableLiveData.postValue(serviceResponse)
            } catch (e: Exception) {
                recipesMutableLiveData.postValue(Resource.DataError(NETWORK_ERROR))
            }
        }
    }

}
