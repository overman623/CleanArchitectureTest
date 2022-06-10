package com.overman.main.presenter.view.todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.overman.main.domain.model.todo.TodoEntity
import com.overman.main.domain.model.todo.Todo
import com.overman.main.domain.usecase.todo.TodoUseCase
import com.overman.main.presenter.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(private val todoUseCase: TodoUseCase) : BaseViewModel() {

    companion object {
        const val EVENT_SHOW_TODO_SUCCESS = 3000
        const val EVENT_SHOW_TODO_FAIL = 4000
    }

    private val _todoRemoteData = MutableLiveData<List<Todo>>()
    val todoRemoteData : LiveData<List<Todo>>
        get() = _todoRemoteData

    private val _todoLocalData = MutableLiveData<List<TodoEntity>>()
    val todoLocalData : LiveData<List<TodoEntity>>
        get() = _todoLocalData

    fun todoList() = launch(Dispatchers.Main) {

        showLoadingView()

        val result = withContext(Dispatchers.IO) {
            todoUseCase.getRemoteData()
        }
//        _todoLocalData.postValue(todoUseCase.getLocalData())

        delay(1000)
        hideLoadingView()

        if (!result.isNullOrEmpty()) {
            _todoRemoteData.value = result
            viewEvent(EVENT_SHOW_TODO_SUCCESS)
        } else {
            viewEvent(EVENT_SHOW_TODO_FAIL)
        }
    }

}
