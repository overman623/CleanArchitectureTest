package com.overman.main.domain.repository.image

import com.overman.main.domain.model.image.ImageEntity

interface ImageLocalRepository  {
    fun getImageDataList() : List<ImageEntity>
    fun getImageDataByIndex(index: Int) : ImageEntity?
    fun getImageDataById(id: String) : ImageEntity?
    fun insertAll(imageDataEntity: List<ImageEntity>)
    fun updateLike(id: String, like: Int)
    fun delete()
}