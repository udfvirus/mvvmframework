package com.litesoftteam.mvvm.sample.presentation.screen.main

import android.os.Bundle
import androidx.activity.viewModels
import com.litesoftteam.mvvm.core.entity.EventWithSuccessAndError
import com.litesoftteam.mvvm.presentation.BaseActivity
import com.litesoftteam.mvvm.sample.R
import com.litesoftteam.mvvm.sample.core.entity.User
import com.litesoftteam.mvvm.sample.presentation.adapter.UserAdapter
import com.litesoftteam.mvvm.sample.presentation.viewmodel.MainViewModel
import com.litesoftteam.mvvm.util.logger.LoggerFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val model: MainViewModel by viewModels()

    private val userAdapter = UserAdapter()

    private val logger = LoggerFactory.create(this.javaClass)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logger.d("call onCreate()")

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
                logger.d("Users: $value")
                userAdapter.addItems(value)
            }

            override fun error(throwable: Throwable) {
                logger.d("Throwable: $throwable")
            }
        })
    }
}