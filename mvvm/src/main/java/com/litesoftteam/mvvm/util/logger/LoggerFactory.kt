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