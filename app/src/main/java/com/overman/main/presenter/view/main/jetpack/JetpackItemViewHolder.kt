package com.overman.main.presenter.view.main.jetpack

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.overman.main.databinding.ItemShopBinding

class JetpackItemViewHolder(private val binding: ItemShopBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: JetpackListData) {
        binding.shopListData = item
        binding.viewHolder = this
    }

    fun itemClick(view: View) {
        when(binding.shopListData.id) {
            JetpackFragment.INDEX_WORKER_MANAGER -> {

            } else -> {

            }
        }
        Toast.makeText(view.context, "btnClick + ${binding.shopListData}", Toast.LENGTH_SHORT).show()
    }

}
