package com.litesoftteam.mvvm.sample.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.litesoftteam.mvvm.core.entity.Event
import com.litesoftteam.mvvm.sample.core.entity.User
import com.litesoftteam.mvvm.sample.data.repository.LocalUserRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _usersLiveData = MutableLiveData<Event<List<User>>>()

    val usersLiveData: LiveData<Event<List<User>>> = _usersLiveData

    fun loadUsers() {
        viewModelScope.launch {
            _usersLiveData.postValue(LocalUserRepository().getAllUsers())
        }
    }
}