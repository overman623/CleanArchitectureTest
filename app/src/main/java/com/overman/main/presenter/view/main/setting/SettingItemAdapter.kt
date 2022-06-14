package com.overman.main.presenter.view.main.setting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.overman.main.databinding.ItemHomeBinding
import com.overman.main.databinding.ItemSettingBinding

class SettingItemAdapter(private var itemList: ArrayList<SettingListData>) : RecyclerView.Adapter<SettingItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingItemViewHolder {
        val binding = ItemSettingBinding.inflate(LayoutInflater.from(parent.context))
        return SettingItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SettingItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}


