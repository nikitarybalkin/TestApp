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

class MenuViewModel @Inject constructor(private val menuUseCase: MenuUseCase) : ViewModel() {
    var listOfCategories: MutableStateFlow<CategoriesModel?> = MutableStateFlow(null)
    var listOfAllFood: MutableStateFlow<FoodModel?> = MutableStateFlow(null)
    var listOfAllFoodFlow: Flow<List<MenuModel>?> = flowOf()

    fun getCategoriesMenu() {
        viewModelScope.launch {
            listOfCategories.value = menuUseCase.getCategoriesMenu()
        }
    }

    fun getAllMenu() {
        viewModelScope.launch {
            listOfAllFood.value = menuUseCase.getAllMenu()
            listOfAllFood.collect {
                if (it?.meals?.isNotEmpty() == true) {
                    menuUseCase.getAllMenuFlow().collect {
                        if (it?.isEmpty() == true) {
                            for (i in 0..listOfAllFood.value!!.meals.size - 1) {
                                insert(MenuToFoodConverter().foodToMenuConverter(listOfAllFood.value!!)[i])
                            }

                        }
                        cancel()
                    }
                }
            }
        }
    }

    suspend fun getAllMenuFlow() {
        listOfAllFoodFlow = menuUseCase.getAllMenuFlow()
    }

    suspend fun insert(table: MenuModel) {
        menuUseCase.insert(table)
    }
}