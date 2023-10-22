package com.rafaelneves.anacosmeticos.repository

import com.rafaelneves.anacosmeticos.data.local.dao.ProductDetailsDao
import com.rafaelneves.anacosmeticos.data.model.ProductDetails

class NewProductRepository(private val database: ProductDetailsDao) {

    fun insertNewProduct(newProduct: ProductDetails) {
        database.insertProduct(newProduct)
    }

    fun loadProductList(): List<ProductDetails> {
        return database.getAllProduct()
    }

    fun deleteProduct(product: ProductDetails) {
        database.deleteProduct(product)
    }

    fun updateProduct(product: ProductDetails) {
        database.updateProduct(product)
    }

    fun loadProductForId(id: Int): ProductDetails? {
        return database.getProductById(id)
    }
}