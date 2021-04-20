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