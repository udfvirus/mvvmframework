package com.litesoftteam.mvvm.sample.presentation.adapter

import android.view.ViewGroup
import com.litesoftteam.mvvm.presentation.adapter.BaseAdapter
import com.litesoftteam.mvvm.presentation.adapter.BaseViewHolder
import com.litesoftteam.mvvm.sample.core.entity.Characteristic
import com.litesoftteam.mvvm.sample.presentation.adapter.viewholder.CharacteristicViewHolder

class CharacteristicsAdapter : BaseAdapter<Characteristic>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Characteristic> {
        return CharacteristicViewHolder(parent)
    }
}