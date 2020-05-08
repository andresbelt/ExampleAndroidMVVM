package com.examgorilla.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RecipeItem(
    @Json(name = "id")
    val id: String = "",
    @Json(name = "title")
    val title: String = "")
