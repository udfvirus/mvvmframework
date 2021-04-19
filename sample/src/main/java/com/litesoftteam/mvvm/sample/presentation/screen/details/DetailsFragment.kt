package com.litesoftteam.mvvm.sample.presentation.screen.details

import com.litesoftteam.mvvm.presentation.BaseFragment
import com.litesoftteam.mvvm.sample.R

class DetailsFragment : BaseFragment(R.layout.fragment_details) {

    override fun initObservers() {
        super.initObservers()
    }


    companion object {
        fun newInstance() = DetailsFragment()
    }
}