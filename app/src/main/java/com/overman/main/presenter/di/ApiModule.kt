package com.overman.main.presenter.di

import com.overman.main.data.local.todo.TodoApi
import com.overman.main.data.remote.todo.TodoRemoteDataSource
import com.overman.main.data.remote.todo.TodoRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object ApiModule {

    @Provides
    @ViewModelScoped
    fun provideTodoRemoteApi(retrofit: Retrofit): TodoApi = retrofit.create(TodoApi::class.java)

}