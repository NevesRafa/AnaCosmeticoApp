package com.rafaelneves.anacosmeticos.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BoxDetailsDao {
    @Query("SELECT * FROM BoxDetails")
    fun getAllBox(): List<BoxDetailsDao>

    @Query("SELECT * FROM BoxDetails WHERE id = :id")
    fun getBoxById(id: Int): BoxDetailsDao?

    @Insert
    fun insertBox(boxDetails: BoxDetailsDao)

    @Delete
    fun deleteBox(boxDetails: BoxDetailsDao)
}