package com.rafaelneves.anacosmeticos.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rafaelneves.anacosmeticos.data.local.dao.BoxDetailsDao
import com.rafaelneves.anacosmeticos.data.local.dao.ProductBoxDetailsDao
import com.rafaelneves.anacosmeticos.data.local.dao.ProductDetailsDao
import com.rafaelneves.anacosmeticos.data.local.dao.ShippingDetailsDao
import com.rafaelneves.anacosmeticos.data.model.ProductDetails

@Database(
    entities = [ProductDetails::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun boxDetailsDao(): BoxDetailsDao
    abstract fun productBoxDetailsDao(): ProductBoxDetailsDao
    abstract fun productDetailsDao(): ProductDetailsDao
    abstract fun shippingDetailsDao(): ShippingDetailsDao
}