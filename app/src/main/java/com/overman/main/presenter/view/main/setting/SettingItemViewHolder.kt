package com.overman.main.presenter.view.main.setting

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.overman.main.databinding.ItemHomeBinding
import com.overman.main.databinding.ItemSettingBinding

class SettingItemViewHolder(private val binding: ItemSettingBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: SettingListData) {
        binding.settingListData = item
        binding.viewHolder = this
    }

    fun itemClick(view: View) {
        Toast.makeText(view.context, "btnClick + ${binding.settingListData.title}", Toast.LENGTH_SHORT).show()
    }

}
