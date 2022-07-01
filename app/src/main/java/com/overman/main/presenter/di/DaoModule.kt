package com.overman.main.presenter.di

import com.overman.main.data.local.image.ImageDatabase
import com.overman.main.data.local.todo.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DaoModule {

    @Provides
    @ViewModelScoped
    fun provideTodoDAO(todoDB: TodoDatabase) = todoDB.todoDAO()

    @Provides
    @ViewModelScoped
    fun provideTodoDAO(imageDB: ImageDatabase) = imageDB.imageDAO()

}