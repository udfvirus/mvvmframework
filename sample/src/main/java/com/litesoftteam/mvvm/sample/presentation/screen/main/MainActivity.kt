package com.litesoftteam.mvvm.sample.presentation.screen.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import com.litesoftteam.mvvm.core.entity.EventWithSuccessAndError
import com.litesoftteam.mvvm.presentation.BaseActivity
import com.litesoftteam.mvvm.sample.R
import com.litesoftteam.mvvm.sample.core.entity.User
import com.litesoftteam.mvvm.sample.presentation.adapter.UserAdapter
import com.litesoftteam.mvvm.sample.presentation.viewmodel.MainViewModel
import com.litesoftteam.mvvm.util.logger.LoggerFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*

class MainActivity : BaseActivity() {

    private val model: MainViewModel by viewModels()

    private val userAdapter = UserAdapter()

    private val logger = LoggerFactory.create(this.javaClass)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar()
        initRecycleView()

        model.loadUsers()
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initRecycleView() {
        usersRecyclerView.adapter = userAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_search -> true
        R.id.action_settings -> true
        else -> super.onOptionsItemSelected(item)
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