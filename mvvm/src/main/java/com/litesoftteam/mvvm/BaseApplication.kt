package com.litesoftteam.mvvm

import android.app.Application
import androidx.annotation.CallSuper
import com.litesoftteam.mvvm.util.logger.LoggerFactory
import com.litesoftteam.mvvm.util.logger.TimberLogger
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module

abstract class BaseApplication : Application() {

    @CallSuper
    override fun onCreate() {
        super.onCreate()
        LoggerFactory.initialize { getLogger() }
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@BaseApplication)
            modules(getKoinModules())
        }
    }

    protected open fun getLogger() = TimberLogger()

    protected open fun getKoinModules() = emptyList<Module>()
}