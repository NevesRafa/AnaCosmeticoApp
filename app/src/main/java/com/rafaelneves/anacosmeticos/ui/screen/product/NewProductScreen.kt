package com.rafaelneves.anacosmeticos.ui.screen.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.rafaelneves.anacosmeticos.R
import com.rafaelneves.anacosmeticos.data.model.ProductDetails
import com.rafaelneves.anacosmeticos.ui.widget.ButtonWithText
import com.rafaelneves.anacosmeticos.ui.widget.TopAppBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun NewProductScreen(
    onBackPressed: () -> Unit,
    viewModel: NewProductViewModel = koinViewModel(),
    productIdToEdit: Int? = null
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = if (productIdToEdit != null) {
                    stringResource(R.string.product_edit_title)
                } else {
                    stringResource(R.string.new_product_title)
                },
                onBackPressed = { onBackPressed() }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            if (productIdToEdit != null) {
                viewModel.loadProductToEdit(productIdToEdit)
            }

            BodyNewProduct(
                onSaveClick = {
                    if (productIdToEdit != null) {
                        viewModel.editProduct(it)
                    } else {
                        viewModel.createNewProduct(it)
                    }
                },
                productName = viewModel.productNameTyped,
                productDescription = viewModel.productDescriptionTyped,
                productAmount = viewModel.productAmountTyped,
                productForm = viewModel.productFormTyped,
                idToEdit = viewModel.productIdTyped
            )
        }
    }
}

@Composable
fun BodyNewProduct(
    onSaveClick: (ProductDetails) -> Unit,
    productName: MutableState<String>,
    productDescription: MutableState<String>,
    productAmount: MutableState<String>,
    productForm: MutableState<String>,
    idToEdit: MutableState<Int>
) {

    Column(
        Modifier.padding(16.dp)
    ) {
        OutlinedTextField(
            value = productName.value,
            onValueChange = { productName.value = it },
            label = { Text(text = stringResource(R.string.product_name_label)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        OutlinedTextField(
            value = productDescription.value,
            onValueChange = { productDescription.value = it },
            label = { Text(text = stringResource(R.string.product_description_label)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        Row {

            OutlinedTextField(
                value = productAmount.value,
                onValueChange = { productAmount.value = it },
                label = { Text(text = stringResource(R.string.quantity_label)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .weight(1f)
            )

            Spacer(modifier = Modifier.padding(8.dp))

            OutlinedTextField(
                value = productForm.value,
                onValueChange = { productForm.value = it },
                label = { Text(text = stringResource(R.string.product_form_label)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier
                    .weight(1f)
            )
        }

        Spacer(modifier = Modifier.padding(8.dp))

        ButtonWithText(
            modifier = Modifier
                .fillMaxWidth(),
            title = stringResource(R.string.save_btn),
            onClick = {
                onSaveClick(
                    ProductDetails(
                        id = idToEdit.value,
                        productName = productName.value,
                        productDescription = productDescription.value,
                        productAmount = productAmount.value.toInt(),
                        productForm = productForm.value
                    )
                )
                idToEdit.value = 0
                productName.value = ""
                productDescription.value = ""
                productAmount.value = ""
                productForm.value = ""
            }
        )
    }
}