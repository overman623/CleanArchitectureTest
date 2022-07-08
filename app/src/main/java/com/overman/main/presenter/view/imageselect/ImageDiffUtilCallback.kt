package com.overman.main.presenter.view.imageselect

import androidx.recyclerview.widget.DiffUtil
import com.overman.main.domain.model.image.Image

class ImageDiffUtilCallback(private val oldList: List<Image>, private val newList: List<Image>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}