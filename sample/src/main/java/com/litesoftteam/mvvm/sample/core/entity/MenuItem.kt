package com.litesoftteam.mvvm.sample.core.entity

data class MenuItem(
        val id: Int,
        val name: String,
        val iconUrl: String,
        val visible: Boolean,
        val type: Int
)