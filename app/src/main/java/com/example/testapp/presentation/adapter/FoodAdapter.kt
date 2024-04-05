package com.example.testapp.presentation.adapter

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.testapp.data.model.FoodByCategory
import com.example.testapp.data.model.Ingredients
import com.example.testapp.databinding.ItemFoodBinding
import com.example.testapp.domain.model.FoodByCategoryModel
import com.example.testapp.domain.model.IngredientsModel

class FoodAdapter(
    private val listOfMeals: FoodByCategoryModel?,
    private val context: Context,
    private val listOfIngredients: List<String>
): Adapter<FoodViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context))
        return FoodViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (listOfMeals != null) {
            listOfMeals.meals.size
        } else {
            Log.d(TAG, "size = 0")
            return 0
        }
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.binding.let {

            it.tvName.text = listOfMeals!!.meals[position].strMeal
            //Log.d(TAG, "adapter")
            Log.d(TAG, listOfMeals.toString())
            it.tvDescription.text = listOfIngredients[position]

            Glide
                .with(context)
                .load(listOfMeals.meals[position].strMealThumb)
                .into(it.ivFood)
        }
    }

}

class FoodViewHolder(val binding: ItemFoodBinding): ViewHolder(binding.root)