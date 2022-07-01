package com.overman.main.domain.repository.image

import com.overman.main.data.local.image.ImageLocalDataSource
import com.overman.main.domain.model.image.ImageEntity
import javax.inject.Inject

class ImageLocalRepositoryImpl @Inject constructor(private val imageLocalDataSource: ImageLocalDataSource): ImageLocalRepository {
    override fun getImageDataList(): List<ImageEntity> = imageLocalDataSource.getImageDataList()

    override fun getImageDataByIndex(index: Int): ImageEntity? = imageLocalDataSource.getImageDataByIndex(index)

    override fun getImageDataById(id: String): ImageEntity? = imageLocalDataSource.getImageDataById(id)

    override fun insertAll(imageDataEntity: List<ImageEntity>) = imageLocalDataSource.insertAll(imageDataEntity)

    override fun updateLike(id: String, like: Int) = imageLocalDataSource.updateLike(id, like)

    override fun delete() = imageLocalDataSource.delete()
}