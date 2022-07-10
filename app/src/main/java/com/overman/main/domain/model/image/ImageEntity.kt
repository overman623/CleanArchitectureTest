package com.overman.main.domain.model.image

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.overman.main.data.local.image.ImageDatabase

@Entity(tableName = ImageDatabase.TABLE_NAME_IMAGE_DATA)
data class ImageEntity(
    @PrimaryKey(autoGenerate = true)
    val index: Int = 0,
    val id: String = "",
    val author: String = "",
    val width: Int = 0,
    val height: Int = 0,
    val url: String = "",
    val download_url: String = "",
    val like: Int = 0
)

fun ImageEntity.mapper() = Image(
    id = this.id,
    author = this.author,
    width = this.width,
    height = this.height,
    url = this.url,
    download_url = this.download_url,
    like = this.like
)