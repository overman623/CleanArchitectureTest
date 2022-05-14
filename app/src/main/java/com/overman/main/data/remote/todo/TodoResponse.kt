package com.overman.main.data.remote.todo

data class TodoResponse (
    val id: Int = 0,
    val userId: Int = 0,
    val title: String = "",
    val completed: Boolean = false
)