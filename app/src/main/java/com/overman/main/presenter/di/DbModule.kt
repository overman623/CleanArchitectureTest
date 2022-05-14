package com.overman.main.presenter.di

import android.content.Context
import androidx.room.Room
import com.overman.main.data.local.todo.TodoDao
import com.overman.main.data.local.todo.TodoDatabase
import com.overman.main.domain.repository.todo.TodoLocalRepository
import com.overman.main.domain.repository.todo.TodoLocalRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Singleton
    @Provides
    fun provideTodoDatabase(@ApplicationContext context: Context) : TodoDatabase {
        return Room.databaseBuilder(
            context,
            TodoDatabase::class.java,
            TodoDatabase.DATABASE_NAME
        ).build()
    }

}