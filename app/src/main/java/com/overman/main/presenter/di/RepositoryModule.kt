package com.overman.main.presenter.di

import com.overman.main.domain.repository.image.ImageLocalRepository
import com.overman.main.domain.repository.image.ImageLocalRepositoryImpl
import com.overman.main.domain.repository.image.ImageRemoteRepository
import com.overman.main.domain.repository.image.ImageRemoteRepositoryImpl
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
    abstract fun bindTodoRemoteRepository(todoRemoteRepository: TodoRemoteRepositoryImpl) : TodoRemoteRepository

    @Binds
    abstract fun bindImageLocalRepository(imageLocalRepository: ImageLocalRepositoryImpl) : ImageLocalRepository

    @Binds
    abstract fun bindImageRemoteRepository(imageRemoteRepository: ImageRemoteRepositoryImpl) : ImageRemoteRepository

}