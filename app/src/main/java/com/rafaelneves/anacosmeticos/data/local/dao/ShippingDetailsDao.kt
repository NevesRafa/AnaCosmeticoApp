package com.rafaelneves.anacosmeticos.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.rafaelneves.anacosmeticos.data.model.ShippingDetails

@Dao
interface ShippingDetailsDao {
    @Query("SELECT * FROM ShippingDetails")
    fun getAllShipping(): List<ShippingDetails>

    @Query("SELECT * FROM ShippingDetails WHERE id = :id")
    fun getShippingById(id: Int): ShippingDetails?

    @Insert
    fun insertShipping(shippingDetails: ShippingDetails)

    @Delete
    fun deleteShipping(shippingDetails: ShippingDetails)
}