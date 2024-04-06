package com.example.testapp.presentation.fragment

import android.Manifest
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import android.content.pm.PackageManager
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.testapp.R
import com.example.testapp.data.FoodAPI
import com.example.testapp.databinding.FragmentMenuBinding
import com.example.testapp.di.App
import com.example.testapp.di.ViewModelFactory
import com.example.testapp.domain.model.FoodModel
import com.example.testapp.domain.model.MenuModel
import com.example.testapp.presentation.adapter.BannersAdapter
import com.example.testapp.presentation.adapter.CategoriesAdapter
import com.example.testapp.presentation.adapter.FoodAdapter
import com.example.testapp.presentation.viewModel.MenuViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class MenuFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var binding: FragmentMenuBinding
    var listOfNamesOfFood: MutableList<String> = mutableListOf()
    var listOfURLOfFood: MutableList<String> = mutableListOf()
    var listOfIngredients: MutableList<String> = mutableListOf()
    var nameOfCategory1: String = ""
    var foodModel: FoodModel? = null
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MenuViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        viewModel.getCategoriesMenu()
        viewModel.getAllMenu()
        return binding.root
    }

    override fun onAttach(context: Context) {
        (requireActivity().applicationContext as App).component.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var nameOfCategory: String = ""

        val adapter =
            BannersAdapter(listOf(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3))
        binding.rvBannners.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.listOfCategories.collect {
                if (it != null) {
                    val adapterCategories = CategoriesAdapter(
                        it,
                        { name -> switchCategory(name) }
                    )
                    binding.rvCategories.adapter = adapterCategories
                }

            }
        }
        foodModel?.let {
            sortByCategory(listAll = it, nameOfCategory = nameOfCategory1)
        }
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.listOfAllFood.collect {
                if (it != null) {
                    foodModel = it
                    switchCategory(nameOfCategory1)
                    viewModel.getAllMenuFlow()
                    viewModel.insert(createEntity(0))
                    viewModel.listOfAllFoodFlow.collect {
                        if (it.isNotEmpty()) {
                            if (it[it.lastIndex] == null) {
                                viewModel.insert(createEntity(0))
                            }

                        }

                    }
                }

            }
        }

    }



    fun createEntity(numbOfMeal: Int): MenuModel {
        return MenuModel(
            dateModified = foodModel?.meals?.get(numbOfMeal)?.dateModified.toString(),
            idMeal = foodModel?.meals?.get(numbOfMeal)?.idMeal,
            strArea = foodModel?.meals?.get(numbOfMeal)?.strArea,
            strCategory = foodModel?.meals?.get(numbOfMeal)?.strCategory,
            strCreativeCommonsConfirmed = foodModel?.meals?.get(numbOfMeal)?.strCreativeCommonsConfirmed.toString(),
            strDrinkAlternate = foodModel?.meals?.get(numbOfMeal)?.strDrinkAlternate.toString(),
            strImageSource = foodModel?.meals?.get(numbOfMeal)?.strImageSource.toString(),
            strIngredient1 = foodModel?.meals?.get(numbOfMeal)?.strIngredient1,
            strIngredient10 = foodModel?.meals?.get(numbOfMeal)?.strIngredient10,
            strIngredient11 = foodModel?.meals?.get(numbOfMeal)?.strIngredient11,
            strIngredient12 = foodModel?.meals?.get(numbOfMeal)?.strIngredient12,
            strIngredient13 = foodModel?.meals?.get(numbOfMeal)?.strIngredient13,
            strIngredient14 = foodModel?.meals?.get(numbOfMeal)?.strIngredient14,
            strIngredient15 = foodModel?.meals?.get(numbOfMeal)?.strIngredient15,
            strIngredient16 = foodModel?.meals?.get(numbOfMeal)?.strIngredient16,
            strIngredient17 = foodModel?.meals?.get(numbOfMeal)?.strIngredient17,
            strIngredient18 = foodModel?.meals?.get(numbOfMeal)?.strIngredient18,
            strIngredient19 = foodModel?.meals?.get(numbOfMeal)?.strIngredient19,
            strIngredient2 = foodModel?.meals?.get(numbOfMeal)?.strIngredient2,
            strIngredient20 = foodModel?.meals?.get(numbOfMeal)?.strIngredient20,
            strIngredient3 = foodModel?.meals?.get(numbOfMeal)?.strIngredient3,
            strIngredient4 = foodModel?.meals?.get(numbOfMeal)?.strIngredient4,
            strIngredient5 = foodModel?.meals?.get(numbOfMeal)?.strIngredient5,
            strIngredient6 = foodModel?.meals?.get(numbOfMeal)?.strIngredient6,
            strIngredient7 = foodModel?.meals?.get(numbOfMeal)?.strIngredient7,
            strIngredient8 = foodModel?.meals?.get(numbOfMeal)?.strIngredient8,
            strIngredient9 = foodModel?.meals?.get(numbOfMeal)?.strIngredient9,
            strInstructions = foodModel?.meals?.get(numbOfMeal)?.strInstructions,
            strMeal = foodModel?.meals?.get(numbOfMeal)?.strMeal,
            strMealThumb = foodModel?.meals?.get(numbOfMeal)?.strMealThumb,
            strMeasure1 = foodModel?.meals?.get(numbOfMeal)?.strMeasure1,
            strMeasure10 = foodModel?.meals?.get(numbOfMeal)?.strMeasure10,
            strMeasure11 = foodModel?.meals?.get(numbOfMeal)?.strMeasure11,
            strMeasure12 = foodModel?.meals?.get(numbOfMeal)?.strMeasure12,
            strMeasure13 = foodModel?.meals?.get(numbOfMeal)?.strMeasure13,
            strMeasure14 = foodModel?.meals?.get(numbOfMeal)?.strMeasure14,
            strMeasure15 = foodModel?.meals?.get(numbOfMeal)?.strMeasure15,
            strMeasure16 = foodModel?.meals?.get(numbOfMeal)?.strMeasure16,
            strMeasure17 = foodModel?.meals?.get(numbOfMeal)?.strMeasure17,
            strMeasure18 = foodModel?.meals?.get(numbOfMeal)?.strMeasure18,
            strMeasure19 = foodModel?.meals?.get(numbOfMeal)?.strMeasure19,
            strMeasure2 = foodModel?.meals?.get(numbOfMeal)?.strMeasure2,
            strMeasure20 = foodModel?.meals?.get(numbOfMeal)?.strMeasure20,
            strMeasure3 = foodModel?.meals?.get(numbOfMeal)?.strMeasure3,
            strMeasure4 = foodModel?.meals?.get(numbOfMeal)?.strMeasure4,
            strMeasure5 = foodModel?.meals?.get(numbOfMeal)?.strMeasure5,
            strMeasure6 = foodModel?.meals?.get(numbOfMeal)?.strMeasure6,
            strMeasure7 = foodModel?.meals?.get(numbOfMeal)?.strMeasure7,
            strMeasure8 = foodModel?.meals?.get(numbOfMeal)?.strMeasure8,
            strMeasure9 = foodModel?.meals?.get(numbOfMeal)?.strMeasure9,
            strSource = foodModel?.meals?.get(numbOfMeal)?.strSource,
            strTags = foodModel?.meals?.get(numbOfMeal)?.strTags,
            strYoutube = foodModel?.meals?.get(numbOfMeal)?.strYoutube
        )
    }

    fun saveNameOFCat(nameOfCategory: String) {
        nameOfCategory1 = nameOfCategory
    }

    fun switchCategory(nameOfCategory: String) {
        if (foodModel != null) {
            sortByCategory(
                listAll = foodModel!!,
                nameOfCategory
            )
        }

    }

    fun sortByCategory(listAll: FoodModel, nameOfCategory: String) {
        listOfNamesOfFood = mutableListOf()
        listOfURLOfFood = mutableListOf()
        listOfIngredients = mutableListOf()
        for (i in 0..listAll.meals.size - 1) {
            if (listAll.meals[i].strCategory == nameOfCategory) {

                listOfNamesOfFood.add(listAll.meals[i].strMeal)
                listOfURLOfFood.add(listAll.meals[i].strMealThumb)
                listOfIngredients.add(listAll.meals[i].strIngredient1 + ", " + listAll.meals[i].strIngredient2 + ", " + listAll.meals[i].strIngredient3 + ", " + listAll.meals[i].strIngredient4 + ", " + listAll.meals[i].strIngredient5)
            }
        }
        val adapterFood = FoodAdapter(
            context = requireActivity().applicationContext,
            listOfIngredients = listOfIngredients,
            listOfNames = listOfNamesOfFood,
            listOfURLFood = listOfURLOfFood
        )
        binding.rvFood.adapter = adapterFood
    }

}
