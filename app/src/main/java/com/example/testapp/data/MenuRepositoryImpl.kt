package com.example.testapp.data

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.map
import com.example.testapp.data.model.Categories
import com.example.testapp.domain.MenuRepository
import com.example.testapp.domain.model.CategoriesModel
import com.example.testapp.domain.model.CategoryModel
import com.example.testapp.domain.model.FoodByCategoryModel
import com.example.testapp.domain.model.FoodModel
import com.example.testapp.domain.model.MenuModel
import com.example.testapp.domain.model.mapToData

import com.example.testapp.domain.model.mapToDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor(private val api: MenuRemoteDataSource, private val db: MenuLocalDataSource): MenuRepository {
    override suspend fun getCategoriesMenu(): CategoriesModel {
        return api.getCategoriesMenu().mapToDomain()
    }

    override suspend fun getAllMenu(): FoodModel {
        return api.getAllMenu().mapToDomain()
    }

    override fun getAllMenuFlow(): Flow<List<MenuModel>> {
        return db.getAll().map { it.map { list -> list.mapToDomain() } }
    }

    override suspend fun insert(table: MenuModel) {
        db.insert(table.mapToData())
    }

    override suspend fun getIngredients(id: String): FoodModel {
        return api.getIngredients(id).mapToDomain()
    }


}