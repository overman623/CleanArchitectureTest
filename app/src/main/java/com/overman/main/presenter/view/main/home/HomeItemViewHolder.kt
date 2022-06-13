package com.overman.main.presenter.view.main.home

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.overman.main.databinding.ItemHomeBinding

class HomeItemViewHolder(private val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: HomeListData) {
        binding.homeListData = item
        binding.viewHolder = this
    }

    fun itemClick(view: View) {
        Toast.makeText(view.context, "btnClick + ${binding.homeListData}", Toast.LENGTH_SHORT).show()
    }

}
