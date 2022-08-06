package com.overman.main.presenter.view.main.jetpack

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.overman.main.databinding.ItemJetpackBinding

class JetpackItemViewHolder(private val binding: ItemJetpackBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: JetpackListData) {
        binding.jetpackListData = item
        binding.viewHolder = this
    }

    fun itemClick(view: View) {
        when(binding.jetpackListData?.id) {
            JetpackFragment.INDEX_WORKER_MANAGER -> {

            } else -> {

            }
        }
        Toast.makeText(view.context, "btnClick + ${binding.jetpackListData}", Toast.LENGTH_SHORT).show()
    }

}
