package com.rafaelneves.anacosmeticos.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.rafaelneves.anacosmeticos.data.model.BoxDetails

@Dao
interface BoxDetailsDao {
    @Query("SELECT * FROM BoxDetails")
    fun getAllBox(): List<BoxDetails>

    @Update
    fun update(boxDetails: BoxDetails)

    @Insert
    fun insertBox(boxDetails: BoxDetails)

    @Delete
    fun deleteBox(boxDetails: BoxDetails)
}