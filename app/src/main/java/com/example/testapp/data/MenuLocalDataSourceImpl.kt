package com.example.testapp.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MenuLocalDataSourceImpl @Inject constructor(private val db: MenuDAO): MenuLocalDataSource {
    override fun getAll(): Flow<List<MenuEntity>?> {
        return db.getAll()
    }

    override suspend fun insert(table: MenuEntity) {
        db.insert(table)
    }
}