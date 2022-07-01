package com.overman.main.presenter.view.imageselect

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.overman.main.domain.model.image.Image
import com.overman.main.domain.model.image.mapper
import com.overman.main.domain.usecase.image.ImageUseCase
import com.overman.main.presenter.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class ImageSelectViewModel @Inject constructor(private val imageUseCase: ImageUseCase)  : BaseViewModel() {

    companion object {
        const val TAG = "ImageData"
    }

    private val _imageResponseDataList = MutableLiveData<List<Image>>()
    val imageDataList: LiveData<List<Image>>
        get() = _imageResponseDataList

    private val _currentPage = MutableLiveData<Int>()
    private val currentPage: LiveData<Int>
        get() = _currentPage

    private val _isProgress = MutableLiveData<Boolean>()
    val isProgress: LiveData<Boolean>
        get() = _isProgress

    fun loadImageData(limit: Int) {
        _isProgress.postValue(true)
        _currentPage.postValue(0)
        viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler { _, throwable ->
            Log.e(TAG, throwable.message ?: "")
            _isProgress.postValue(false)
        }) {
            imageUseCase.deleteLocalData()
            val result = imageUseCase.getRemoteData(0, limit)
            processImageData(result)
            withContext(Dispatchers.Main) {
                _isProgress.postValue(false)
            }
        }
    }

    fun loadNextImageData(limit: Int) {
        if (isProgress.value != true) {
            val nextPage = (currentPage.value?.let { it + 1 } ?: 0)
            _currentPage.postValue(nextPage)
            getImageData(page = nextPage, limit)
        }
    }

    private fun getImageData(page: Int, limit: Int) {
        _isProgress.postValue(true)
        viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler { _, throwable ->
            Log.e(TAG, throwable.message ?: "")
            _isProgress.postValue(false)
        }) {
            val result = imageUseCase.getRemoteData(page, limit)
            processImageData(result)
            withContext(Dispatchers.Main) {
                _isProgress.postValue(false)
            }
        }
    }

    private suspend fun processImageData(imageList: List<Image>) {
        if (imageList.isNotEmpty()) {
            _imageResponseDataList.postValue(imageList)
            imageUseCase.insertAll(imageList.map { imageData -> imageData.mapper() })
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