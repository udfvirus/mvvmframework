package com.litesoftteam.mvvm.sample.domain.repository

import com.litesoftteam.mvvm.sample.core.entity.User

interface UserRepository {

    suspend fun getAllUsers(): List<User>
}