package com.example.testapp.presentation.adapter

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.testapp.databinding.ItemBannersBinding

class BannersAdapter(private val listOfBanners: List<Int>): Adapter<BannersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannersViewHolder {
        val binding = ItemBannersBinding.inflate(LayoutInflater.from(parent.context))
        return BannersViewHolder(binding)

    }

    override fun getItemCount(): Int = listOfBanners.size

    override fun onBindViewHolder(holder: BannersViewHolder, position: Int) {
        holder.binding.let {
            it.ivBanner.setImageResource(listOfBanners[position])
        }
    }
}

class BannersViewHolder(val binding: ItemBannersBinding): ViewHolder(binding.root)