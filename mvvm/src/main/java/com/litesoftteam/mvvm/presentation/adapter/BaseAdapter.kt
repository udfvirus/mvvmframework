package com.litesoftteam.mvvm.presentation.adapter

import androidx.recyclerview.widget.RecyclerView


abstract class BaseAdapter<T : Any> : RecyclerView.Adapter<BaseViewHolder<T>>() {

    private val items = arrayListOf<T>()

    fun addItem(item: T) {
        items.add(item)
        notifyItemInserted(items.lastIndex)
    }

    fun addItems(itemList: List<T>) {
        items.addAll(itemList)
        notifyItemRangeInserted(items.size - itemList.size, itemList.size)
    }

    fun removeItem(item: T) {
        val position = items.indexOf(item)
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun getItemList(): List<T> = items

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(items[position])
    }
}