package com.example.testapp.domain.model

import com.example.testapp.data.model.Categories
import com.example.testapp.data.model.Ingredients
import com.example.testapp.data.model.MealX

class IngredientsModel(
    val meals: List<MealX>
)
fun Ingredients.mapToDomain() = IngredientsModel(
    meals
)

fun IngredientsModel.mapToData() = Ingredients(
    meals
)