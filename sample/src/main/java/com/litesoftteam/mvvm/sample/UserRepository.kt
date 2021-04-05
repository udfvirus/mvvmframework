package com.litesoftteam.mvvm.sample

import androidx.lifecycle.LiveData

interface UserRepository {

    fun getAllUsers(): LiveData<List<User>>
}