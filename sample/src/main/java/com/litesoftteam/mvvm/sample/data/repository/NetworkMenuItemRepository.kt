package com.litesoftteam.mvvm.sample.data.repository

import com.litesoftteam.mvvm.sample.data.mapper.MenuItemMapper
import com.litesoftteam.mvvm.sample.data.network.api.ApiService
import com.litesoftteam.mvvm.sample.domain.repository.MenuItemRepository

class NetworkMenuItemRepository constructor(
        private val api: ApiService
) : MenuItemRepository {

    override suspend fun getMenuItems() = api.getMenuItemsDevice()
            .deviceMenuItemList
            .map(MenuItemMapper()::toMenuItem)
}