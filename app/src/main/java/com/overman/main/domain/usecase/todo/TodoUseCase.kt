package com.overman.main.domain.usecase.todo

import com.overman.main.domain.model.todo.TodoEntity
import com.overman.main.domain.model.todo.Todo
import com.overman.main.domain.model.todo.mapper
import com.overman.main.domain.repository.todo.TodoLocalRepository
import com.overman.main.domain.repository.todo.TodoRemoteRepository
import javax.inject.Inject

class TodoUseCase @Inject constructor(private val todoRemoteRepository: TodoRemoteRepository, private val todoLocalRepository: TodoLocalRepository) {

    suspend fun getRemoteData(): List<Todo> = todoRemoteRepository.getData().map { it.mapper() }
    suspend fun getLocalData(): List<TodoEntity> = todoLocalRepository.getData()

}
