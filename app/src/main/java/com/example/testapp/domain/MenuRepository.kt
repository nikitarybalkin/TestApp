package com.example.testapp.domain

import com.example.testapp.data.model.Categories
import com.example.testapp.data.model.FoodByCategory
import com.example.testapp.domain.model.CategoriesModel
import com.example.testapp.domain.model.CategoryModel
import com.example.testapp.domain.model.FoodByCategoryModel
import com.example.testapp.domain.model.IngredientsModel
import kotlinx.coroutines.flow.Flow

interface MenuRepository {

    suspend fun getCategoriesMenu(): CategoriesModel

    suspend fun getMenuByCategory(nameOfCategory: String): FoodByCategoryModel

    suspend fun getIngredients(nameOfFood: String): IngredientsModel

}