package com.overman.main.data.local.image

import androidx.room.Database
import androidx.room.RoomDatabase
import com.overman.main.domain.model.image.ImageEntity

@Database(entities = [ImageEntity::class], version = 1, exportSchema = false)
abstract class ImageDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "Image.db"
        const val TABLE_NAME_IMAGE_DATA = "tb_image"
    }

    abstract fun imageDAO() : ImageDao

}