package com.example.testapp.di

import com.example.testapp.data.FoodAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    //@Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    //@Singleton
    fun provideMyApi(retrofit: Retrofit): FoodAPI {
        return retrofit.create(FoodAPI::class.java)
    }
}