package com.overman.main.domain.model.todo

import com.overman.main.data.remote.todo.TodoResponse

data class Todo(val id: Int = 0,
                val userId: Int = 0,
                val title: String = "",
                val completed: Boolean = false)

fun TodoResponse.mapper() = Todo(
    id = this.id,
    userId = this.userId,
    title = this.title,
    completed = this.completed
)