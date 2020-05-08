package com.examgorilla.bussinesLogic

import androidx.lifecycle.MutableLiveData
import com.examgorilla.data.Resource
import com.examgorilla.data.dto.RecipeItem
import com.examgorilla.data.errors.ErrorEnum.Companion.NETWORK_ERROR
import com.examgorilla.data.server.Source
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class NewRecipesCase
@Inject
constructor(private val dataRepository: Source, override val coroutineContext: CoroutineContext) :
    RecipeCase,
    CoroutineScope {
    private val recipesMutableLiveData = MutableLiveData<Resource< List<RecipeItem>>>()
    override val recipesLiveData: MutableLiveData<Resource< List<RecipeItem>>> = recipesMutableLiveData


    override fun getRecipes() {
        var serviceResponse: Resource< List<RecipeItem>>?
        recipesMutableLiveData.postValue(Resource.Loading())
        launch {
            try {
                serviceResponse = dataRepository.requestRecipes()
                recipesMutableLiveData.postValue(serviceResponse)
            } catch (e: Exception) {
                recipesMutableLiveData.postValue(Resource.DataError(NETWORK_ERROR))
            }
        }
    }

    override fun searchByTitle(keyWord: String): RecipeItem? {
//        val Recipes = RecipesMutableLiveData.value?.data?.RecipesItems
//        if (!Recipes.isNullOrEmpty()) {
//            for (RecipesItem in Recipes) {
//                if (RecipesItem.title.isNotEmpty() && RecipesItem.title.toLowerCase().contains(keyWord.toLowerCase())) {
//                    return RecipesItem
//                }
//            }
//        }
        return null
    }
}
