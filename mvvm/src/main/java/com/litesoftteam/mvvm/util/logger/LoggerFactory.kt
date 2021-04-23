package com.litesoftteam.mvvm.util.logger

import com.litesoftteam.mvvm.BuildConfig

object LoggerFactory {

    private var getLogger: (() -> LoggerInterface)? = null

    fun initialize(getLogger: () -> LoggerInterface) {
        this.getLogger = getLogger
        getLogger().initialize()
    }

    fun create(aClass: Class<*>): LoggerInterface {

        val tag = if (BuildConfig.DEBUG) {
            aClass.simpleName
        } else {
            aClass.canonicalName!!
        }

        return create(tag)
    }

    fun create(tag: String): LoggerInterface {
        val loggerInterface = getLogger!!.invoke()
        loggerInterface.setTag(tag)

        return loggerInterface
    }
}