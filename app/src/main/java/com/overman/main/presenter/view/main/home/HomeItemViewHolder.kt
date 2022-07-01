package com.overman.main.presenter.view.main.home

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.overman.main.databinding.ItemHomeBinding

class HomeItemViewHolder(private val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {

    lateinit var homeListData: HomeListData

    fun bind(item: HomeListData) {
        homeListData = item
        binding.homeListData = homeListData
        binding.viewHolder = this
    }

    fun itemClick(view: View) {
        val data = homeListData
        when (data.id) {
            0 -> {
                view.context.startActivity(Intent())
            } else -> {
                Toast.makeText(view.context, "btnClick + ${binding.homeListData}", Toast.LENGTH_SHORT).show()
            }
        }

    }

}
