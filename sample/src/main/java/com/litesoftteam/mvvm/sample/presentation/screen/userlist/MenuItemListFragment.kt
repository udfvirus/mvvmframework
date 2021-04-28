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
package com.litesoftteam.mvvm.sample.presentation.screen.userlist

import android.os.Bundle
import android.view.View
import com.litesoftteam.mvvm.core.entity.EventWithSuccessAndError
import com.litesoftteam.mvvm.presentation.BaseFragment
import com.litesoftteam.mvvm.sample.R
import com.litesoftteam.mvvm.sample.core.entity.MenuItem
import com.litesoftteam.mvvm.sample.presentation.adapter.MenuItemsAdapter
import com.litesoftteam.mvvm.sample.presentation.viewmodel.MenuItemViewModel
import com.litesoftteam.mvvm.util.logger.LoggerFactory
import kotlinx.android.synthetic.main.fragment_user_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MenuItemListFragment : BaseFragment(R.layout.fragment_user_list) {

    private val model by viewModel<MenuItemViewModel>()

    private val logger = LoggerFactory.create(this.javaClass)

    private var menuItemAdapter: MenuItemsAdapter? = null

    override fun initObservers() {
        super.initObservers()

        observeEventWithProgress(model.menuLiveData, object : EventWithSuccessAndError<List<MenuItem>> {

            override fun success(value: List<MenuItem>) {
                logger.d("MenuItems: $value")
                menuItemAdapter?.addItems(value)
            }

            override fun error(throwable: Throwable) {
                throwable.printStackTrace()
                logger.d("Throwable: $throwable")
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycleView()

        model.load()
    }

    private fun initRecycleView() {
        menuItemAdapter = MenuItemsAdapter(model::openDetailsScreen)
        usersRecyclerView.adapter = menuItemAdapter
    }


    companion object {
        fun newInstance() = MenuItemListFragment()
    }
}