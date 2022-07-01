package com.overman.main.presenter.di

import com.overman.main.data.local.image.ImageLocalDataSource
import com.overman.main.data.local.image.ImageLocalDataSourceImpl
import com.overman.main.data.remote.todo.TodoRemoteDataSourceImpl
import com.overman.main.data.local.todo.TodoLocalDataSource
import com.overman.main.data.local.todo.TodoLocalDataSourceImpl
import com.overman.main.data.remote.image.ImageRemoteDataSource
import com.overman.main.data.remote.image.ImageRemoteDataSourceImpl
import com.overman.main.data.remote.todo.TodoRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceModule {

    // 함수 반환 유형은 함수가 인스턴스를 제공하는 인터페이스를 Hilt에 알려줍니다.
    // 함수 매개변수는 제공할 구현을 Hilt에 알려줍니다.

    @Binds
    abstract fun bindTodoRemoteDataSource(todoRemoteDataSource: TodoRemoteDataSourceImpl): TodoRemoteDataSource

    @Binds
    abstract fun bindTodoLocalDataSource(todoLocalDataSource: TodoLocalDataSourceImpl): TodoLocalDataSource

    @Binds
    abstract fun bindImageRemoteDataSource(imageRemoteDataSource: ImageRemoteDataSourceImpl): ImageRemoteDataSource

    @Binds
    abstract fun bindImageLocalDataSource(imageLocalDataSource: ImageLocalDataSourceImpl): ImageLocalDataSource

}