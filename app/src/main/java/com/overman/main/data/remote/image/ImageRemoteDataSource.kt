package com.overman.main.data.remote.image

interface ImageRemoteDataSource {
    suspend fun getImageDataAsync(page: Int, limit: Int): List<ImageResponse>
}