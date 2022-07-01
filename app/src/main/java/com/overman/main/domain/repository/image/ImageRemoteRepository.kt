package com.overman.main.domain.repository.image

import com.overman.main.data.remote.image.ImageResponse


interface ImageRemoteRepository {
    suspend fun getImageData(page: Int, limit: Int): List<ImageResponse>
}