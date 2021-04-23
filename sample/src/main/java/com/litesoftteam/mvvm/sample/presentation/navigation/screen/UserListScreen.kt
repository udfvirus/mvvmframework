package com.litesoftteam.mvvm.sample.presentation.navigation.screen

import com.litesoftteam.mvvm.sample.presentation.screen.userlist.MenuItemListFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class UserListScreen : SupportAppScreen() {

    override fun getFragment() = MenuItemListFragment.newInstance()
}