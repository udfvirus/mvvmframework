package com.litesoftteam.mvvm.core.entity

interface EventWithSuccessAndError<T> {

    fun success(value: T)

    fun error(throwable: Throwable)
}
