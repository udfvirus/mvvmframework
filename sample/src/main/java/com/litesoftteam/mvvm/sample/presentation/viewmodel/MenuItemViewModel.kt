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