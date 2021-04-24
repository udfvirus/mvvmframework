package com.litesoftteam.mvvm.sample.presentation.adapter.viewholder

import android.view.ViewGroup
import com.litesoftteam.mvvm.presentation.adapter.BaseViewHolder
import com.litesoftteam.mvvm.sample.R
import com.litesoftteam.mvvm.sample.core.entity.Characteristic
import kotlinx.android.synthetic.main.layout_characteristic.view.*

class CharacteristicViewHolder(parent: ViewGroup) : BaseViewHolder<Characteristic>(parent, R.layout.layout_characteristic) {

    override fun bind(item: Characteristic) {
        super.bind(item)

        println("test: CharacteristicViewHolder.bind")

        itemView.nameTextView.text = item.name
        itemView.valueTextView.text = item.value
    }
}