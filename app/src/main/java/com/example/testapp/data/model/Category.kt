package com.example.testapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Category(
    @Json(name = "idCategory")val idCategory: String,
    @Json(name = "strCategory")val strCategory: String,
    @Json(name = "strCategoryDescription")val strCategoryDescription: String,
    @Json(name = "dateModified")val strCategoryThumb: String
)