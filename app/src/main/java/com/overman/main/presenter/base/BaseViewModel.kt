package com.overman.main.presenter.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.overman.main.presenter.util.CLog
import com.overman.main.presenter.util.livedata.Event
import kotlinx.coroutines.*
import retrofit2.HttpException
import java.io.Serializable
import java.net.SocketException
import java.net.UnknownHostException
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class BaseViewModel : ViewModel(), CoroutineScope {

    companion object {
        const val EVENT_COROUTINE_EXCEPTION = 400
        const val EVENT_SOCKET_EXCEPTION = 401
        const val EVENT_HTTP_EXCEPTION = 402
        const val EVENT_UNKNOWN_HOST_EXCEPTION = 403
        const val EVENT_SHOW_LOADING_VIEW = 1000
        const val EVENT_HIDE_LOADING_VIEW = 2000
    }

    override val coroutineContext: CoroutineContext
        get() = viewModelScope.coroutineContext

    private val _viewEvent = MutableLiveData<Event<Any>>()
    val viewEvent: LiveData<Event<Any>>
        get() = _viewEvent


    open val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        CLog.e(throwable.message)
        when (throwable) {
            is SocketException -> viewEvent(EVENT_SOCKET_EXCEPTION) // Bad Internet
            is HttpException -> viewEvent(EVENT_HTTP_EXCEPTION) // Parse Error
            is UnknownHostException -> viewEvent(EVENT_UNKNOWN_HOST_EXCEPTION) // Wrong connection
            else -> viewEvent(EVENT_COROUTINE_EXCEPTION)
        }
        viewEvent(throwable.stackTrace[0].className)
    }

    fun launch(
        context: CoroutineContext = EmptyCoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
    ) = viewModelScope.launch(context + this.exceptionHandler, start, block)


    fun viewEvent(content: Any) {
        _viewEvent.postValue(Event(content))
    }

    fun showLoadingView() {
        _viewEvent.value = Event(EVENT_SHOW_LOADING_VIEW)
    }

    fun hideLoadingView() {
        _viewEvent.value = Event(EVENT_HIDE_LOADING_VIEW)
    }

}