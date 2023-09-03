package com.rafaelneves.anacosmeticos.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductDetails(
    @PrimaryKey val id: Int,
    val productName: String,
    val productDescription: String,
    val productAmount: Int,
    val productForm: String
)
