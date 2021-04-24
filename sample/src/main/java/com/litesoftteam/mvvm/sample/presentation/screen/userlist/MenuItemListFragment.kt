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