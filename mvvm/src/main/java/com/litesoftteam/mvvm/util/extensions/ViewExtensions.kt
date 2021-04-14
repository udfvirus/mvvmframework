package com.litesoftteam.mvvm.util.extensions

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflateView(
        @LayoutRes layoutId: Int,
        parent: ViewGroup? = this,
        attachToRoot: Boolean = false
): View =
        layoutInflater.inflate(layoutId, parent, attachToRoot)

fun View.inflateView(
        @LayoutRes layoutId: Int,
        parent: ViewGroup? = null,
        attachToRoot: Boolean = false
): View =
        layoutInflater.inflate(layoutId, parent, attachToRoot)

inline val View.layoutInflater get() = context.layoutInflater