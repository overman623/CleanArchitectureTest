package com.overman.main.data.local.todo

import androidx.room.Database
import androidx.room.RoomDatabase
import com.overman.main.domain.model.todo.TodoEntity

@Database(entities = [TodoEntity::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "Todo.db"
        const val TABLE_NAME_TODO = "tb_todo"
    }

    abstract fun todoDAO() : TodoDao

}