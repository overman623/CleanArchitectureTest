package com.overman.main.presenter.view.imageselect

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.overman.main.databinding.ItemImageBinding
import com.overman.main.domain.model.image.Image

class ImageViewHolder(private val binding: ItemImageBinding, private val actionCheckLike: ((String, Int) -> Boolean)? = null, private val actionItemClick: ((String?) -> Unit)? = null) : RecyclerView.ViewHolder(binding.root) {

    fun bind(image: Image) {
        binding.image = image
        binding.viewHolder = this
    }

    fun itemClick(view: View) {
        actionItemClick?.invoke(binding.image?.id)
    }

    fun checkLike(view: View) {
        val like = if (binding.cbLike.isChecked) {
            1
        } else {
            0
        }
        val success = actionCheckLike?.invoke(binding.image?.id ?: "", like)
        if (success == true) {
            binding.image?.like = like
        }
    }

}
