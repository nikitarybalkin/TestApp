package com.example.testapp.data

import androidx.lifecycle.LiveData
import com.example.testapp.data.model.Categories
import com.example.testapp.data.model.Category
import com.example.testapp.data.model.Food

import com.example.testapp.data.model.Ingredients
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

interface MenuRemoteDataSource {

    suspend fun getCategoriesMenu(): Categories

    suspend fun getAllMenu(): Food

    suspend fun getIngredients(id: String): Food

}