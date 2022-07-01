package com.overman.main.domain.usecase.image

import com.overman.main.domain.model.image.Image
import com.overman.main.domain.model.image.ImageEntity
import com.overman.main.domain.model.image.mapper
import com.overman.main.domain.repository.image.ImageLocalRepository
import com.overman.main.domain.repository.image.ImageRemoteRepository
import javax.inject.Inject

class ImageUseCase @Inject constructor(private val imageRemoteRepository: ImageRemoteRepository, private val imageLocalRepository: ImageLocalRepository) {

    suspend fun getRemoteData(page: Int, limit: Int): List<Image> = imageRemoteRepository.getImageData(page, limit).map { it.mapper() }

    fun getLocalDataList() : List<ImageEntity> = imageLocalRepository.getImageDataList()
    fun getLocalDataByIndex(index: Int) : ImageEntity? = imageLocalRepository.getImageDataByIndex(index)
    fun getLocalDataById(id: String) : ImageEntity? = imageLocalRepository.getImageDataById(id)
    fun insertAll(imageDataEntity: List<ImageEntity>) {
        imageLocalRepository.insertAll(imageDataEntity)
    }
    fun updateLocalDataLike(id: String, like: Int) {
        imageLocalRepository.updateLike(id, like)
    }
    fun deleteLocalData() {
        imageLocalRepository.delete()
    }

}
