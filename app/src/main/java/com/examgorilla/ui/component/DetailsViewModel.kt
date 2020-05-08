package com.examgorilla.ui.component

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.examgorilla.bussinesLogic.detailscase.RecipeDetailsCase
import com.examgorilla.bussinesLogic.errors.ErrorManager
import com.examgorilla.data.Resource
import com.examgorilla.data.dto.RecipeDetailItem
import com.examgorilla.data.errors.ErrorMapper
import com.examgorilla.ui.base.BaseViewModel
import com.examgorilla.util.Event
import javax.inject.Inject

class DetailsViewModel @Inject
constructor(private val recipesDataUseCase: RecipeDetailsCase) : BaseViewModel() {

    override val errorManager: ErrorManager
        get() = ErrorManager(ErrorMapper())

    var recipeDetailItemLiveData: MutableLiveData<Resource<RecipeDetailItem>> = recipesDataUseCase.recipesLiveData

    private val showToastPrivate = MutableLiveData<Event<Any>>()
    val showToast: LiveData<Event<Any>> get() = showToastPrivate


    fun showToastMessage(errorCode: Int) {
        val error = errorManager.getError(errorCode)
        showToastPrivate.value = Event(error.description)
    }


    fun getDetailRecipe(id: String) {
        recipesDataUseCase.getIdDetails(id)
    }


}
