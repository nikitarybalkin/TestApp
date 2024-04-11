package com.example.testapp.domain

import android.content.ContentValues
import android.util.Log
import com.example.testapp.data.MenuRepositoryImpl
import com.example.testapp.domain.model.CategoriesModel
import com.example.testapp.domain.model.CategoryModel
import com.example.testapp.domain.model.FoodByCategoryModel
import com.example.testapp.domain.model.FoodModel
import com.example.testapp.domain.model.MenuModel
import com.example.testapp.domain.model.mapToDomain
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MenuUseCase @Inject constructor(private val menuRepositoryImpl: MenuRepositoryImpl) {

    suspend fun getCategoriesMenu(): CategoriesModel {
        return menuRepositoryImpl.getCategoriesMenu()
    }

    suspend fun getAllMenu(): FoodModel {
        return menuRepositoryImpl.getAllMenu()
    }

    suspend fun getIngredients(id: String): FoodModel {
        return menuRepositoryImpl.getIngredients(id)
    }

    suspend fun insert(table: MenuModel) {
        menuRepositoryImpl.insert(table)
    }
    fun getAllMenuFlow(): Flow<List<MenuModel>?> {
        return menuRepositoryImpl.getAllMenuFlow()
    }

}