package com.litesoftteam.mvvm.sample.presentation.adapter

import android.view.ViewGroup
import com.litesoftteam.mvvm.presentation.adapter.BaseAdapter
import com.litesoftteam.mvvm.presentation.adapter.BaseViewHolder
import com.litesoftteam.mvvm.sample.core.entity.MenuItem
import com.litesoftteam.mvvm.sample.presentation.adapter.viewholder.MenuItemViewHolder

class MenuItemsAdapter(
        private val onClickItemListener: (MenuItem) -> Unit
) : BaseAdapter<MenuItem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<MenuItem> {
        return MenuItemViewHolder(parent, onClickItemListener)
    }
}