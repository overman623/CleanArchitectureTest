package com.overman.main.domain.model.image

import com.overman.main.data.remote.image.ImageResponse

data class Image(
    val id: String = "",
    val author: String = "",
    val width: Int = 0,
    val height: Int = 0,
    val url: String = "",
    val download_url: String = "",
    var like: Int = 0
)

fun ImageResponse.mapper() = Image(
    id = this.id,
    author = this.author,
    width = this.width,
    height = this.height,
    url = this.url,
    download_url = this.download_url,
    like = this.like,
)

fun Image.mapper() = ImageEntity(
    id = this.id,
    author = this.author,
    width = this.width,
    height = this.height,
    url = this.url,
    download_url = this.download_url,
    like = this.like,
)