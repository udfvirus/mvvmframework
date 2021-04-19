package com.litesoftteam.mvvm.sample.domain.repository

import com.litesoftteam.mvvm.core.entity.Event
import com.litesoftteam.mvvm.sample.core.entity.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun getAllUsers(): Flow<Event<List<User>>>
}