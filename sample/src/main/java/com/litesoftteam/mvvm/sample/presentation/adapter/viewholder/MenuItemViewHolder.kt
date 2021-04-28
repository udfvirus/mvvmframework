/*
 * Copyright (C) 2021 Vitaliy Sychov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.litesoftteam.mvvm.sample.presentation.adapter.viewholder

import android.view.ViewGroup
import com.litesoftteam.mvvm.presentation.adapter.BaseViewHolder
import com.litesoftteam.mvvm.sample.R
import com.litesoftteam.mvvm.sample.core.entity.MenuItem
import kotlinx.android.synthetic.main.layout_user_item.view.*

class MenuItemViewHolder(
        parent: ViewGroup,
        private val onClickItemListener: (MenuItem) -> Unit
) : BaseViewHolder<MenuItem>(parent, R.layout.layout_user_item) {

    override fun bind(item: MenuItem) {
        super.bind(item)

        itemView.setOnClickListener { onClickItemListener(item) }
        itemView.nameTextView.text = item.name
    }
}