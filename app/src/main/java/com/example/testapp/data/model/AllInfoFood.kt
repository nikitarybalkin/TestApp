package com.example.testapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Ingredients(
    @Json(name = "meals")val meals: List<MealX>
)