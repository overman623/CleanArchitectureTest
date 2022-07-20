package com.overman.main.presenter.view.main.jetpack

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.overman.main.databinding.ItemShopBinding

class JetpackItemAdapter(private var itemList: ArrayList<JetpackListData>) : RecyclerView.Adapter<JetpackItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JetpackItemViewHolder {
        val binding = ItemShopBinding.inflate(LayoutInflater.from(parent.context))
        return JetpackItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JetpackItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}


