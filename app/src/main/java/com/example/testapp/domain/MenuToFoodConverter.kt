package com.example.testapp.domain

import com.example.testapp.data.model.MealXX
import com.example.testapp.domain.model.FoodModel
import com.example.testapp.domain.model.MenuModel

class MenuToFoodConverter {
    fun menuToFoodConverter(menu: MenuModel) : FoodModel {
        var list: MutableList<MealXX> = mutableListOf()
        list.add(MealXX(
            dateModified = menu.dateModified.toString(),
            idMeal = menu.idMeal.toString(),
            strArea = menu.strArea.toString(),
            strCategory = menu.strCategory.toString(),
            strCreativeCommonsConfirmed = menu.strCreativeCommonsConfirmed.toString(),
            strDrinkAlternate = menu.strDrinkAlternate.toString(),
            strImageSource = menu.strImageSource.toString(),
            strIngredient1 = menu.strIngredient1.toString(),
            strIngredient10 = menu.strIngredient10.toString(),
            strIngredient11 = menu.strIngredient11.toString(),
            strIngredient12 = menu.strIngredient12.toString(),
            strIngredient13 = menu.strIngredient13.toString(),
            strIngredient14 = menu.strIngredient14.toString(),
            strIngredient15 = menu.strIngredient15.toString(),
            strIngredient16 = menu.strIngredient16.toString(),
            strIngredient17 = menu.strIngredient17.toString(),
            strIngredient18 = menu.strIngredient18.toString(),
            strIngredient19 = menu.strIngredient19.toString(),
            strIngredient2 = menu.strIngredient2.toString(),
            strIngredient20 = menu.strIngredient20.toString(),
            strIngredient3 = menu.strIngredient3.toString(),
            strIngredient4 = menu.strIngredient4.toString(),
            strIngredient5 = menu.strIngredient5.toString(),
            strIngredient6 = menu.strIngredient6.toString(),
            strIngredient7 = menu.strIngredient7.toString(),
            strIngredient8 = menu.strIngredient8.toString(),
            strIngredient9 = menu.strIngredient9.toString(),
            strInstructions = menu.strInstructions.toString(),
            strMeal = menu.strMeal.toString(),
            strMealThumb = menu.strMealThumb.toString(),
            strMeasure1 = menu.strMeasure1.toString(),
            strMeasure10 = menu.strMeasure10.toString(),
            strMeasure11 = menu.strMeasure11.toString(),
            strMeasure12 = menu.strMeasure12.toString(),
            strMeasure13 = menu.strMeasure13.toString(),
            strMeasure14 = menu.strMeasure14.toString(),
            strMeasure15 = menu.strMeasure15.toString(),
            strMeasure16 = menu.strMeasure16.toString(),
            strMeasure17 = menu.strMeasure17.toString(),
            strMeasure18 = menu.strMeasure18.toString(),
            strMeasure19 = menu.strMeasure19.toString(),
            strMeasure2 = menu.strMeasure2.toString(),
            strMeasure20 = menu.strMeasure20.toString(),
            strMeasure3 = menu.strMeasure3.toString(),
            strMeasure4 = menu.strMeasure4.toString(),
            strMeasure5 = menu.strMeasure5.toString(),
            strMeasure6 = menu.strMeasure6.toString(),
            strMeasure7 = menu.strMeasure7.toString(),
            strMeasure8 = menu.strMeasure8.toString(),
            strMeasure9 = menu.strMeasure9.toString(),
            strSource = menu.strSource.toString(),
            strTags = menu.strTags.toString(),
            strYoutube = menu.strYoutube.toString()
        ))
        return FoodModel(list)
    }


}