package com.rafaelneves.anacosmeticos.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rafaelneves.anacosmeticos.data.local.ListConverter
import com.rafaelneves.anacosmeticos.data.local.dao.BoxDetailsDao
import com.rafaelneves.anacosmeticos.data.local.dao.ProductBoxDetailsDao
import com.rafaelneves.anacosmeticos.data.local.dao.ProductDetailsDao
import com.rafaelneves.anacosmeticos.data.local.dao.ShippingDetailsDao
import com.rafaelneves.anacosmeticos.data.model.BoxDetails
import com.rafaelneves.anacosmeticos.data.model.ProductBoxDetails
import com.rafaelneves.anacosmeticos.data.model.ProductDetails
import com.rafaelneves.anacosmeticos.data.model.ShippingDetails

@Database(
    entities = [
        BoxDetails::class,
        ProductBoxDetails::class,
        ProductDetails::class,
        ShippingDetails::class],
    version = 2
)
@TypeConverters(ListConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun boxDetailsDao(): BoxDetailsDao
    abstract fun productBoxDetailsDao(): ProductBoxDetailsDao
    abstract fun productDetailsDao(): ProductDetailsDao
    abstract fun shippingDetailsDao(): ShippingDetailsDao

}