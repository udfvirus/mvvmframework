package com.litesoftteam.mvvm.sample.data.repository

import com.litesoftteam.mvvm.core.entity.Event
import com.litesoftteam.mvvm.sample.core.entity.User
import com.litesoftteam.mvvm.sample.domain.repository.UserRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocalUserRepository : UserRepository {

    override suspend fun getAllUsers(): Flow<Event<List<User>>> {

        return flow {
            emit(Event.loading())
            delay(3500)
            emit(Event.success(listOf(
                    User(0, "Slava"),
                    User(1, "Andrey"),
                    User(2, "Bill"),
                    User(3, "John"))))
        }
    }
}