package com.rafaelneves.anacosmeticos.ui.screen.stock

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelneves.anacosmeticos.data.model.ProductDetails
import com.rafaelneves.anacosmeticos.repository.NewProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StockViewModel(
    private val repository: NewProductRepository
) : ViewModel() {

    val showDialog = mutableStateOf(false)

    var productList = mutableStateOf(listOf<ProductDetails>())

    var productToDelete: ProductDetails? = null

    fun getProductList() {
        viewModelScope.launch(Dispatchers.IO) {
            productList.value = repository.loadProductList()
        }
    }

    fun deleteProduct(product: ProductDetails) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteProduct(product)
            getProductList()
        }
    }
}