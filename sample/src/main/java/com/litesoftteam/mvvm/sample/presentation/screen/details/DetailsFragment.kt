package com.litesoftteam.mvvm.sample.presentation.screen.details

import androidx.core.os.bundleOf
import com.litesoftteam.mvvm.presentation.BaseFragment
import com.litesoftteam.mvvm.sample.R
import com.litesoftteam.mvvm.sample.core.entity.MenuItem

class DetailsFragment : BaseFragment(R.layout.fragment_details) {

    override fun initObservers() {
        super.initObservers()
    }


    companion object {

        private const val MENU_ITEM_ID_KEY = "MENU_ITEM_ID_KEY"

        fun newInstance(item: MenuItem) = DetailsFragment().apply {
            arguments = bundleOf(MENU_ITEM_ID_KEY to item.id)
        }
    }
}