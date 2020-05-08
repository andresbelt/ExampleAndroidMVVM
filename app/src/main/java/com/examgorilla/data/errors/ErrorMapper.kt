package com.examgorilla.data.errors

import com.examgorilla.App
import com.examgorilla.R
import javax.inject.Inject

class ErrorMapper @Inject constructor() : ErrorMapperInterface {

    override fun getErrorString(errorId: Int): String {
        return App.context.getString(errorId)
    }

    override val errorsMap: Map<Int, String>
        get() = mapOf(
            Pair(ErrorEnum.NO_INTERNET_CONNECTION, getErrorString(R.string.no_internet)),
            Pair(ErrorEnum.NETWORK_ERROR, getErrorString(R.string.network_error))
        ).withDefault { getErrorString(R.string.network_error) }
}