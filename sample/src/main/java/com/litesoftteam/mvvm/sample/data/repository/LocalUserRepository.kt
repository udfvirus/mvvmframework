package com.litesoftteam.mvvm.sample.data.repository

import com.litesoftteam.mvvm.core.entity.Event
import com.litesoftteam.mvvm.sample.core.entity.User
import com.litesoftteam.mvvm.sample.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class LocalUserRepository : UserRepository {

    override suspend fun getAllUsers(): Event<List<User>> {

        return withContext(Dispatchers.IO) {

            delay(3500)

            Event.success(listOf(
                    User(0, "Slava"),
                    User(1, "Andrey"),
                    User(2, "Bill"),
                    User(3, "John")))
        }
    }
}