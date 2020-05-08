package com.examgorilla.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RecipeDetailItem(
      @Json(name = "id")
      val id : Int = 0,
      @Json(name = "title")
      val title : String = "",
      @Json(name = "rating")
      val rating : Int = 0,
      @Json(name = "image")
      val image : String = "",
      @Json(name = "instructions")
      val instructions : String = ""
)