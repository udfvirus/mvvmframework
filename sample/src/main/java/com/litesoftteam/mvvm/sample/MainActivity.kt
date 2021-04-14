package com.litesoftteam.mvvm.sample

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.litesoftteam.mvvm.core.entity.EventWithSuccessAndError
import com.litesoftteam.mvvm.presentation.BaseActivity

class MainActivity : BaseActivity() {

    private val model: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "call onCreate()")

        model.loadUsers()
    }

    override fun initObservers() {
        super.initObservers()
        observeEvent(model.usersLiveData, object : EventWithSuccessAndError<List<User>> {

            override fun success(value: List<User>) {
                Log.d("MainActivity", "User: $value")
            }

            override fun error(throwable: Throwable) {
                Log.d("MainActivity", "throwable: $throwable")
            }
        })
    }
}