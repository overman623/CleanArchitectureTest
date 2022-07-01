package com.overman.main.data.local.image

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.overman.main.domain.model.image.ImageEntity

@Dao
interface ImageDao {

    @Query("SELECT * FROM ${ImageDatabase.TABLE_NAME_IMAGE_DATA}")
    fun getImageDataList() : List<ImageEntity>

    @Query("SELECT * FROM ${ImageDatabase.TABLE_NAME_IMAGE_DATA} WHERE `index` == :index")
    fun getImageDataByIndex(index: Int) : ImageEntity?

    @Query("SELECT * FROM ${ImageDatabase.TABLE_NAME_IMAGE_DATA} WHERE `id` == :id")
    fun getImageDataById(id: String) : ImageEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(imageDataEntity: List<ImageEntity>)

    @Query("UPDATE ${ImageDatabase.TABLE_NAME_IMAGE_DATA} SET 'like' = :like WHERE id == :id")
    fun updateLike(id: String, like: Int)

    @Query("DELETE FROM ${ImageDatabase.TABLE_NAME_IMAGE_DATA}")
    fun delete()
}