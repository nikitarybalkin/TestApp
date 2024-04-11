package com.example.testapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MenuDAO {
        @Query("SELECT * FROM menuEntity")
        fun getAll(): Flow<List<MenuEntity>?>

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insert(menu: MenuEntity)
}