package com.overman.main.domain.repository.image

import com.overman.main.data.remote.image.ImageRemoteDataSource
import com.overman.main.data.remote.image.ImageResponse
import javax.inject.Inject


class ImageRemoteRepositoryImpl @Inject constructor(private val imageRemoteDataSource: ImageRemoteDataSource): ImageRemoteRepository {
    override suspend fun getImageData(page: Int, limit: Int): List<ImageResponse> = imageRemoteDataSource.getImageDataAsync(page, limit)
}