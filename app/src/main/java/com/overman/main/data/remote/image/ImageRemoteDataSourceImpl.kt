package com.overman.main.data.remote.image

import javax.inject.Inject

class ImageRemoteDataSourceImpl @Inject constructor(private val imageApi: ImageApi): ImageRemoteDataSource {
    override suspend fun getImageDataAsync(page: Int, limit: Int): List<ImageResponse> = imageApi.getData(page, limit)
}