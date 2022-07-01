package com.overman.main.data.remote.image

import com.overman.main.domain.model.image.ImageResponse

interface ImageRemoteDataSource {
    suspend fun getImageDataAsync(page: Int, limit: Int): List<ImageResponse>
}