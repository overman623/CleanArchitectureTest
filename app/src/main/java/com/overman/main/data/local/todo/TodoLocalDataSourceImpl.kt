package com.overman.main.data.local.todo

import android.content.SharedPreferences
import com.overman.main.domain.model.todo.TodoEntity
import com.overman.main.presenter.util.AppPreference
import javax.inject.Inject

class TodoLocalDataSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val todoDao: TodoDao
) : TodoLocalDataSource {

    override suspend fun insertTodo(entities: List<TodoEntity>) {
//        todoDao.insertTodo(entities)
    }

    override fun putTodoUpdateTime(time: String) {
        sharedPreferences.edit().putString(AppPreference.PREF_TODO_UPDATE, time).apply()
    }

    override fun getTodoUpdateTime(): String = sharedPreferences.getString(AppPreference.PREF_TODO_UPDATE, "") ?: ""

}