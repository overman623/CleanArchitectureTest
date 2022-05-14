package com.overman.main.domain.repository.todo

import com.overman.main.data.remote.todo.TodoResponse
import kotlinx.coroutines.Deferred

interface TodoRemoteRepository {
    suspend fun getData(): List<TodoResponse>
}