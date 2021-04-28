/*
 * Copyright (C) 2021 Vitaliy Sychov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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