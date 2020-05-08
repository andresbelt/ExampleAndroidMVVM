package com.examgorilla.ui.base

import androidx.lifecycle.ViewModel


abstract class BaseViewModel : ViewModel() {
    abstract val errorManager: com.examgorilla.bussinesLogic.errors.ErrorManager
}
