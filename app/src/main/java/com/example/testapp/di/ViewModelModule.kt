package com.example.testapp.di

import androidx.lifecycle.ViewModel
import com.example.testapp.presentation.viewModel.BasketViewModel
import com.example.testapp.presentation.viewModel.MenuViewModel
import com.example.testapp.presentation.viewModel.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
interface ViewModelModule {

    @IntoMap
    @StringKey("MenuViewModel")
    @Binds
    fun bindsMenuViewModel(impl: MenuViewModel): ViewModel

    @IntoMap
    @StringKey("ProfileViewModel")
    @Binds
    fun bindsProfileViewModel(impl: ProfileViewModel): ViewModel

    @IntoMap
    @StringKey("BasketViewModel")
    @Binds
    fun bindsBasketViewModel(impl: BasketViewModel): ViewModel
}