package com.litesoftteam.mvvm.presentation

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.litesoftteam.mvvm.core.entity.Event
import com.litesoftteam.mvvm.core.entity.EventWithSuccessAndError
import com.litesoftteam.mvvm.di.NavigationFactory
import com.litesoftteam.mvvm.presentation.dialog.ProgressDialog
import com.litesoftteam.mvvm.presentation.navigation.BaseNavigator

@Suppress("unused", "MemberVisibilityCanBePrivate")
abstract class BaseActivity : AppCompatActivity {

    protected abstract val navigator: BaseNavigator

    protected val navigatorHolder by lazy { NavigationFactory.getNavigationHolder() }

    private var progressDialog: ProgressDialog? = null

    constructor() : super()

    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initObservers()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    protected fun <T> observeEvent(liveData: LiveData<Event<T>>, observer: Observer<Event<T>>) {
        liveData.observe(this, observer)
    }

    protected fun <T> observeEvent(liveData: LiveData<Event<T>>,
                                   result: EventWithSuccessAndError<T>) {
        liveData.observe(this) {
            when (it.status) {
                Event.Status.SUCCESS -> {
                    result.success(it.data!!)
                }
                Event.Status.ERROR -> {
                    result.error(it.throwable!!)
                }
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

    open fun showProgressBar() {
        if (progressDialog == null) {
            progressDialog = ProgressDialog()
        } else {
            progressDialog?.dismiss()
        }

        progressDialog?.show(supportFragmentManager)
    }

    open fun hideProgressBar() {
        progressDialog?.dismiss()
        progressDialog = null
    }

    @CallSuper
    protected open fun initObservers() {
    }

    open fun onError(throwable: Throwable?) = throwable?.let {
        // none
    }
}