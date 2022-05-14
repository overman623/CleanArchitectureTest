package com.overman.main.data.local.todo

import com.overman.main.domain.model.todo.TodoEntity

interface TodoLocalDataSource {

    suspend fun insertTodo(entities: List<TodoEntity>)

    fun putTodoUpdateTime(time: String)
    fun getTodoUpdateTime(): String
}