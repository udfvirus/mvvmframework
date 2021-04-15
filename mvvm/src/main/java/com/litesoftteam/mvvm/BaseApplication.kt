package com.litesoftteam.mvvm

import android.app.Application
import androidx.annotation.CallSuper
import com.litesoftteam.mvvm.util.logger.LoggerFactory
import com.litesoftteam.mvvm.util.logger.TimberLogger

abstract class BaseApplication : Application() {

    @CallSuper
    override fun onCreate() {
        super.onCreate()
        LoggerFactory.initialize(getLogger())
    }

    protected open fun getLogger() = TimberLogger()
}