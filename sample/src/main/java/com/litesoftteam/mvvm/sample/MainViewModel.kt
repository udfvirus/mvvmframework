package com.litesoftteam.mvvm.sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    fun getUsers(): LiveData<List<User>> {
        return LocalUserRepository().getAllUsers()
    }
}