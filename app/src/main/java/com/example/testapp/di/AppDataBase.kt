package com.example.testapp.di

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testapp.data.MenuDAO
import com.example.testapp.data.MealEntity
import com.example.testapp.data.MenuEntity


@Database(entities = [MenuEntity::class], version = 1, exportSchema = false)

abstract class AppDataBase : RoomDatabase() {
    abstract fun menuDao() : MenuDAO
}