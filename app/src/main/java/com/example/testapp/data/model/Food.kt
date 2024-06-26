package com.example.testapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Food(
    @Json(name = "meals")val meals: List<MealXX>
)