package com.overman.main.data.remote.todo

import com.overman.main.data.local.todo.TodoApi

import javax.inject.Inject

class TodoRemoteDataSourceImpl @Inject constructor(private val todoApi: TodoApi) :
    TodoRemoteDataSource {

    override suspend fun getTodoDataAsync(): List<TodoResponse> = todoApi.getTodoDataAsync()

}