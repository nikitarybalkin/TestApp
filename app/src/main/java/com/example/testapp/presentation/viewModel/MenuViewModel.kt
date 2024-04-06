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
    var listOfAllFoodFlow: Flow<List<MenuModel?>> = flowOf()
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

            try {
                listOfAllFood.value = menuUseCase.getAllMenu()
            } catch (e: Exception) {
                getAllMenuFlow()
            }

            Log.d(TAG, "пошла 2-ая")
            //listOfAllFoodFlow = menuUseCase.getAllMenuFlow()
            //Log.d(TAG, "getbycategory ${menuUseCase.getMenuByCategory(name).meals[0]}")
        }
    }
    suspend fun getAllMenuFlow() {
        listOfAllFoodFlow = menuUseCase.getAllMenuFlow()
    }

    fun insert(table: MenuModel) {
        viewModelScope.launch{
            menuUseCase.insert(table)
            Log.d(TAG, "in vm insert ${table.toString()}")
            cancel()
        }
    }


}