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

object Versions {

    const val kotlin = "1.4.32"

    const val appcompat = "1.2.0"

    const val recyclerView = "1.2.0"

    const val constraintLayout = "2.0.4"

    const val timber = "4.7.1"

    const val fragmentKtx = "1.3.2"

    const val cicerone = "5.1.1"

    const val koinAndroidxExt = "2.2.2"

    const val cardView = "1.0.0"

    const val lifecycle = "2.3.1"

    const val lifecycleExtensions = "2.2.0"

    const val retrofit = "2.9.0"

    const val okhttp = "4.9.0"
}

object Dependencies {

    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"

    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"

    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"

    const val cicerone = "ru.terrakok.cicerone:cicerone:${Versions.cicerone}"

    const val koinAndroidxScope = "org.koin:koin-androidx-scope:${Versions.koinAndroidxExt}"

    const val koinAndroidxViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koinAndroidxExt}"

    const val koinAndroidxFragment = "org.koin:koin-androidx-fragment:${Versions.koinAndroidxExt}"

    const val koinAndroidxExt = "org.koin:koin-androidx-ext:${Versions.koinAndroidxExt}"

    const val cardView = "androidx.cardview:cardview:${Versions.cardView}"

    const val lifecycleViewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    const val lifecycleLivedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"

    const val lifecycleCommonJava = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"

    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtensions}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"

    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"

    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
}