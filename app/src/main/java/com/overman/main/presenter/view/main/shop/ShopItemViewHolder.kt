package com.overman.main.presenter.view.main.shop

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.overman.main.databinding.ItemSettingBinding
import com.overman.main.databinding.ItemShopBinding

class ShopItemViewHolder(private val binding: ItemShopBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ShopListData) {
        binding.shopListData = item
        binding.viewHolder = this
    }

    fun itemClick(view: View) {
        Toast.makeText(view.context, "btnClick + ${binding.shopListData}", Toast.LENGTH_SHORT).show()
    }

}
