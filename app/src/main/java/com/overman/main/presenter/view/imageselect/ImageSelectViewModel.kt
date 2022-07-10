package com.overman.main.presenter.view.imageselect

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.overman.main.domain.model.image.Image
import com.overman.main.domain.model.image.mapper
import com.overman.main.domain.usecase.image.ImageUseCase
import com.overman.main.presenter.base.BaseViewModel
import com.overman.main.presenter.util.livedata.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class ImageSelectViewModel @Inject constructor(private val imageUseCase: ImageUseCase) : BaseViewModel() {

    companion object {
        const val TAG = "ImageData"
    }

    private val _imageResponseDataList = MutableLiveData<List<Image>>()
    val imageDataList: LiveData<List<Image>>
        get() = _imageResponseDataList

    private val _currentPage = MutableLiveData<Int>()
    private val currentPage: LiveData<Int>
        get() = _currentPage

    fun loadImageData(limit: Int) {
        viewEvent(Event(EVENT_SHOW_LOADING_VIEW))
        _currentPage.postValue(1)
        viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler { _, throwable ->
            Log.e(TAG, throwable.message ?: "")
            viewEvent(Event(EVENT_HIDE_LOADING_VIEW))
        }) {
//            imageUseCase.deleteLocalData()
            val result = imageUseCase.getRemoteData(0, limit)
            processImageData(result)
            withContext(Dispatchers.Main) {
                viewEvent(Event(EVENT_HIDE_LOADING_VIEW))
            }
        }
    }

    fun loadNextImageData(limit: Int) {
        val nextPage = (currentPage.value?.let { it + 1 } ?: 0)
        _currentPage.postValue(nextPage)
        getImageData(page = nextPage, limit)
    }

    private fun getImageData(page: Int, limit: Int) {
        viewEvent(Event(EVENT_SHOW_LOADING_VIEW))
        viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler { _, throwable ->
            Log.e(TAG, throwable.message ?: "")
            viewEvent(Event(EVENT_HIDE_LOADING_VIEW))
        }) {
            val result = imageUseCase.getRemoteData(page, limit)
            processImageData(result)
            withContext(Dispatchers.Main) {
                viewEvent(Event(EVENT_HIDE_LOADING_VIEW))
            }
        }
    }

    private suspend fun processImageData(imageList: List<Image>) {
        if (imageList.isNotEmpty()) {
            _imageResponseDataList.postValue(imageList)
            imageUseCase.insertAll(imageList.map { imageData -> imageData.mapper() })
            // 데이터 일치 확인 및 갱신
        }
    }

    fun updateLike(id: String, like: Int) {
        viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler { _, throwable ->
            Log.e(TAG, throwable.message ?: "")
        }) {
            imageUseCase.updateLocalDataLike(id, like)
        }
    }

    fun loadLocalImageData() {
        viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler { _, throwable ->
            Log.e(TAG, throwable.message ?: "")
        }) {
            val entities = imageUseCase.getLocalDataList()
            _imageResponseDataList.postValue(entities.map { entity -> entity.mapper() })
        }
    }

}