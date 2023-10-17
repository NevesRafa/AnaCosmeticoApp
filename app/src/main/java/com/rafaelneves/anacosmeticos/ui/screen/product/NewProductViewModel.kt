package com.rafaelneves.anacosmeticos.ui.screen.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelneves.anacosmeticos.data.model.ProductDetails
import com.rafaelneves.anacosmeticos.repository.NewProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewProductViewModel(
    private val repository: NewProductRepository
) : ViewModel() {

    fun createNewProduct(newProduct: ProductDetails) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertNewProduct(newProduct)
        }
    }

}