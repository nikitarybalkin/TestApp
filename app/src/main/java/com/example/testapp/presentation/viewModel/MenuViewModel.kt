package com.example.testapp.presentation.viewModel

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.domain.MenuToFoodConverter
import com.example.testapp.domain.MenuUseCase
import com.example.testapp.domain.model.CategoriesModel
import com.example.testapp.domain.model.FoodByCategoryModel
import com.example.testapp.domain.model.FoodModel
import com.example.testapp.domain.model.MenuModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class MenuViewModel @Inject constructor(private val menuUseCase: MenuUseCase): ViewModel() {
    var listOfCategories:MutableStateFlow<CategoriesModel?> = MutableStateFlow(null)
    var listOfAllFood: MutableStateFlow<FoodModel?> = MutableStateFlow(null)
    var listOfAllFoodFlow: Flow<List<MenuModel>?> = flowOf()
    //var listIngredients:MutableStateFlow<FoodModel?> = MutableStateFlow(null)
    fun getCategoriesMenu() {
        viewModelScope.launch {
            Log.d(TAG, "scope1 = $this")
            //Log.d(ContentValues.TAG, "${menuUseCase.getCategoriesMenu().categories[1].strCategory} vm")
            listOfCategories.value = menuUseCase.getCategoriesMenu()
        }
    }
    fun getAllMenu() {
        viewModelScope.launch {
            listOfAllFood.value = menuUseCase.getAllMenu()
            listOfAllFood.collect {
                if (it?.meals?.isNotEmpty() == true) {
                    Log.d(TAG, "remote = not null")
                    menuUseCase.getAllMenuFlow().collect {
                        //Log.d(TAG, "list<MenuModel> = ${it!![0].strMeal}")
                        if (it?.isEmpty() == true) {
                            Log.d(TAG, "size  = ${listOfAllFood.value!!.meals.size}")
                            for (i in 0.. listOfAllFood.value!!.meals.size -1) {
                                insert(MenuToFoodConverter().foodToMenuConverter(listOfAllFood.value!!)[i])
                                Log.d(TAG, "Megasystem insert")
                            }

                        } else Log.d(TAG, "DB is not empty")
                        cancel()
                    }
                } else Log.d(TAG, "remote = null")
            }
        }

            Log.d(TAG, "пошла 2-ая")
            //listOfAllFoodFlow = menuUseCase.getAllMenuFlow()
            //Log.d(TAG, "getbycategory ${menuUseCase.getMenuByCategory(name).meals[0]}")

    }
    suspend fun getAllMenuFlow() {
        listOfAllFoodFlow = menuUseCase.getAllMenuFlow()
    }



    suspend fun insert(table: MenuModel) {
            menuUseCase.insert(table)
            Log.d(TAG, "in vm insert ${table.strMeal.toString()}")


    }


}