package com.litesoftteam.mvvm.core.entity

data class Event<out T>(val status: Status, val data: T? = null, val throwable: Throwable? = null) {


    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }


    companion object {

        fun <T> success(data: T) = Event(Status.SUCCESS, data)

        fun <T> error(throwable: Throwable): Event<T> {
            return Event(Status.ERROR, throwable = throwable)
        }

        fun <T> loading(): Event<T> {
            return Event(Status.LOADING)
        }
    }
}
