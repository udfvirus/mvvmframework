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
package com.litesoftteam.mvvm

import android.app.Application
import androidx.annotation.CallSuper
import com.litesoftteam.mvvm.util.logger.LoggerFactory
import com.litesoftteam.mvvm.util.logger.TimberLogger
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module

abstract class BaseApplication : Application() {

    @CallSuper
    override fun onCreate() {
        super.onCreate()
        LoggerFactory.initialize { getLogger() }
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@BaseApplication)
            modules(getKoinModules())
        }
    }

    protected open fun getLogger() = TimberLogger()

    protected open fun getKoinModules() = emptyList<Module>()
}