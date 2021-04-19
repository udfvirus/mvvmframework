package com.litesoftteam.mvvm.sample.presentation.viewmodel

import com.litesoftteam.mvvm.presentation.viewmodel.BaseViewModel
import com.litesoftteam.mvvm.sample.presentation.navigation.screen.SearchScreen
import com.litesoftteam.mvvm.sample.presentation.navigation.screen.SettingsScreen
import com.litesoftteam.mvvm.sample.presentation.navigation.screen.UserListScreen
import ru.terrakok.cicerone.Router

class MainViewModel(router: Router) : BaseViewModel(router) {

    fun openUserListScreen() {
        router.newRootScreen(UserListScreen())
    }

    fun openSearchScreen() {
        router.navigateTo(SearchScreen())
    }

    fun openSettingsScreen() {
        router.navigateTo(SettingsScreen())
    }
}