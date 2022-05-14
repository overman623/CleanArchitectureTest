package com.overman.main.data.remote.todo

import kotlinx.coroutines.Deferred

interface TodoRemoteDataSource {
    suspend fun getTodoDataAsync(): List<TodoResponse>
}