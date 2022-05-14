package com.overman.main.data.local.todo

import androidx.room.*
import com.overman.main.domain.model.todo.TodoEntity

@Dao
interface TodoDao {
    @Query("SELECT * FROM ${TodoDatabase.TABLE_NAME_TODO}")
    fun getTodoList() : List<TodoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(todo: TodoEntity) : Long

    @Delete
    fun delete(todo: TodoEntity)
}