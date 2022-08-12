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
    val imageResponseDataList: LiveData<List<Image>>
        get() = _imageResponseDataList

    private val _currentPage = MutableLiveData<Int>()
    private val currentPage: LiveData<Int>
        get() = _currentPage

    private val _currentImage = MutableLiveData<Image>()
    val currentImage: LiveData<Image>
        get() = _currentImage

    fun loadImageData(limit: Int) {
        viewEvent(Event(EVENT_SHOW_LOADING_VIEW))
        viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler { _, throwable ->
            Log.e(TAG, throwable.message ?: "")
            viewEvent(Event(EVENT_HIDE_LOADING_VIEW))
        }) {
            imageResponseDataList.value?: let {
                val list = imageUseCase.getLocalDataList()
                if (list.isNotEmpty()) {
                    Log.d(TAG, "2. 데이터 베이스에 데이터가 있는지 확인")
                    val sb = StringBuilder()
                    list.forEach {
                        sb.append(it.id).append(',')
                    }
                    Log.d(TAG, "list ids : ${sb.toString()}")
                    Log.d(TAG, "list size : ${list.size}")
                    Log.d(TAG, "currentPage : ${(list.size * 0.1f).toInt()}")
                    _currentPage.postValue((list.size * 0.1f).toInt())
                    _imageResponseDataList.postValue(list.map { it.mapper() })
                } else {
                     Log.d(TAG, "3. 둘다 데이터가 없으면, api로 데이터 호출")
                    _currentPage.postValue(1)
                    val result = imageUseCase.getRemoteData(0, limit)
                    processImageData(result)
                }
            }

            withContext(Dispatchers.Main) {
                viewEvent(Event(EVENT_HIDE_LOADING_VIEW))
            }
        }
    }

    fun loadNextImageData(limit: Int) {
        val nextPage = (currentPage.value?.let { it + 1 } ?: 0)
        Log.d(TAG, "nextPage : $nextPage")
        _currentPage.postValue(nextPage)
        loadImageData(page = nextPage, limit)
    }

    private fun loadImageData(page: Int, limit: Int) {
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

    private fun processImageData(imageList: List<Image>) {
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

    fun loadLocalImage(imageId: String) {
        viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler { _, throwable ->
            Log.e(TAG, throwable.message ?: "")
        }) {
            val entity = imageUseCase.getLocalDataById(imageId)
            _currentImage.postValue(entity?.mapper())
        }
    }

}