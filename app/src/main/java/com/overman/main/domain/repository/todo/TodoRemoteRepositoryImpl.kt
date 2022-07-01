package com.overman.main.domain.repository.todo

import com.overman.main.data.remote.todo.TodoRemoteDataSource
import com.overman.main.data.remote.todo.TodoResponse
import javax.inject.Inject

//class TodoRemoteRepositoryImpl @Inject constructor(private val todoRemoteService: TodoApi) :
class TodoRemoteRepositoryImpl @Inject constructor(private val todoRemoteDataSource: TodoRemoteDataSource) :
    TodoRemoteRepository {

    override suspend fun getData(): List<TodoResponse> = todoRemoteDataSource.getTodoDataAsync()


}
