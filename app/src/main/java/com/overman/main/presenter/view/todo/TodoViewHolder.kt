package com.overman.main.presenter.view.todo

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.overman.main.databinding.ItemTodoBinding
import com.overman.main.domain.model.todo.Todo

class TodoViewHolder(private val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(todo: Todo) {
        binding.todo = todo
        binding.viewHolder = this
    }

    fun itemClick(view: View) {
        Toast.makeText(view.context, "btnClick + ${binding.todo?.id}", Toast.LENGTH_SHORT).show()
    }

}