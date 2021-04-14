package com.litesoftteam.mvvm.sample.presentation.adapter.viewholder

import android.view.ViewGroup
import com.litesoftteam.mvvm.presentation.adapter.BaseViewHolder
import com.litesoftteam.mvvm.sample.R
import com.litesoftteam.mvvm.sample.core.entity.User
import kotlinx.android.synthetic.main.layout_user_item.view.*

class UserViewHolder(parent: ViewGroup) : BaseViewHolder<User>(parent, R.layout.layout_user_item) {

    override fun bind(item: User) {
        super.bind(item)

        itemView.nameTextView.text = item.name
    }
}