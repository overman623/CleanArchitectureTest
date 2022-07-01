package com.overman.main.data.remote.image

import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApi {
    @GET("v2/list")
    suspend fun getData(@Query("page") page: Int, @Query("limit") limit: Int): List<ImageResponse>
}