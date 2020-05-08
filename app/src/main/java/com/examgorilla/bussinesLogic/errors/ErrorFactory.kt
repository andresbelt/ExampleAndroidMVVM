package com.examgorilla.bussinesLogic.errors

import com.examgorilla.data.errors.ErrorEnum

interface ErrorFactory {
    fun getError(errorCode: Int): ErrorEnum
}