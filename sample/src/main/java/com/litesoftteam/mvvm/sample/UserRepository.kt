package com.litesoftteam.mvvm.sample

import com.litesoftteam.mvvm.core.entity.Event

interface UserRepository {

    suspend fun getAllUsers(): Event<List<User>>
}