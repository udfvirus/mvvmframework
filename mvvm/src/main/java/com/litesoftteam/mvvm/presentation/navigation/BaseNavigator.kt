package com.litesoftteam.mvvm.presentation.navigation

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import ru.terrakok.cicerone.android.support.SupportAppNavigator

abstract class BaseNavigator constructor(
        activity: FragmentActivity,
        @IdRes private val containerId: Int
) : SupportAppNavigator(activity, containerId)
