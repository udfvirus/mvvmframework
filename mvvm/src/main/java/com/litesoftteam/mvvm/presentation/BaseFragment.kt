package com.litesoftteam.mvvm.presentation

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.litesoftteam.mvvm.core.entity.Event
import com.litesoftteam.mvvm.core.entity.EventWithSuccessAndError

abstract class BaseFragment : Fragment {

    constructor() : super()

    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

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
        // none
    }

    protected open fun hideProgressBar() {
        // none
    }

    @CallSuper
    protected open fun initObservers() {
    }
}