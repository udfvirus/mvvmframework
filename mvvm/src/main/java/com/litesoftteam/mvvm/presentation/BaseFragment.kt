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
package com.litesoftteam.mvvm.presentation

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.litesoftteam.mvvm.core.entity.Event
import com.litesoftteam.mvvm.core.entity.EventWithSuccessAndError

@Suppress("unused")
abstract class BaseFragment : Fragment {

    constructor() : super()

    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    private fun getBaseActivity() = activity as? BaseActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initObservers()
    }

    protected fun <T> observeEvent(liveData: LiveData<Event<T>>, observer: Observer<Event<T>>) {
        liveData.observe(this, observer)
    }

    protected fun <T> observeEvent(liveData: LiveData<Event<T>>,
                                   result: EventWithSuccessAndError<T>) {
        liveData.observe(this) {
            if (it.status == Event.Status.SUCCESS) {
                result.success(it.data!!)
            } else if (it.status == Event.Status.ERROR) {
                result.error(it.throwable!!)
            }
        }
    }

    protected fun <T> observeEventWithProgress(liveData: LiveData<Event<T>>,
                                               result: EventWithSuccessAndError<T>) {
        liveData.observe(this) {
            when (it.status) {
                Event.Status.LOADING -> {
                    showProgressBar()
                }
                Event.Status.SUCCESS -> {
                    hideProgressBar()
                    result.success(it.data!!)
                }
                Event.Status.ERROR -> {
                    hideProgressBar()
                    result.error(it.throwable!!)
                }
            }
        }
    }

    protected open fun showProgressBar() {
        getBaseActivity()?.showProgressBar()
    }

    protected open fun hideProgressBar() {
        getBaseActivity()?.hideProgressBar()
    }

    @CallSuper
    protected open fun initObservers() {
    }

    open fun onError(throwable: Throwable?) = throwable?.let {
        // none
    }
}