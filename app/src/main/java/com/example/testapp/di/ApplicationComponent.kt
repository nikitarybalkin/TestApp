package com.example.testapp.di
import android.content.Context
import com.example.testapp.data.FoodAPI
import com.example.testapp.presentation.fragment.BasketFragment
import com.example.testapp.presentation.fragment.MenuFragment
import com.example.testapp.presentation.fragment.ProfileFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ViewModelModule::class, ApiModule::class, NetworkModule::class, DataBaseModule::class])
interface ApplicationComponent {

    fun inject(fragment: MenuFragment)

    fun inject(fragment: BasketFragment)

    fun inject(fragment: ProfileFragment)

    fun foodAPI(): FoodAPI

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}