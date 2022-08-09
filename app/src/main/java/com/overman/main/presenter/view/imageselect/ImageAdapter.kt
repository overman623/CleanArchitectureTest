package com.overman.main.presenter.view.imageselect

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.overman.main.databinding.ItemImageBinding
import com.overman.main.domain.model.image.Image

class ImageAdapter(private val imageList: MutableList<Image> = mutableListOf(), private val actionCheckLike: ((String, Int) -> Unit)? = null): ListAdapter<Image, ImageViewHolder>(ImageDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context))
        return ImageViewHolder(binding, actionCheckLike)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItem(position: Int) = imageList[position]

    override fun getItemCount(): Int {
        return imageList.size
    }

    fun addData(imageList: List<Image>?) {
        if (imageList != null) {
            this.imageList.addAll(imageList)
            submitList(this.imageList)
        }
    }
}