package com.example.testapp.di

import com.example.testapp.data.MenuRemoteDataSource
import com.example.testapp.data.MenuRemoteDataSourceImpl
import com.example.testapp.data.MenuRepositoryImpl
import com.example.testapp.domain.MenuRepository
import dagger.Module
import dagger.Provides

@Module
class ApiModule {

    @Provides
    fun provideMenuDataSource(menuRemoteDataSource: MenuRemoteDataSourceImpl): MenuRemoteDataSource {
        return menuRemoteDataSource
    }

    @Provides
    fun provideMenuRepository(menuRepository: MenuRepositoryImpl): MenuRepository {
        return menuRepository
    }

}