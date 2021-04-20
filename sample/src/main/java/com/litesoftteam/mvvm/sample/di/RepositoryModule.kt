package com.litesoftteam.mvvm.sample.di

import com.litesoftteam.mvvm.sample.data.repository.LocalUserRepository
import com.litesoftteam.mvvm.sample.domain.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<UserRepository> { LocalUserRepository() }
}
