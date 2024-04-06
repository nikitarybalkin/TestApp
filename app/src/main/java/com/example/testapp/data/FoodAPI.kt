package com.example.testapp.data

import androidx.lifecycle.LiveData
import com.example.testapp.data.model.Categories
import com.example.testapp.data.model.Category
import com.example.testapp.data.model.Food
import com.example.testapp.data.model.FoodByCategory
import com.example.testapp.data.model.Ingredients
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://www.themealdb.com/"

/*object Retrofit_Instance {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api : FoodAPI = retrofit.create(
        FoodAPI::class.java
    )
}

 */

interface FoodAPI {
    @GET("/api/json/v1/1/categories.php")
    suspend fun getCategoriesMenu(): Categories

    @GET("/api/json/v1/1/search.php?s")
    suspend fun getMenuByCategory(): Food

    @GET("/api/json/v1/1/lookup.php?")
    suspend fun getIngredients(
        @Query("i") id: String
    ): Food
}