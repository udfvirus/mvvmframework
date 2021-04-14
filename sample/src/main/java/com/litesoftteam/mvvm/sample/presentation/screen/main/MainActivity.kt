package com.litesoftteam.mvvm.sample.presentation.screen.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.litesoftteam.mvvm.core.entity.EventWithSuccessAndError
import com.litesoftteam.mvvm.presentation.BaseActivity
import com.litesoftteam.mvvm.sample.R
import com.litesoftteam.mvvm.sample.core.entity.User
import com.litesoftteam.mvvm.sample.presentation.adapter.UserAdapter
import com.litesoftteam.mvvm.sample.presentation.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val model: MainViewModel by viewModels()

    private val userAdapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "call onCreate()")

        initRecycleView()

        model.loadUsers()
    }

    private fun initRecycleView() {
        usersRecyclerView.adapter = userAdapter
    }

    override fun initObservers() {
        super.initObservers()
        observeEvent(model.usersLiveData, object : EventWithSuccessAndError<List<User>> {

            override fun success(value: List<User>) {
                Log.d("MainActivity", "User: $value")
                userAdapter.addItems(value)
            }

            override fun error(throwable: Throwable) {
                Log.d("MainActivity", "throwable: $throwable")
            }
        })
    }
}