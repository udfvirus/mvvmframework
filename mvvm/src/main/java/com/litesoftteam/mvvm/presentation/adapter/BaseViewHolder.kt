package com.litesoftteam.mvvm.presentation.adapter

import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.litesoftteam.mvvm.util.extensions.inflateView

open class BaseViewHolder<T : Any>(
        parentViewGroup: ViewGroup,
        @LayoutRes layoutResource: Int
) : RecyclerView.ViewHolder(parentViewGroup.inflateView(layoutResource)) {

    lateinit var item: T
        private set

    @CallSuper
    open fun bind(item: T) {
        this.item = item
    }
}