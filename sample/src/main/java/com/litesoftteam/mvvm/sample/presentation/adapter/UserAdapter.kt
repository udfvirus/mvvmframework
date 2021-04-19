package com.litesoftteam.mvvm.sample.presentation.adapter

import android.view.ViewGroup
import com.litesoftteam.mvvm.presentation.adapter.BaseAdapter
import com.litesoftteam.mvvm.presentation.adapter.BaseViewHolder
import com.litesoftteam.mvvm.sample.core.entity.User
import com.litesoftteam.mvvm.sample.presentation.adapter.viewholder.UserViewHolder

class UserAdapter(
        private val onClickItemListener: (User) -> Unit
) : BaseAdapter<User>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<User> {
        return UserViewHolder(parent, onClickItemListener)
    }
}