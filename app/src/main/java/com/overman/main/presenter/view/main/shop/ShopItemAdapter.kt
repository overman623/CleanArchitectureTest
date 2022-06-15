package com.overman.main.presenter.view.main.shop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.overman.main.databinding.ItemSettingBinding
import com.overman.main.databinding.ItemShopBinding

class ShopItemAdapter(private var itemList: ArrayList<ShopListData>) : RecyclerView.Adapter<ShopItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val binding = ItemShopBinding.inflate(LayoutInflater.from(parent.context))
        return ShopItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}


