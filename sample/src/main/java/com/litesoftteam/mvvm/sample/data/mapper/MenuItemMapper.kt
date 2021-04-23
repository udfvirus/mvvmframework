package com.litesoftteam.mvvm.sample.data.mapper

import com.litesoftteam.mvvm.sample.core.entity.MenuItem
import com.litesoftteam.mvvm.sample.data.entity.MenuItemNetwork

class MenuItemMapper {

    fun toMenuItem(menuItemNetwork: MenuItemNetwork) = MenuItem(
            menuItemNetwork.id,
            menuItemNetwork.name,
            menuItemNetwork.iconUrl,
            menuItemNetwork.visible,
            menuItemNetwork.type
    )
}