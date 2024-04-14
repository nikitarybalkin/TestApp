package com.example.testapp.domain

import com.example.testapp.data.model.MealXX
import com.example.testapp.domain.model.FoodModel
import com.example.testapp.domain.model.MenuModel

class MenuToFoodConverter {
    fun menuToFoodConverter(menu: List<MenuModel>) : FoodModel {
        var list: MutableList<MealXX> = mutableListOf()
        for (i in 0..menu.size-1) {
            list.add(
                MealXX(
                    dateModified = menu[i].dateModified.toString(),
                    idMeal = menu[i].idMeal.toString(),
                    strArea = menu[i].strArea.toString(),
                    strCategory = menu[i].strCategory.toString(),
                    strCreativeCommonsConfirmed = menu[i].strCreativeCommonsConfirmed.toString(),
                    strDrinkAlternate = menu[i].strDrinkAlternate.toString(),
                    strImageSource = menu[i].strImageSource.toString(),
                    strIngredient1 = menu[i].strIngredient1.toString(),
                    strIngredient10 = menu[i].strIngredient10.toString(),
                    strIngredient11 = menu[i].strIngredient11.toString(),
                    strIngredient12 = menu[i].strIngredient12.toString(),
                    strIngredient13 = menu[i].strIngredient13.toString(),
                    strIngredient14 = menu[i].strIngredient14.toString(),
                    strIngredient15 = menu[i].strIngredient15.toString(),
                    strIngredient16 = menu[i].strIngredient16.toString(),
                    strIngredient17 = menu[i].strIngredient17.toString(),
                    strIngredient18 = menu[i].strIngredient18.toString(),
                    strIngredient19 = menu[i].strIngredient19.toString(),
                    strIngredient2 = menu[i].strIngredient2.toString(),
                    strIngredient20 = menu[i].strIngredient20.toString(),
                    strIngredient3 = menu[i].strIngredient3.toString(),
                    strIngredient4 = menu[i].strIngredient4.toString(),
                    strIngredient5 = menu[i].strIngredient5.toString(),
                    strIngredient6 = menu[i].strIngredient6.toString(),
                    strIngredient7 = menu[i].strIngredient7.toString(),
                    strIngredient8 = menu[i].strIngredient8.toString(),
                    strIngredient9 = menu[i].strIngredient9.toString(),
                    strInstructions = menu[i].strInstructions.toString(),
                    strMeal = menu[i].strMeal.toString(),
                    strMealThumb = menu[i].strMealThumb.toString(),
                    strMeasure1 = menu[i].strMeasure1.toString(),
                    strMeasure10 = menu[i].strMeasure10.toString(),
                    strMeasure11 = menu[i].strMeasure11.toString(),
                    strMeasure12 = menu[i].strMeasure12.toString(),
                    strMeasure13 = menu[i].strMeasure13.toString(),
                    strMeasure14 = menu[i].strMeasure14.toString(),
                    strMeasure15 = menu[i].strMeasure15.toString(),
                    strMeasure16 = menu[i].strMeasure16.toString(),
                    strMeasure17 = menu[i].strMeasure17.toString(),
                    strMeasure18 = menu[i].strMeasure18.toString(),
                    strMeasure19 = menu[i].strMeasure19.toString(),
                    strMeasure2 = menu[i].strMeasure2.toString(),
                    strMeasure20 = menu[i].strMeasure20.toString(),
                    strMeasure3 = menu[i].strMeasure3.toString(),
                    strMeasure4 = menu[i].strMeasure4.toString(),
                    strMeasure5 = menu[i].strMeasure5.toString(),
                    strMeasure6 = menu[i].strMeasure6.toString(),
                    strMeasure7 = menu[i].strMeasure7.toString(),
                    strMeasure8 = menu[i].strMeasure8.toString(),
                    strMeasure9 = menu[i].strMeasure9.toString(),
                    strSource = menu[i].strSource.toString(),
                    strTags = menu[i].strTags.toString(),
                    strYoutube = menu[i].strYoutube.toString()
                )
            )
        }
        return FoodModel(list)
    }
    fun foodToMenuConverter(menu: FoodModel) : List<MenuModel> {
        var list: MutableList<MenuModel> = mutableListOf()
        for (i in 0..menu.meals.size - 1) {
            list.add(
                MenuModel(
                    dateModified = menu.meals[i].dateModified.toString(),
                    idMeal = menu.meals[i].idMeal,
                    strArea = menu.meals[i].strArea,
                    strCategory = menu.meals[i].strCategory,
                    strCreativeCommonsConfirmed = menu.meals[i].strCreativeCommonsConfirmed.toString(),
                    strDrinkAlternate = menu.meals[i].strDrinkAlternate.toString(),
                    strImageSource = menu.meals[i].strImageSource.toString(),
                    strIngredient1 = menu.meals[i].strIngredient1,
                    strIngredient10 = menu.meals[i].strIngredient10,
                    strIngredient11 = menu.meals[i].strIngredient11,
                    strIngredient12 = menu.meals[i].strIngredient12,
                    strIngredient13 = menu.meals[i].strIngredient13,
                    strIngredient14 = menu.meals[i].strIngredient14,
                    strIngredient15 = menu.meals[i].strIngredient15,
                    strIngredient16 = menu.meals[i].strIngredient16,
                    strIngredient17 = menu.meals[i].strIngredient17,
                    strIngredient18 = menu.meals[i].strIngredient18,
                    strIngredient19 = menu.meals[i].strIngredient19,
                    strIngredient2 = menu.meals[i].strIngredient2,
                    strIngredient20 = menu.meals[i].strIngredient20,
                    strIngredient3 = menu.meals[i].strIngredient3,
                    strIngredient4 = menu.meals[i].strIngredient4,
                    strIngredient5 = menu.meals[i].strIngredient5,
                    strIngredient6 = menu.meals[i].strIngredient6,
                    strIngredient7 = menu.meals[i].strIngredient7,
                    strIngredient8 = menu.meals[i].strIngredient8,
                    strIngredient9 = menu.meals[i].strIngredient9,
                    strInstructions = menu.meals[i].strInstructions,
                    strMeal = menu.meals[i].strMeal,
                    strMealThumb = menu.meals[i].strMealThumb,
                    strMeasure1 = menu.meals[i].strMeasure1,
                    strMeasure10 = menu.meals[i].strMeasure10,
                    strMeasure11 = menu.meals[i].strMeasure11,
                    strMeasure12 = menu.meals[i].strMeasure12,
                    strMeasure13 = menu.meals[i].strMeasure13,
                    strMeasure14 = menu.meals[i].strMeasure14,
                    strMeasure15 = menu.meals[i].strMeasure15,
                    strMeasure16 = menu.meals[i].strMeasure16,
                    strMeasure17 = menu.meals[i].strMeasure17,
                    strMeasure18 = menu.meals[i].strMeasure18,
                    strMeasure19 = menu.meals[i].strMeasure19,
                    strMeasure2 = menu.meals[i].strMeasure2,
                    strMeasure20 = menu.meals[i].strMeasure20,
                    strMeasure3 = menu.meals[i].strMeasure3,
                    strMeasure4 = menu.meals[i].strMeasure4,
                    strMeasure5 = menu.meals[i].strMeasure5,
                    strMeasure6 = menu.meals[i].strMeasure6,
                    strMeasure7 = menu.meals[i].strMeasure7,
                    strMeasure8 = menu.meals[i].strMeasure8,
                    strMeasure9 = menu.meals[i].strMeasure9,
                    strSource = menu.meals[i].strSource,
                    strTags = menu.meals[i].strTags,
                    strYoutube = menu.meals[i].strYoutube
                )
            )
        }
        return list
    }

}