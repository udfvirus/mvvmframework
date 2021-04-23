package com.litesoftteam.mvvm.sample.data.entity

import com.google.gson.annotations.SerializedName

data class MenuItemNetwork(
        val id: Int,
        val name: String,
        @SerializedName("icon") val iconUrl: String,
        val visible: Boolean,
        val type: Int
)