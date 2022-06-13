package com.overman.main.presenter.view.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.overman.main.databinding.ItemHomeBinding

class HomeItemAdapter(private var itemList: ArrayList<HomeListData>) : RecyclerView.Adapter<HomeItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemViewHolder {
        val binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context))
        return HomeItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}

class HomeItemViewHolder(private val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: HomeListData) {
        binding.homeListData = item
        binding.viewHolder = this
    }

    fun itemClick(view: View) {
        Toast.makeText(view.context, "btnClick + ${binding.homeListData}", Toast.LENGTH_SHORT).show()
    }

}

