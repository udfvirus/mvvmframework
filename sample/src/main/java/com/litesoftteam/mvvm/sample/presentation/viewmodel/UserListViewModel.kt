package com.litesoftteam.mvvm.sample.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.litesoftteam.mvvm.core.entity.Event
import com.litesoftteam.mvvm.presentation.viewmodel.BaseViewModel
import com.litesoftteam.mvvm.sample.core.entity.User
import com.litesoftteam.mvvm.sample.domain.repository.UserRepository
import com.litesoftteam.mvvm.sample.presentation.navigation.screen.DetailsScreen
import ru.terrakok.cicerone.Router

class UserListViewModel(
        router: Router,
        private val userRepository: UserRepository
) : BaseViewModel(router) {

    private val _usersLiveData = MutableLiveData<Event<List<User>>>()

    val usersLiveData: LiveData<Event<List<User>>> = _usersLiveData

    fun loadUsers() {
        subscribe(_usersLiveData) {
            userRepository.getAllUsers()
        }
    }

    fun openDetailsScreen(user: User) {
        router.navigateTo(DetailsScreen(user))
    }
}