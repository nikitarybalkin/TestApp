package com.example.testapp.data

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.map
import com.example.testapp.data.model.Categories
import com.example.testapp.domain.MenuRepository
import com.example.testapp.domain.model.CategoriesModel
import com.example.testapp.domain.model.CategoryModel
import com.example.testapp.domain.model.FoodByCategoryModel
import com.example.testapp.domain.model.IngredientsModel
import com.example.testapp.domain.model.mapToDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor(private val api: MenuRemoteDataSource): MenuRepository {
    override suspend fun getCategoriesMenu(): CategoriesModel {
        return api.getCategoriesMenu().mapToDomain()
    }

    override suspend fun getMenuByCategory(nameOfCategory: String): FoodByCategoryModel {
        return api.getMenuByCategory(nameOfCategory).mapToDomain()
    }

    override suspend fun getIngredients(id: String): IngredientsModel {
        return api.getIngredients(id).mapToDomain()
    }


}