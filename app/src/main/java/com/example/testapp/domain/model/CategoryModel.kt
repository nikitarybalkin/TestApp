package com.example.testapp.domain.model

import com.example.testapp.data.model.Category

class CategoryModel(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String

)

fun Category.mapToDomain() = CategoryModel(
    idCategory,
    strCategory,
    strCategoryDescription,
    strCategoryThumb
)

fun CategoryModel.mapToData() = Category(
    idCategory,
    strCategory,
    strCategoryDescription,
    strCategoryThumb
)