package com.litesoftteam.mvvm.sample.data.network.interceptor

import android.content.Context
import android.os.Build
import com.litesoftteam.mvvm.sample.data.network.Headers.Companion.ACCEPT
import com.litesoftteam.mvvm.sample.data.network.Headers.Companion.ACCEPT_LANGUAGE
import com.litesoftteam.mvvm.sample.data.network.Headers.Companion.APPLICATION_JSON_CONTENT_TYPE
import com.litesoftteam.mvvm.sample.data.network.Headers.Companion.CONTENT_TYPE
import com.litesoftteam.mvvm.sample.data.network.Headers.Companion.DEVICE_BRAND_KEY
import com.litesoftteam.mvvm.sample.data.network.Headers.Companion.DEVICE_MODEL_KEY
import com.litesoftteam.mvvm.sample.data.network.Headers.Companion.USER_AGENT
import com.litesoftteam.mvvm.sample.util.DeviceUtils
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

class StaticHeadersInterceptor constructor(context: Context) : Interceptor {

    private val userAgent: String = DeviceUtils.getUserAgent(context)

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request()
                .newBuilder()
                .addHeader(ACCEPT, APPLICATION_JSON_CONTENT_TYPE)
                .addHeader(CONTENT_TYPE, APPLICATION_JSON_CONTENT_TYPE)
                .addHeader(USER_AGENT, userAgent)
                .addHeader(ACCEPT_LANGUAGE, Locale.getDefault().language)
                .addHeader(DEVICE_BRAND_KEY, Build.BRAND)
                .addHeader(DEVICE_MODEL_KEY, Build.MODEL)

        return chain.proceed(requestBuilder.build())
    }
}