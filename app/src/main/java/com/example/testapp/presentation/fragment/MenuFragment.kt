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
import com.example.testapp.presentation.adapter.BannersAdapter
import com.example.testapp.presentation.adapter.CategoriesAdapter
import com.example.testapp.presentation.adapter.FoodAdapter
import com.example.testapp.presentation.viewModel.MenuViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class MenuFragment : Fragment() {

    /*@Inject
    lateinit var foodAPI: FoodAPI

     */
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var binding: FragmentMenuBinding
    var listOfFoodForIngredients: MutableList<String> = mutableListOf()
    var listOfIngredients: MutableList<String> = mutableListOf()
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
        viewModel.getCategoriesMenu()
        //viewModel.getIngredients("52874")
        val adapter =
            BannersAdapter(listOf(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3))
        binding.rvBannners.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.listOfCategories.collect {
                if (it != null) {
                    Log.d(TAG, "collect")
                    val adapterCategories = CategoriesAdapter(
                        it,
                        { name -> switchCategory(name) }
                    )
                    binding.rvCategories.adapter = adapterCategories
                    viewModel.getFoodByCategory(it.categories[0].strCategory)
                    viewModel.listOfFoodByCategory.collect { foodBy ->
                        //if (foodBy == null) Log.d(TAG, "fb = null") else Log.d(TAG, "fb notnull")
                        if (foodBy != null) {
                            Log.d(TAG, "дошло")
                            for (i in 0..foodBy.meals.size-1) {
                                listOfFoodForIngredients.add(foodBy.meals[i].idMeal)
                            }
                            Log.d(TAG, "final ${listOfFoodForIngredients.toString()}")
                            viewModel.getIngredients(listOfFoodForIngredients[0])
                            var counter: Int = 0
                            viewLifecycleOwner.lifecycleScope.launch {
                                viewModel.listIngredients.collect {
                                    if (it != null) {
                                        if (counter == listOfFoodForIngredients.size) {
                                            val adapter3 = FoodAdapter(
                                                foodBy,
                                                requireActivity().applicationContext,
                                                listOfIngredients
                                            )
                                            binding.rvFood.adapter = adapter3
                                        } else {
                                            try {
                                                Log.d(TAG, "else")
                                                listOfIngredients.add(it!!.meals[0].strIngredient1 +", "+ it.meals[0].strIngredient2 + ", " + it.meals[0].strIngredient3 + ", "+ it.meals[0].strIngredient4 + ", " + it.meals[0].strIngredient5)
                                                counter++
                                                viewModel.getIngredients(listOfFoodForIngredients[counter-1])
                                            } catch (e: Exception) {
                                                Log.d(TAG, "sdf")
                                            }

                                        }
                                    }
                                }
                            }

                        }
                        /*viewModel.listIngredients.collect{
                            if (it!!.meals.isNotEmpty()) Log.d(TAG, "check ${it.meals[0].strIngredient1}")

                        }

                         */
                    }


                }

            }

        }

    }
    fun getIngredientsForPage() {
        var counter: Int = 0
        viewModel.getIngredients(listOfFoodForIngredients[counter])
        Log.d(TAG, "дошло2")
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.listIngredients.collect {
                if (it != null) {
                        while (counter != listOfFoodForIngredients.size) {

                        }
                        listOfIngredients.add(it!!.meals[counter].strIngredient1 + it.meals[counter].strIngredient2 + it.meals[counter].strIngredient3 + it.meals[counter].strIngredient4 + it.meals[counter].strIngredient5)
                        counter++
                        Log.d(TAG, "аяеее")
                        Log.d(TAG, "$counter - ${listOfIngredients.toString()}")
                }

            }
        }

    }
    fun startCollect() {
        var counter: Int = 0

    }



    fun switchCategory(nameOfCategory: String) {
        viewModel.getFoodByCategory(nameOfCategory)
    }

}
