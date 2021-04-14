package com.litesoftteam.mvvm.sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.litesoftteam.mvvm.core.entity.Event
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