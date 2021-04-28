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
package com.litesoftteam.mvvm.sample.util

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import com.litesoftteam.mvvm.sample.BuildConfig
import com.litesoftteam.mvvm.util.logger.LoggerFactory
import java.util.*

object DeviceUtils {

    private val logger = LoggerFactory.create(this::class.java)

    fun getUserAgent(context: Context): String {
        try {
            val packageManager = context.packageManager
            if (packageManager != null) {
                val packageName = context.packageName
                val packageInfo = Objects.requireNonNull(packageManager.getPackageInfo(packageName, 0))
                return getUserAgent(packageName, packageInfo.versionName.toString())
            }
        } catch (e: PackageManager.NameNotFoundException) {
            logger.e(e, "getUserAgent")
        }

        return getUserAgent(BuildConfig.APPLICATION_ID, BuildConfig.VERSION_NAME)
    }

    private fun getUserAgent(appId: String, versionName: String): String {
        return appId + "/" + versionName + " (" + Build.MANUFACTURER +
                " " + Build.MODEL + "; Android " + Build.VERSION.RELEASE + ")"
    }
}