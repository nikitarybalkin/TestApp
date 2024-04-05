package com.example.testapp.data

import androidx.lifecycle.LiveData
import com.example.testapp.data.model.Categories
import com.example.testapp.data.model.Category
import com.example.testapp.data.model.FoodByCategory
import com.example.testapp.data.model.Ingredients
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

interface MenuRemoteDataSource {

    suspend fun getCategoriesMenu(): Categories

    suspend fun getMenuByCategory(nameOfCategory: String): FoodByCategory

    suspend fun getIngredients(id: String): Ingredients

}