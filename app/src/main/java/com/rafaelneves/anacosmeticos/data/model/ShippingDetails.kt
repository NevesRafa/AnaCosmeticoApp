package com.rafaelneves.anacosmeticos.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ShippingDetails(
    @PrimaryKey val id: Int,
    val boxList: List<BoxDetails>,
    val boxAmount: Int,
    val productAmount: Int
)
