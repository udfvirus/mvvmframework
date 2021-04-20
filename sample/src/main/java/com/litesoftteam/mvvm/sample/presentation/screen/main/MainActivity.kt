package com.litesoftteam.mvvm.sample.presentation.screen.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.litesoftteam.mvvm.presentation.BaseActivity
import com.litesoftteam.mvvm.sample.R
import com.litesoftteam.mvvm.sample.presentation.navigation.MainActivityNavigator
import com.litesoftteam.mvvm.sample.presentation.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.toolbar_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity(R.layout.activity_main) {

    private val model by viewModel<MainViewModel>()

    override val navigator = MainActivityNavigator(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbar()
        model.openUserListScreen()
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_search -> {
            model.openSearchScreen()
            true
        }
        R.id.action_settings -> {
            model.openSettingsScreen()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}