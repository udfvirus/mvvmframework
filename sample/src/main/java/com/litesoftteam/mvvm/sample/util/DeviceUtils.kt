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