package com.example.testapp.presentation.adapter

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.testapp.R
import com.example.testapp.data.model.Categories
import com.example.testapp.databinding.ItemBannersBinding
import com.example.testapp.databinding.ItemCategoriesBinding
import com.example.testapp.domain.model.CategoriesModel
import com.example.testapp.domain.model.CategoryModel

class CategoriesAdapter(
    private val listOfCategories: List<String>,
    var switchCategory: (String) -> Unit,

): Adapter<CategoriesViewHolder>() {
    var numbOfB = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val binding = ItemCategoriesBinding.inflate(LayoutInflater.from(parent.context))
            switchCategory(listOfCategories[0])
            Log.d(TAG, "установила на первую категорию")

        return CategoriesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if ( listOfCategories != null ) {
            listOfCategories.size
        } else 0
    }


    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {

        holder.binding.bCategory.text = listOfCategories[position]
        holder.binding.bCategory.setOnClickListener{
            Log.d(TAG, "категория = ${holder.binding.bCategory.text}")
            switchCategory(listOfCategories[position])
        }

    }



}
class CategoriesViewHolder(val binding: ItemCategoriesBinding): ViewHolder(binding.root)