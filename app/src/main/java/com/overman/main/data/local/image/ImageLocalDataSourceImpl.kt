package com.overman.main.data.local.image

import com.overman.main.domain.model.image.ImageEntity
import javax.inject.Inject

class ImageLocalDataSourceImpl @Inject constructor(private val imageDao: ImageDao): ImageLocalDataSource {

    override fun getImageDataList(): List<ImageEntity> = imageDao.getImageDataList()
    override fun getImageDataByIndex(index: Int): ImageEntity? = imageDao.getImageDataByIndex(index)
    override fun getImageDataById(id: String): ImageEntity? = imageDao.getImageDataById(id)
    override fun insertAll(imageDataEntity: List<ImageEntity>) = imageDao.insertAll(imageDataEntity)
    override fun updateLike(id: String, like: Int) = imageDao.updateLike(id, like)
    override fun delete() = imageDao.delete()

}