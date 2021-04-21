package com.litesoftteam.mvvm.sample

import com.litesoftteam.mvvm.BaseApplication
import com.litesoftteam.mvvm.sample.di.navigationModule
import com.litesoftteam.mvvm.sample.di.repositoryModule
import com.litesoftteam.mvvm.sample.di.viewModelModule

class Application : BaseApplication() {

    override fun getKoinModules() = listOf(navigationModule, repositoryModule, viewModelModule)
}