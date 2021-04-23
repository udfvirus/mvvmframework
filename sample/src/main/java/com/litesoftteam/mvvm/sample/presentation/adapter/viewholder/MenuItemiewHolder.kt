package com.litesoftteam.mvvm.sample.presentation.adapter.viewholder

import android.view.ViewGroup
import com.litesoftteam.mvvm.presentation.adapter.BaseViewHolder
import com.litesoftteam.mvvm.sample.R
import com.litesoftteam.mvvm.sample.core.entity.MenuItem
import kotlinx.android.synthetic.main.layout_user_item.view.*

class MenuItemiewHolder(
        parent: ViewGroup,
        private val onClickItemListener: (MenuItem) -> Unit
) : BaseViewHolder<MenuItem>(parent, R.layout.layout_user_item) {

    override fun bind(item: MenuItem) {
        super.bind(item)

        itemView.setOnClickListener { onClickItemListener(item) }
        itemView.nameTextView.text = item.name
    }
}