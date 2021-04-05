package com.litesoftteam.mvvm.sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class LocalUserRepository : UserRepository {

    override fun getAllUsers(): LiveData<List<User>> {

        val usersLiveData = MutableLiveData<List<User>>()

        Thread {
            Thread.sleep(3000)
            usersLiveData.postValue(listOf(
                    User(0, "Slava"),
                    User(1, "Andrey"),
                    User(2, "Bill"),
                    User(3, "John"),
            ))
        }.start()

        return usersLiveData
    }
}