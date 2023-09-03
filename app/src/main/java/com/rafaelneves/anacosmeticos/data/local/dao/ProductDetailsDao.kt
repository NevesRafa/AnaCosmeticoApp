package com.rafaelneves.anacosmeticos.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.rafaelneves.anacosmeticos.data.model.ProductDetails

@Dao
interface ProductDetailsDao {

    @Query("SELECT * FROM ProductDetails")
    fun getAllProduct(): List<ProductDetails>

    @Query("SELECT * FROM ProductDetails WHERE id = :id")
    fun getProductById(id: Int): ProductDetails?

    @Insert
    fun insertProduct(productDetails: ProductDetails)

    @Delete
    fun deleteProduct(productDetails: ProductDetails)
}