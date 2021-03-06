package com.overman.main.presenter.view.main.home

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.overman.main.databinding.ItemHomeBinding
import com.overman.main.presenter.view.imageselect.ImageSelectActivity

class HomeItemViewHolder(private val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        const val IMAGE_SELECT_INDEX = 0
    }

    lateinit var homeListData: HomeListData

    fun bind(item: HomeListData) {
        homeListData = item
        binding.homeListData = homeListData
        binding.viewHolder = this
    }

    fun itemClick(view: View) {
        val data = homeListData
        when (data.id) {
            IMAGE_SELECT_INDEX -> {
                view.context.startActivity(Intent(view.context, ImageSelectActivity::class.java))
            } else -> {
                Toast.makeText(view.context, "btnClick + ${binding.homeListData}", Toast.LENGTH_SHORT).show()
            }
        }

    }

}
