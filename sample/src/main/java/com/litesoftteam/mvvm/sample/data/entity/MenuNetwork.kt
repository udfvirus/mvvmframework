package com.litesoftteam.mvvm.sample.data.entity

import com.google.gson.annotations.SerializedName

data class DeviceMenuNetwork(
    @SerializedName("menuItems") val deviceMenuItemList: List<MenuItemNetwork>
)