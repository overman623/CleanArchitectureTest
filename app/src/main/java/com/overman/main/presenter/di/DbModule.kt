package com.overman.main.presenter.di

import android.content.Context
import androidx.room.Room
import com.overman.main.data.local.image.ImageDatabase
import com.overman.main.data.local.todo.TodoDatabase
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

    @Singleton
    @Provides
    fun provideImageDatabase(@ApplicationContext context: Context) : ImageDatabase {
        return Room.databaseBuilder(
            context,
            ImageDatabase::class.java,
            ImageDatabase.DATABASE_NAME
        ).build()
    }

}