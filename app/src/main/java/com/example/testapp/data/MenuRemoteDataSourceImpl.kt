package com.example.testapp.data

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.testapp.data.model.Categories
import com.example.testapp.data.model.Category
import com.example.testapp.data.model.Food
import com.example.testapp.data.model.FoodByCategory
import com.example.testapp.data.model.Ingredients
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MenuRemoteDataSourceImpl @Inject constructor(private val api: FoodAPI): MenuRemoteDataSource {
    override suspend fun getCategoriesMenu(): Categories {

        return api.getCategoriesMenu()
    }

    override suspend fun getAllMenu(): Food {
        return api.getMenuByCategory()
    }

    override suspend fun getIngredients(id: String): Food {
        //Log.d(TAG, "aue ${api.getIngredients(id).meals[0]} dt")
        return api.getIngredients(id)
    }

}