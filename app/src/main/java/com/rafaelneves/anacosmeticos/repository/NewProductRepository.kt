package com.rafaelneves.anacosmeticos.repository

import com.rafaelneves.anacosmeticos.data.local.dao.ProductDetailsDao
import com.rafaelneves.anacosmeticos.data.model.ProductDetails

class NewProductRepository(private val database: ProductDetailsDao) {

    fun insertNewProduct(newProduct: ProductDetails) {
        database.insertProduct(newProduct)
    }
}