package com.litesoftteam.mvvm.sample.presentation.navigation.screen

import com.litesoftteam.mvvm.sample.presentation.screen.userlist.UserListFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class UserListScreen : SupportAppScreen() {

    override fun getFragment() = UserListFragment.newInstance()
}