package com.example.testapp.presentation.fragment

import android.content.ContentValues.TAG
import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.testapp.R
import com.example.testapp.databinding.FragmentMenuBinding
import com.example.testapp.di.App
import com.example.testapp.di.ViewModelFactory
import com.example.testapp.domain.MenuToFoodConverter
import com.example.testapp.domain.model.FoodModel
import com.example.testapp.domain.model.MenuModel
import com.example.testapp.presentation.adapter.BannersAdapter
import com.example.testapp.presentation.adapter.CategoriesAdapter
import com.example.testapp.presentation.adapter.FoodAdapter
import com.example.testapp.presentation.viewModel.MenuViewModel
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
        val connectivityManager =
            requireActivity().applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected) { //Проверка, подключен ли телефон к интернету
            viewModel.getCategoriesMenu()
            viewModel.getAllMenu()
            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                viewModel.listOfCategories.collect {
                    if (it?.categories?.isNotEmpty() == true) {
                        var listOfCategories: MutableList<String> = mutableListOf()
                        for (i in 0..it.categories.size - 1) {
                            listOfCategories.add(it.categories[i].strCategory)
                        }
                        val adapterCategories = CategoriesAdapter(
                            listOfCategories,
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
                    if (it?.meals?.isNotEmpty() == true) {
                        foodModel = it
                        switchCategory(nameOfCategory1)
                    }
                }
            }
        } else { // Если нет интернета, то пытаемся загрузить ранее сохранённые данные
            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                viewModel.getAllMenuFlow()
                viewModel.listOfAllFoodFlow.collect {
                    if (it?.isNotEmpty() == true) {
                        val adapterCategories = CategoriesAdapter(
                            filterCategories(it),
                            { name -> switchCategory(name) }
                        )
                        binding.rvCategories.adapter = adapterCategories
                        foodModel = MenuToFoodConverter().menuToFoodConverter(it)
                        switchCategory(nameOfCategory1)

                    } else Toast.makeText(
                        requireActivity().applicationContext,
                        "${R.string.turn_on_internet}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
    }

    fun filterCategories(startList: List<MenuModel>): List<String> {
        var list: MutableList<String> = mutableListOf()
        for (i in 0..<startList.size) {
            if (!list.contains(startList[i].strCategory)) {
                list.add(startList[i].strCategory.toString())
            }
        }
        return list
    }

    fun switchCategory(nameOfCategory: String) {
        nameOfCategory1 = nameOfCategory
        if (foodModel != null) {
            sortByCategory(
                listAll = foodModel!!,
                nameOfCategory1
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
