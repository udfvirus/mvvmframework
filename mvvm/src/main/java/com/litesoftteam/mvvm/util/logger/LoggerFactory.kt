package com.litesoftteam.mvvm.util.logger

import com.litesoftteam.mvvm.BuildConfig

object LoggerFactory {

    private var loggerInterface: LoggerInterface? = null

    fun initialize(loggerInterface: LoggerInterface) {
        this.loggerInterface = loggerInterface
        loggerInterface.initialize()
    }

    fun create(aClass: Class<*>): LoggerInterface {

        val tag = if (BuildConfig.DEBUG) {
            aClass.simpleName
        } else {
            aClass.canonicalName!!
        }

        loggerInterface!!.setTag(tag)

        return loggerInterface!!
    }
}