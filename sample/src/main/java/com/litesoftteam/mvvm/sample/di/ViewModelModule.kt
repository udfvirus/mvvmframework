package com.litesoftteam.mvvm.sample.di

import com.litesoftteam.mvvm.sample.presentation.viewmodel.DetailsViewModel
import com.litesoftteam.mvvm.sample.presentation.viewmodel.MainViewModel
import com.litesoftteam.mvvm.sample.presentation.viewmodel.MenuItemViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { MenuItemViewModel(get(), get()) }
    viewModel { DetailsViewModel(get()) }
}
