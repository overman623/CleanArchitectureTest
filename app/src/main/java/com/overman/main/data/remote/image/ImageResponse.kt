package com.overman.main.data.remote.image

data class ImageResponse(
    val id: String = "",
    val author: String = "",
    val width: Int = 0,
    val height: Int = 0,
    val url: String = "",
    val download_url: String = "",
    var like: Int = 0
)