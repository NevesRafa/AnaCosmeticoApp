package com.rafaelneves.anacosmeticos.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BoxDetails(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val length: String,
    val height: String,
    val width: String,
    val weight: Double
)
