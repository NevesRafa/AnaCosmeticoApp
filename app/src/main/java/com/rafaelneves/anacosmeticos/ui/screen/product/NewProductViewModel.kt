package com.rafaelneves.anacosmeticos.ui.screen.product

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.geometry.Size
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelneves.anacosmeticos.data.model.ProductDetails
import com.rafaelneves.anacosmeticos.repository.NewProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewProductViewModel(
    private val repository: NewProductRepository
) : ViewModel() {

    val productIdTyped = mutableStateOf(0)

    val productNameTyped = mutableStateOf("")

    val productDescriptionTyped = mutableStateOf("")

    val productAmountTyped = mutableStateOf("")

    val productFormTyped = mutableStateOf("")

    private var productToEdit: ProductDetails? = null

    val dropdownProductManufacturerExpended = mutableStateOf(false)

    val productManufacturerList = listOf("Natura", "Boticario", "Avon", "Outros")

    val dropdownProductManufacturerTextFieldSize = mutableStateOf(Size.Zero)


    fun createNewProduct(newProduct: ProductDetails) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertNewProduct(newProduct)
        }
    }

    fun loadProductToEdit(productId: Int) {

        viewModelScope.launch(Dispatchers.IO) {
            productToEdit = repository.loadProductForId(productId)
        }
        productIdTyped.value = productToEdit?.id ?: 0
        productNameTyped.value = productToEdit?.productName ?: ""
        productDescriptionTyped.value = productToEdit?.productDescription ?: ""
        productAmountTyped.value = (productToEdit?.productAmount ?: 0).toString()
        productFormTyped.value = productToEdit?.productForm ?: ""
    }

    fun editProduct(product: ProductDetails) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateProduct(product)
        }
    }

}