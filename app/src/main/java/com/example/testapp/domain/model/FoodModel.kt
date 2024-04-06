package com.example.testapp.domain.model

import com.example.testapp.data.model.Food
import com.example.testapp.data.model.Ingredients
import com.example.testapp.data.model.MealX
import com.example.testapp.data.model.MealXX

class FoodModel(
    val meals: List<MealXX>
)
fun Food.mapToDomain() = FoodModel(
    meals
)

fun FoodModel.mapToData() = Food(
    meals
)