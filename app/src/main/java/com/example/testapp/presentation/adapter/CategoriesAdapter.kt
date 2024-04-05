package com.example.testapp.presentation.adapter

import android.annotation.SuppressLint
import android.content.ContentValues
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
    private val listOfCategories: CategoriesModel?,
    var switchCategory: (String) -> Unit,

): Adapter<CategoriesViewHolder>() {
    var numbOfB = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val binding = ItemCategoriesBinding.inflate(LayoutInflater.from(parent.context))
        return CategoriesViewHolder(binding)
    }

    override fun getItemCount(): Int /* = listOfCategories!!.categories.size*/{
        return if ( listOfCategories != null ) {
            listOfCategories.categories.size
        } else 0
    }


    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {

        holder.binding.bCategory.text = listOfCategories!!.categories[position].strCategory
        holder.binding.bCategory.setOnClickListener{
            switchCategory(listOfCategories.categories[position].strCategory)
            holder.binding.bCategory.setBackgroundColor(R.color.pink)
            numbOfB = holder.oldPosition
        }
        /*if (position == numbOfB) {
            holder.binding.bCategory.setBackgroundColor(R.color.white_40)
        }

         */


    }



}
class CategoriesViewHolder(val binding: ItemCategoriesBinding): ViewHolder(binding.root)