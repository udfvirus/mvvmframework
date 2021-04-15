package com.litesoftteam.mvvm.util.logger

import org.jetbrains.annotations.NonNls

interface LoggerInterface {

    fun initialize()

    fun setTag(tag: String)

    fun v(@NonNls message: String?, vararg args: Any?)

    fun v(t: Throwable?, @NonNls message: String?, vararg args: Any?)

    fun v(t: Throwable?)

    fun d(@NonNls message: String?, vararg args: Any?)

    fun d(t: Throwable?, @NonNls message: String?, vararg args: Any?)

    fun d(t: Throwable?)

    fun i(@NonNls message: String?, vararg args: Any?)

    fun i(t: Throwable?, @NonNls message: String?, vararg args: Any?)

    fun i(t: Throwable?)

    fun w(@NonNls message: String?, vararg args: Any?)

    fun w(t: Throwable?, @NonNls message: String?, vararg args: Any?)

    fun w(t: Throwable?)

    fun e(@NonNls message: String?, vararg args: Any?)

    fun e(t: Throwable?, @NonNls message: String?, vararg args: Any?)

    fun e(t: Throwable?)
}