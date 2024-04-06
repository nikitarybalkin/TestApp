package com.example.testapp.domain.model

import com.example.testapp.data.model.Categories
import com.example.testapp.data.model.Category

class CategoriesModel(
    val categories: List<Category>
)

fun Categories.mapToDomain() = CategoriesModel(
    categories
)

fun CategoriesModel.mapToData() = Categories(
    categories
)