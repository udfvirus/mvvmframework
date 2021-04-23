package com.litesoftteam.mvvm.sample.di

import com.litesoftteam.mvvm.sample.data.repository.NetworkCharacteristicRepository
import com.litesoftteam.mvvm.sample.data.repository.NetworkMenuItemRepository
import com.litesoftteam.mvvm.sample.domain.repository.CharacteristicRepository
import com.litesoftteam.mvvm.sample.domain.repository.MenuItemRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<MenuItemRepository> { NetworkMenuItemRepository(get()) }
    single<CharacteristicRepository> { NetworkCharacteristicRepository(get()) }
}
