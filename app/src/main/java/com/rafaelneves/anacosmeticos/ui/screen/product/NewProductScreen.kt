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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    viewModel: NewProductViewModel = koinViewModel()
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = "NOVO PRODUTO",
                onBackPressed = { onBackPressed() }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            BodyNewProduct(
                onSaveClick = {
                    viewModel.createNewProduct(it)
                }
            )
        }
    }
}

@Composable
fun BodyNewProduct(onSaveClick: (ProductDetails) -> Unit) {

    val productName = remember { mutableStateOf("") }
    val productDescription = remember { mutableStateOf("") }
    val productAmount = remember { mutableStateOf("") }
    val productForm = remember { mutableStateOf("") }

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
                        id = 0,
                        productName = productName.value,
                        productDescription = productDescription.value,
                        productAmount = productAmount.value.toInt(),
                        productForm = productForm.value
                    )
                )
                productName.value = ""
                productDescription.value = ""
                productAmount.value = ""
                productForm.value = ""
            }
        )
    }
}