package com.rafaelneves.anacosmeticos.ui.screen

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rafaelneves.anacosmeticos.R
import com.rafaelneves.anacosmeticos.ui.theme.AnaCosmeticosTheme
import com.rafaelneves.anacosmeticos.ui.widget.ButtonWithText
import com.rafaelneves.anacosmeticos.ui.widget.TopAppBar

@Composable
fun NewProductScreen(
    topAppBarTitle: String,
    productName: String,
    productDescription: String,
    productAmount: String,
    productForm: String
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = topAppBarTitle,
                onBackPressed = {}
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            BodyNewProduct(
                productName = productName,
                productDescription = productDescription,
                productAmount = productAmount,
                productForm = productForm
            )
        }
    }
}

@Composable
fun BodyNewProduct(
    productName: String,
    productDescription: String,
    productAmount: String,
    productForm: String
) {
    Column(
        Modifier.padding(16.dp)
    ) {
        OutlinedTextField(
            value = productName,
            onValueChange = { },
            label = { Text(text = stringResource(R.string.product_name_label)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        OutlinedTextField(
            value = productDescription,
            onValueChange = { },
            label = { Text(text = stringResource(R.string.product_description_label)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        Row {

            OutlinedTextField(
                value = productAmount,
                onValueChange = { },
                label = { Text(text = stringResource(R.string.quantity_label)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .weight(1f)
            )

            Spacer(modifier = Modifier.padding(8.dp))

            OutlinedTextField(
                value = productForm,
                onValueChange = { },
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
            onClick = {}
        )

    }
}

@Preview
@Composable
fun NewProductPreview() {
    AnaCosmeticosTheme {
        NewProductScreen(
            topAppBarTitle = "NOVO PRODUTO",
            productName = "",
            productDescription = "",
            productAmount = "",
            productForm = ""
        )
    }
}