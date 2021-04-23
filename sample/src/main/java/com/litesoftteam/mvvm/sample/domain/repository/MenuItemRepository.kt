package com.litesoftteam.mvvm.sample.domain.repository

import com.litesoftteam.mvvm.sample.core.entity.MenuItem

interface MenuItemRepository {

    suspend fun getMenuItems(): List<MenuItem>
}