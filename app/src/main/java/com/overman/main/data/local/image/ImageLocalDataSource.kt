package com.overman.main.data.local.image

import com.overman.main.domain.model.image.ImageEntity

interface ImageLocalDataSource {
    fun getImageDataList() : List<ImageEntity>
    fun getImageDataByIndex(index: Int) : ImageEntity?
    fun getImageDataById(id: String) : ImageEntity?
    fun insertAll(imageDataEntity: List<ImageEntity>)
    fun updateLike(id: String, like: Int)
    fun delete()
}