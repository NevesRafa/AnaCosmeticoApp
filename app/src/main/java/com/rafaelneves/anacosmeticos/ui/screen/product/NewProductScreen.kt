package com.rafaelneves.anacosmeticos.ui.screen.product

import android.widget.Toast
import android.widget.Toast.makeText
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
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

    val context = LocalContext.current

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
                        makeText(context, "Produto editado com sucesso!", Toast.LENGTH_LONG).show()
                    } else {
                        viewModel.createNewProduct(it)
                        makeText(context, "Produto salvo com sucesso", Toast.LENGTH_LONG).show()
                    }
                },
                productName = viewModel.productNameTyped,
                productDescription = viewModel.productDescriptionTyped,
                productAmount = viewModel.productAmountTyped,
                productForm = viewModel.productFormTyped,
                idToEdit = viewModel.productIdTyped,
                expended = viewModel.dropdownProductManufacturerExpended,
                productManufacturerList = viewModel.productManufacturerList,
                dropdownTextFieldSize = viewModel.dropdownProductManufacturerTextFieldSize
            )
        }
    }
}

@Composable
fun BodyNewProduct(
    onSaveClick: (ProductDetails) -> Unit,
    expended: MutableState<Boolean>,
    productManufacturerList: List<String>,
    dropdownTextFieldSize: MutableState<Size>,
    productName: MutableState<String>,
    productDescription: MutableState<String>,
    productAmount: MutableState<String>,
    productForm: MutableState<String>,
    idToEdit: MutableState<Int>
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        Modifier.padding(16.dp)
    ) {
        OutlinedTextField(
            value = productName.value,
            onValueChange = { productName.value = it },
            label = { Text(text = stringResource(R.string.product_name_label)) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        Dropdown(
            expended = expended,
            itemList = productManufacturerList,
            selectText = productDescription,
            textFieldSize = dropdownTextFieldSize
        )

        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        Row {

            OutlinedTextField(
                value = productAmount.value,
                onValueChange = { productAmount.value = it },
                label = { Text(text = stringResource(R.string.quantity_label)) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .weight(1f)
            )

            Spacer(modifier = Modifier.padding(8.dp))

            OutlinedTextField(
                value = productForm.value,
                onValueChange = { productForm.value = it },

                label = { Text(text = stringResource(R.string.product_form_label)) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    capitalization = KeyboardCapitalization.Words,
                    imeAction = ImeAction.Done
                ),
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

                keyboardController?.hide()
            }
        )
    }
}

@Composable
fun Dropdown(
    expended: MutableState<Boolean>,
    itemList: List<String>,
    selectText: MutableState<String>,
    textFieldSize: MutableState<Size>
) {

    val icon = if (expended.value)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column() {

        OutlinedTextField(
            value = selectText.value,
            onValueChange = { selectText.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize.value = coordinates.size.toSize()
                },
            label = { Text("Marca") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            trailingIcon = {
                Icon(icon, "contentDescription",
                    Modifier.clickable { expended.value = !expended.value })
            }
        )
        DropdownMenu(
            expanded = expended.value,
            onDismissRequest = { expended.value = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.value.width.toDp() })
        ) {
            itemList.forEach { label ->
                DropdownMenuItem(
                    text = {
                        Text(text = label)
                    },
                    onClick = {
                        selectText.value = label
                        expended.value = false
                    })
            }
        }
    }
}