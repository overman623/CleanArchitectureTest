package com.overman.main.presenter.view.imageselect

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.overman.main.databinding.ItemImageBinding
import com.overman.main.domain.model.image.Image

class ImageAdapter(private val imageList: MutableList<Image> = mutableListOf()): RecyclerView.Adapter<ImageViewHolder>() {

    fun setImageList(updatedImageList: List<Image>) {
        val diffResult = getDiffResult(updatedImageList)
        imageList.clear()
        imageList.addAll(updatedImageList)
        diffResult.dispatchUpdatesTo(this)
    }

    fun addImageList(updatedImageList: List<Image>) {
        val diffResult = getDiffResult(ArrayList<Image>().apply {
            addAll(imageList)
            addAll(updatedImageList)
        })
        imageList.addAll(updatedImageList)
        diffResult.dispatchUpdatesTo(this)
    }

    fun clearImageList() {
        val diffResult = getDiffResult(mutableListOf())
        imageList.clear()
        diffResult.dispatchUpdatesTo(this)
    }

    private fun getDiffResult(updatedImageList: List<Image>) = DiffUtil.calculateDiff(ImageDiffUtilCallback(imageList, updatedImageList))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context))
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private fun getItem(position: Int) = imageList[position]

    override fun getItemCount(): Int {
        return imageList.size
    }
}