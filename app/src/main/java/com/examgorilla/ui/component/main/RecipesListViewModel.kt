package com.examgorilla.ui.component.main

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.examgorilla.bussinesLogic.NewRecipesCase
import com.examgorilla.bussinesLogic.errors.ErrorManager
import com.examgorilla.data.Resource
import com.examgorilla.data.dto.RecipeItem
import com.examgorilla.data.errors.ErrorMapper
import com.examgorilla.ui.base.BaseViewModel
import com.examgorilla.util.Event
import javax.inject.Inject

class RecipesListViewModel @Inject
constructor(private val recipesDataUseCase: NewRecipesCase) : BaseViewModel() {

    override val errorManager: ErrorManager
        get() = ErrorManager(ErrorMapper())


    var recipesLiveData: MutableLiveData<Resource<List<RecipeItem>>> = recipesDataUseCase.recipesLiveData

    private val recipesSearchFoundPrivate: MutableLiveData<RecipeItem> = MutableLiveData()
    val recipesSearchFound: LiveData<RecipeItem> get() = recipesSearchFoundPrivate

    private val noSearchFoundPrivate: MutableLiveData<Unit> = MutableLiveData()
    val noSearchFound: LiveData<Unit> get() = noSearchFoundPrivate

    /**
     * UI actions as event, user action is single one time event, Shouldn't be multiple time consumption
     */
    private val openrecipesDetailsPrivate = MutableLiveData<Event<RecipeItem>>()
    val openRecipesDetails: LiveData<Event<RecipeItem>> get() = openrecipesDetailsPrivate

    /**
     * Error handling as UI
     */
    private val showSnackBarPrivate = MutableLiveData<Event<Int>>()
    val showSnackBar: LiveData<Event<Int>> get() = showSnackBarPrivate

    private val showToastPrivate = MutableLiveData<Event<Any>>()
    val showToast: LiveData<Event<Any>> get() = showToastPrivate


    fun getRecipes() {
        recipesDataUseCase.getRecipes()
    }

    fun openRecipesDetails(recipesItem: RecipeItem) {
        openrecipesDetailsPrivate.value = Event(recipesItem)
    }

    fun showSnackbarMessage(@StringRes message: Int) {
        showSnackBarPrivate.value = Event(message)
    }

    fun showToastMessage(errorCode: Int) {
        val error = errorManager.getError(errorCode)
        showToastPrivate.value = Event(error.description)
    }

    fun onSearchClick(recipesTitle: String) {
//        if (recipesTitle.isNotEmpty()) {
//            val recipesItem = recipesDataUseCase.searchByTitle(recipesTitle)
//            if (recipesItem != null) {
//                recipesSearchFoundPrivate.value = recipesItem
//            } else {
//                noSearchFoundPrivate.postValue(Unit)
//            }
//        } else {
//            noSearchFoundPrivate.postValue(Unit)
//        }
    }
}