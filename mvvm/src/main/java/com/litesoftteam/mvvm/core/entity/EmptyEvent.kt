package com.litesoftteam.mvvm.core.entity

interface EmptyEvent {

    fun success()

    fun error(throwable: Throwable)
}
