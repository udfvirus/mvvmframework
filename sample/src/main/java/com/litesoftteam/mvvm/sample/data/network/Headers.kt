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
package com.litesoftteam.mvvm.sample.data.network

interface Headers {

    companion object {

        const val ACCEPT = "Accept"

        const val USER_AGENT = "User-Agent"

        const val CONTENT_TYPE = "Content-Type"

        const val ACCEPT_LANGUAGE = "Accept-Language"

        const val APPLICATION_JSON_CONTENT_TYPE = "application/json"

        const val DEVICE_BRAND_KEY = "X-Device-Brand"

        const val DEVICE_MODEL_KEY = "X-Device-Model"
    }
}