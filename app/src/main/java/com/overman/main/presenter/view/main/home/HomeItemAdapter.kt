package com.overman.main.presenter.view.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
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


