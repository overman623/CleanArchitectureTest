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

    // 엑티비티 실행시 처음으로 불러내는 데이터
    fun loadImageData(limit: Int) {
        viewEvent(Event(EVENT_SHOW_LOADING_VIEW))
        viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler { _, throwable ->
            Log.e(TAG, throwable.message ?: "")
            viewEvent(Event(EVENT_HIDE_LOADING_VIEW))
        }) {

            // 1. 메모리에 데이터가 있는지 확인 - 처음 데이터를 부르는 곳에서는 메모리에 데이터가 상주하고 있지 않음.
            imageResponseDataList.value?: let {
                val list = imageUseCase.getLocalDataList() // 모든 데이터에 대한 리스트 값을 가져와야함.
                if (list.isNotEmpty()) {
                     Log.d(TAG, "2. 데이터 베이스에 데이터가 있는지 확인")
                    // 기존 데이터 베이스에서 데이터를 가져오기 때문에 데이터 베이스는 갱신하지 않음.
                    _currentPage.postValue((list.size * 0.1f).toInt())
                    _imageResponseDataList.postValue(list.map { it.mapper() })
                } else {
                     Log.d(TAG, "3. 둘다 데이터가 없으면, api로 데이터 호출")
                    _currentPage.postValue(1)
                    val result = imageUseCase.getRemoteData(0, limit)
                    // 4. 데이터 호출 완료시 데이터 베이스에 데이터 추가 및 메모리에 데이터 갱신
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