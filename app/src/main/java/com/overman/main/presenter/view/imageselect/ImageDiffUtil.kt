package com.overman.main.presenter.view.imageselect

import androidx.recyclerview.widget.DiffUtil
import com.overman.main.domain.model.image.Image

object ImageDiffUtil : DiffUtil.ItemCallback<Image>() {

    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem == newItem
    }

}