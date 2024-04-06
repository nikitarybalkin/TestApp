package com.example.testapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testapp.data.model.MealXX

//@Entity(tableName = "menuEntity")
data class MealEntity(
    //@PrimaryKey(autoGenerate = true)
    //@ColumnInfo
    val id: Int = 0,
    //@ColumnInfo(name = "mealXX")
    val mealXX: List<MealXX>,

)
