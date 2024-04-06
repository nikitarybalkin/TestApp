package com.example.testapp.di

import android.content.Context
import androidx.room.Room
import com.example.testapp.data.MenuDAO
import com.example.testapp.data.MenuLocalDataSource
import com.example.testapp.data.MenuLocalDataSourceImpl
import dagger.Module
import dagger.Provides

@Module
class DataBaseModule {

    @Provides
    fun provideMenuLocalDataSource(impl: MenuLocalDataSourceImpl): MenuLocalDataSource {
        return impl
    }

    @Provides
    fun provideMenuDataBase(context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, "db")
            .fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideExerciseDao(db: AppDataBase): MenuDAO {
        return db.menuDao()
    }
}