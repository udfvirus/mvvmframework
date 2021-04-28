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
package com.litesoftteam.mvvm.util.extensions

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflateView(
        @LayoutRes layoutId: Int,
        parent: ViewGroup? = this,
        attachToRoot: Boolean = false
): View =
        layoutInflater.inflate(layoutId, parent, attachToRoot)

fun View.inflateView(
        @LayoutRes layoutId: Int,
        parent: ViewGroup? = null,
        attachToRoot: Boolean = false
): View =
        layoutInflater.inflate(layoutId, parent, attachToRoot)

inline val View.layoutInflater get() = context.layoutInflater