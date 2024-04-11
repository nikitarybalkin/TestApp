package com.example.testapp.domain

import com.example.testapp.data.model.Categories
import com.example.testapp.domain.model.CategoriesModel
import com.example.testapp.domain.model.CategoryModel
import com.example.testapp.domain.model.FoodByCategoryModel
import com.example.testapp.domain.model.FoodModel
import com.example.testapp.domain.model.MenuModel
import kotlinx.coroutines.flow.Flow

interface MenuRepository {

    suspend fun getCategoriesMenu(): CategoriesModel

    suspend fun getAllMenu(): FoodModel

    fun getAllMenuFlow(): Flow<List<MenuModel>?>

    suspend fun insert(table: MenuModel)

    suspend fun getIngredients(nameOfFood: String): FoodModel

}