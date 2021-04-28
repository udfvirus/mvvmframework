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

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.litesoftteam.mvvm.core.entity.Event
import com.litesoftteam.mvvm.presentation.viewmodel.BaseViewModel
import com.litesoftteam.mvvm.sample.core.entity.MenuItem
import com.litesoftteam.mvvm.sample.domain.repository.MenuItemRepository
import com.litesoftteam.mvvm.sample.presentation.navigation.screen.DetailsScreen
import ru.terrakok.cicerone.Router

class MenuItemViewModel(
        router: Router,
        private val menuItemRepository: MenuItemRepository
) : BaseViewModel(router) {

    private val _menuLiveData = MutableLiveData<Event<List<MenuItem>>>()

    val menuLiveData: LiveData<Event<List<MenuItem>>> = _menuLiveData

    fun load() {
        subscribe(_menuLiveData) {
            menuItemRepository.getMenuItems()
        }
    }

    fun openDetailsScreen(item: MenuItem) {
        router.navigateTo(DetailsScreen(item))
    }
}