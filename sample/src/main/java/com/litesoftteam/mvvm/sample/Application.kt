package com.litesoftteam.mvvm.sample

import com.litesoftteam.mvvm.BaseApplication
import com.litesoftteam.mvvm.sample.di.navigationModule
import com.litesoftteam.mvvm.sample.di.repositoryModule
import com.litesoftteam.mvvm.sample.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Application : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@Application)
            modules(listOf(navigationModule, repositoryModule, viewModelModule))
        }
    }
}