/*
 * Copyright (C) 2021 Vitaliy Sychov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
