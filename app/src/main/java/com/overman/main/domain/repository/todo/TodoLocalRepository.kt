package com.overman.main.domain.repository.todo

import com.overman.main.domain.model.todo.TodoEntity

interface TodoLocalRepository {
    suspend fun getData(): List<TodoEntity>
    suspend fun addData(todo: TodoEntity)
    suspend fun deleteData(todo: TodoEntity)
}