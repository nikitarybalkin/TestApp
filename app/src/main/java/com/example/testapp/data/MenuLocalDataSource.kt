package com.example.testapp.data

import kotlinx.coroutines.flow.Flow

interface MenuLocalDataSource {
        fun getAll(): Flow<List<MenuEntity>>

        suspend fun insert(table: MenuEntity)
}