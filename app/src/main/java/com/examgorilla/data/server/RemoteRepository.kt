package com.examgorilla.data.server

import com.examgorilla.App

import com.examgorilla.data.Resource
import com.examgorilla.data.ServiceGenerator
import com.examgorilla.data.dto.RecipeDetailItem
import com.examgorilla.data.dto.RecipeItem
import com.examgorilla.data.errors.ErrorEnum.Companion.NETWORK_ERROR
import com.examgorilla.data.errors.ErrorEnum.Companion.NO_INTERNET_CONNECTION
import com.examgorilla.data.server.service.RecipesService
import com.examgorilla.util.Network.Utils.isConnected
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject
import kotlin.reflect.KSuspendFunction1

class RemoteRepository @Inject
constructor(private val serviceGenerator: ServiceGenerator) : Source {

    override suspend fun requestRecipes(): Resource<List<RecipeItem>> {
        val recipeService = serviceGenerator.createService(RecipesService::class.java)
        val response = processCall(recipeService::fetchRecipes)
        val inputAsArray = (response as? List<*>)?.filterIsInstance<RecipeItem>()
        return if(inputAsArray!!.isNotEmpty()){
            Resource.Success(data = inputAsArray)
        }else{
            Resource.DataError(errorCode = response as Int)
        }
//        System.out.println(inputAsArray?.size);
//        System.out.println(response.toString());
//        return when (response) {
//            is NewsModel -> {
//                Resource.Success(data = response.items)
//            }
//            else -> {
//                Resource.DataError(errorCode = response as Int)
//            }
//        }
    }

    override suspend fun requestDetailRecipe(id: String): Resource<RecipeDetailItem> {
        val recipeService = serviceGenerator.createService(RecipesService::class.java)
        val response = processCallParams(id,recipeService::fetchRecipesid)

        val inputAsArray = (response as? List<*>)?.filterIsInstance<RecipeItem>()
//        return if(inputAsArray!!.isNotEmpty()){
//            Resource.Success(data = inputAsArray)
//        }else{
//            Resource.DataError(errorCode = response as Int)
//        }
        return Resource.DataError(errorCode = response as Int)
    }





    private suspend fun processCallParams(
        responseCall: String,
        kSuspendFunction1: KSuspendFunction1<@ParameterName(
            name = "category"
        ) String, Response<List<RecipeItem>>>
    ): Any? {
        if (!isConnected(App.context)) {
            return NO_INTERNET_CONNECTION
        }
        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {
                response.body()

            } else {
                responseCode

            }
        } catch (e: IOException) {
            NETWORK_ERROR
        }
    }


    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
        if (!isConnected(App.context)) {
            return NO_INTERNET_CONNECTION
        }
        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {
                response.body()

            } else {
                responseCode

            }
        } catch (e: IOException) {
            NETWORK_ERROR
        }
    }
}