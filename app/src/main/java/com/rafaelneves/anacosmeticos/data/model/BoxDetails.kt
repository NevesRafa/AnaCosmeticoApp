package com.rafaelneves.anacosmeticos.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BoxDetails(
    @PrimaryKey val id: Int,
    val product: List<ProductBoxDetails>,
    val length: Double,
    val height: Double,
    val width: Double,
    val weight: Double
)
