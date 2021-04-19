package com.litesoftteam.mvvm.sample.presentation.navigation.screen

import com.litesoftteam.mvvm.sample.core.entity.User
import com.litesoftteam.mvvm.sample.presentation.screen.details.DetailsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class DetailsScreen(private val user: User) : SupportAppScreen() {

    override fun getFragment() = DetailsFragment.newInstance(user)
}