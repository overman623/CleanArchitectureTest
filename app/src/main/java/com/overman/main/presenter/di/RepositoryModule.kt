package com.overman.main.presenter.di

import com.overman.main.domain.repository.todo.TodoLocalRepository
import com.overman.main.domain.repository.todo.TodoLocalRepositoryImpl
import com.overman.main.domain.repository.todo.TodoRemoteRepository
import com.overman.main.domain.repository.todo.TodoRemoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindTodoLocalRepository(todoLocalRepository: TodoLocalRepositoryImpl) : TodoLocalRepository

    @Binds
    abstract fun bindRemoteTodoRepository(todoRemoteRepository: TodoRemoteRepositoryImpl) : TodoRemoteRepository

}