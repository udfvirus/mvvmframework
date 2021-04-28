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