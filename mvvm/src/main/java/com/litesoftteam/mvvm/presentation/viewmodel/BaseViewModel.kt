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
package com.litesoftteam.mvvm.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.litesoftteam.mvvm.core.entity.Event
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ru.terrakok.cicerone.Router

abstract class BaseViewModel(protected val router: Router) : ViewModel() {

    protected fun <T> subscribe(liveData: MutableLiveData<Event<T>>,
                                block: suspend CoroutineScope.() -> T) {
        viewModelScope.launch {
            liveData.postValue(Event.loading())
            try {
                liveData.postValue(Event.success(block()))
            } catch (exception: Exception) {
                liveData.postValue(Event.error(exception))
            }
        }
    }
}