package com.rafaelneves.anacosmeticos.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductBoxDetails(
    @PrimaryKey val id: Int,
    val product: Int,
    val amount: Int
)
