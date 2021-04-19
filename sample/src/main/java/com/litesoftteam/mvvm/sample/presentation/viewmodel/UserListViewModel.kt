package com.litesoftteam.mvvm.sample.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.viewModelScope
import com.litesoftteam.mvvm.core.entity.Event
import com.litesoftteam.mvvm.presentation.viewmodel.BaseViewModel
import com.litesoftteam.mvvm.sample.core.entity.User
import com.litesoftteam.mvvm.sample.data.repository.LocalUserRepository
import com.litesoftteam.mvvm.sample.presentation.navigation.screen.DetailsScreen
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.terrakok.cicerone.Router

class UserListViewModel(router: Router) : BaseViewModel(router) {

    private val _usersLiveData = MutableLiveData<Event<List<User>>>()

    val usersLiveData: LiveData<Event<List<User>>> = _usersLiveData

    fun loadUsers() {
        viewModelScope.launch {
            LocalUserRepository().getAllUsers().collect {
                _usersLiveData.postValue(it)
            }
        }
    }

    fun openDetailsScreen(user: User) {
        router.navigateTo(DetailsScreen(user))
    }
}