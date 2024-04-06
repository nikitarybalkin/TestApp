package com.example.testapp.di

import android.app.Application

class App: Application() {
    //private lateinit var applicationComponent: ApplicationComponent
    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    /*fun getAppComponent(): ApplicationComponent {
        return applicationComponent
    }

     */
}