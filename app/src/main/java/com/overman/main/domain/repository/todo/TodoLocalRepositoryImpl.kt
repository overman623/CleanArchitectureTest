package com.overman.main.domain.repository.todo

import com.overman.main.domain.model.todo.TodoEntity
import com.overman.main.data.local.todo.TodoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject



class TodoLocalRepositoryImpl @Inject constructor(private val todoDAO: TodoDao) :
    TodoLocalRepository {
    override suspend fun getData(): List<TodoEntity> = todoDAO.getTodoList()

    override suspend fun addData(todo: TodoEntity) {
        withContext(Dispatchers.IO) {
            todoDAO.insert(todo)
        }
    }

    override suspend fun deleteData(todo: TodoEntity) {
        withContext(Dispatchers.IO) {
            todoDAO.delete(todo)
        }
    }
}
