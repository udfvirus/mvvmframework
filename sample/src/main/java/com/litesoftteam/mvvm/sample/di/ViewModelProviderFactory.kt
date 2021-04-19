package com.litesoftteam.mvvm.sample.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.litesoftteam.mvvm.di.NavigationFactory
import com.litesoftteam.mvvm.sample.presentation.viewmodel.MainViewModel
import com.litesoftteam.mvvm.sample.presentation.viewmodel.UserListViewModel

object ViewModelProviderFactory {

    fun createMainViewModel() = object : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                return MainViewModel(NavigationFactory.getRouter()) as T
            }

            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

    fun createUserListViewModel() = object : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(UserListViewModel::class.java)) {
                return UserListViewModel(NavigationFactory.getRouter()) as T
            }

            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}