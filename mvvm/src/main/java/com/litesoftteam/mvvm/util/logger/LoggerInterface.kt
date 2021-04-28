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