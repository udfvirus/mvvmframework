package com.litesoftteam.mvvm.sample.presentation.screen.userlist

import android.os.Bundle
import android.view.View
import com.litesoftteam.mvvm.core.entity.EventWithSuccessAndError
import com.litesoftteam.mvvm.presentation.BaseFragment
import com.litesoftteam.mvvm.sample.R
import com.litesoftteam.mvvm.sample.core.entity.User
import com.litesoftteam.mvvm.sample.presentation.adapter.UserAdapter
import com.litesoftteam.mvvm.sample.presentation.viewmodel.UserListViewModel
import com.litesoftteam.mvvm.util.logger.LoggerFactory
import kotlinx.android.synthetic.main.fragment_user_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserListFragment : BaseFragment(R.layout.fragment_user_list) {

    private val model by viewModel<UserListViewModel>()

    private val logger = LoggerFactory.create(this.javaClass)

    private var userAdapter: UserAdapter? = null

    override fun initObservers() {
        super.initObservers()

        observeEventWithProgress(model.usersLiveData, object : EventWithSuccessAndError<List<User>> {

            override fun success(value: List<User>) {
                logger.d("Users: $value")
                userAdapter?.addItems(value)
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
        userAdapter = UserAdapter(model::openDetailsScreen)
        usersRecyclerView.adapter = userAdapter
    }


    companion object {
        fun newInstance() = UserListFragment()
    }
}