package com.litesoftteam.mvvm.util.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment

fun DialogFragment.inflateView(@LayoutRes resourceId: Int, root: ViewGroup?): View =
        LayoutInflater.from(context).inflate(resourceId, root)
