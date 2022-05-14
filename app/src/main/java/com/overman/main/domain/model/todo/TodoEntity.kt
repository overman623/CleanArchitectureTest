package com.overman.main.domain.model.todo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_todo")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    val index: Int = 0,
    val id: Int = 0,
    val userId: Int = 0,
    val title: String = "",
    val completed: Boolean = false
)