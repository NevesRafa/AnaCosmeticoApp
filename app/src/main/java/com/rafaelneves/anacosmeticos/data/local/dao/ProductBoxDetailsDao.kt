package com.rafaelneves.anacosmeticos.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.rafaelneves.anacosmeticos.data.model.ProductBoxDetails

@Dao
interface ProductBoxDetailsDao {
    @Query("SELECT * FROM ProductBoxDetails")
    fun getAllProductBox(): List<ProductBoxDetails>

    @Query("SELECT * FROM ProductBoxDetails WHERE id = :id")
    fun getProductBoxById(id: Int): ProductBoxDetails?

    @Insert
    fun insertProductBox(productBoxDetails: ProductBoxDetails)

    @Delete
    fun deleteProductBox(productBoxDetails: ProductBoxDetails)
}