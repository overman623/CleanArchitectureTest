package com.overman.main.data.local.todo

import com.overman.main.data.remote.todo.TodoResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface TodoApi {
    @GET("todos")
    suspend fun getTodoDataAsync(): List<TodoResponse>
}