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
package com.litesoftteam.mvvm.sample.di

import com.litesoftteam.mvvm.sample.BuildConfig
import com.litesoftteam.mvvm.sample.data.network.api.ApiService
import com.litesoftteam.mvvm.sample.data.network.interceptor.StaticHeadersInterceptor
import com.litesoftteam.mvvm.util.logger.LoggerFactory
import com.litesoftteam.mvvm.util.logger.LoggerInterface
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val TIMEOUT = 30L

private val loggerInterface: LoggerInterface = LoggerFactory.create("NetworkModule")

val networkModule = module {

    single {

        val interceptor = HttpLoggingInterceptor(loggerInterface::d)
        val level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        interceptor.setLevel(level)
    }

    single { StaticHeadersInterceptor(get()) }

    single {
        OkHttpClient().newBuilder()
                .retryOnConnectionFailure(true)
                .protocols(listOf(Protocol.HTTP_1_1))
                .addInterceptor(get<StaticHeadersInterceptor>())
                .addInterceptor(get<HttpLoggingInterceptor>())
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .build()
    }

    single {
        Retrofit.Builder()
                .baseUrl(BuildConfig.SERVER_HOST)
                .client(get())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    single {
        get<Retrofit>().create(ApiService::class.java)
    }
}
