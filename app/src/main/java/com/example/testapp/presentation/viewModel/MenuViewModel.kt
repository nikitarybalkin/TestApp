package com.example.testapp.presentation.viewModel

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.domain.MenuUseCase
import com.example.testapp.domain.model.CategoriesModel
import com.example.testapp.domain.model.CategoryModel
import com.example.testapp.domain.model.FoodByCategoryModel
import com.example.testapp.domain.model.IngredientsModel
import com.example.testapp.domain.model.mapToDomain
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import javax.inject.Inject

class MenuViewModel @Inject constructor(private val menuUseCase: MenuUseCase): ViewModel() {
    var listOfCategories:MutableStateFlow<CategoriesModel?> = MutableStateFlow(null)
    var listOfFoodByCategory:MutableStateFlow<FoodByCategoryModel?> = MutableStateFlow(null)
    var listIngredients:MutableStateFlow<IngredientsModel?> = MutableStateFlow(null)
    fun getCategoriesMenu() {
        viewModelScope.launch {
            Log.d(TAG, "scope1 = $this")
            //Log.d(ContentValues.TAG, "${menuUseCase.getCategoriesMenu().categories[1].strCategory} vm")
            listOfCategories.value = menuUseCase.getCategoriesMenu()
        }
    }
    fun getFoodByCategory(name: String) {

        viewModelScope.launch {
            Log.d(TAG, "scope2 = $this")
            //Log.d(ContentValues.TAG, "${menuUseCase.getCategoriesMenu().categories[1].strCategory} vm")
            listOfFoodByCategory.value = menuUseCase.getMenuByCategory(name)
            Log.d(TAG, "getbycategory ${menuUseCase.getMenuByCategory(name).meals[0]}")
        }
    }
    fun getIngredients(id: String) {
        Log.d(TAG, "дошло3")
        viewModelScope.launch {
            Log.d(TAG, "scope3 = $this")
            listIngredients.value = menuUseCase.getIngredients(id)
            Log.d(TAG, "дошло4")
            Log.d(TAG, "vm = ${menuUseCase.getIngredients(id)}")
        }
    }


}