package com.litesoftteam.mvvm.sample.presentation.screen.details

import androidx.core.os.bundleOf
import com.litesoftteam.mvvm.presentation.BaseFragment
import com.litesoftteam.mvvm.sample.R
import com.litesoftteam.mvvm.sample.core.entity.User

class DetailsFragment : BaseFragment(R.layout.fragment_details) {

    override fun initObservers() {
        super.initObservers()
    }


    companion object {

        private const val USER_ID_KEY = "USER_ID_KEY"

        fun newInstance(user: User) = DetailsFragment().apply {
            arguments = bundleOf(USER_ID_KEY to user.id)
        }
    }
}