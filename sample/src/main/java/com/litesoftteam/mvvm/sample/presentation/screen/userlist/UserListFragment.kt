package com.litesoftteam.mvvm.sample.presentation.screen.userlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.litesoftteam.mvvm.core.entity.EventWithSuccessAndError
import com.litesoftteam.mvvm.presentation.BaseFragment
import com.litesoftteam.mvvm.sample.R
import com.litesoftteam.mvvm.sample.core.entity.User
import com.litesoftteam.mvvm.sample.presentation.adapter.UserAdapter
import com.litesoftteam.mvvm.sample.presentation.viewmodel.UserListViewModel
import com.litesoftteam.mvvm.util.logger.LoggerFactory
import kotlinx.android.synthetic.main.activity_main.*

class UserListFragment : BaseFragment(R.layout.fragment_details) {

    private val model: UserListViewModel by viewModels()

    private val logger = LoggerFactory.create(this.javaClass)

    private val userAdapter = UserAdapter(model::openDetailsScreen)

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycleView()

        model.loadUsers()
    }

    private fun initRecycleView() {
        usersRecyclerView.adapter = userAdapter
    }


    companion object {
        fun newInstance() = UserListFragment()
    }
}