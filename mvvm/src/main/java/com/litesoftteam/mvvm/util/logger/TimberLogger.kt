package com.litesoftteam.mvvm.util.logger

import com.litesoftteam.mvvm.BuildConfig
import timber.log.Timber

class TimberLogger : LoggerInterface {

    private var tag: String? = null

    override fun initialize() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun setTag(tag: String) {
        this.tag = tag
    }

    override fun v(message: String?, vararg args: Any?) {
        Timber.tag(tag)
        Timber.v(message, args)
    }

    override fun v(t: Throwable?, message: String?, vararg args: Any?) {
        Timber.tag(tag)
        Timber.v(t, message, args)
    }

    override fun v(t: Throwable?) {
        Timber.tag(tag)
        Timber.v(t)
    }

    override fun d(message: String?, vararg args: Any?) {
        Timber.tag(tag)
        Timber.d(message, args)
    }

    override fun d(t: Throwable?, message: String?, vararg args: Any?) {
        Timber.tag(tag)
        Timber.d(t, message, args)
    }

    override fun d(t: Throwable?) {
        Timber.tag(tag)
        Timber.d(t)
    }

    override fun i(message: String?, vararg args: Any?) {
        Timber.tag(tag)
        Timber.i(message, args)
    }

    override fun i(t: Throwable?, message: String?, vararg args: Any?) {
        Timber.tag(tag)
        Timber.i(t, message, args)
    }

    override fun i(t: Throwable?) {
        Timber.tag(tag)
        Timber.i(t)
    }

    override fun w(message: String?, vararg args: Any?) {
        Timber.tag(tag)
        Timber.w(message, args)
    }

    override fun w(t: Throwable?, message: String?, vararg args: Any?) {
        Timber.tag(tag)
        Timber.w(t, message, args)
    }

    override fun w(t: Throwable?) {
        Timber.tag(tag)
        Timber.w(t)
    }

    override fun e(message: String?, vararg args: Any?) {
        Timber.tag(tag)
        Timber.e(message, args)
    }

    override fun e(t: Throwable?, message: String?, vararg args: Any?) {
        Timber.tag(tag)
        Timber.e(t, message, args)
    }

    override fun e(t: Throwable?) {
        Timber.tag(tag)
        Timber.e(t)
    }
}