package com.rafaelneves.anacosmeticos.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rafaelneves.anacosmeticos.R
import com.rafaelneves.anacosmeticos.data.model.ProductBoxDetails
import com.rafaelneves.anacosmeticos.ui.theme.AnaCosmeticosTheme
import com.rafaelneves.anacosmeticos.ui.widget.ButtonWithText
import com.rafaelneves.anacosmeticos.ui.widget.ProductBoxCard
import com.rafaelneves.anacosmeticos.ui.widget.TopAppBar

val MOCKITEMSHIPPING = listOf(
    ProductBoxDetails(id = 20092023, product = "Kaiak", productDescription = "Natura", amount = 1),
    ProductBoxDetails(id = 20092023, product = "Kaiak", productDescription = "Natura", amount = 1),
    ProductBoxDetails(id = 20092023, product = "Kaiak", productDescription = "Natura", amount = 1),
    ProductBoxDetails(id = 20092023, product = "Kaiak", productDescription = "Natura", amount = 1),
    ProductBoxDetails(id = 20092023, product = "Kaiak", productDescription = "Natura", amount = 1),
    ProductBoxDetails(id = 20092023, product = "Kaiak", productDescription = "Natura", amount = 1),
    ProductBoxDetails(id = 20092023, product = "Kaiak", productDescription = "Natura", amount = 1),
    ProductBoxDetails(id = 20092023, product = "Kaiak", productDescription = "Natura", amount = 1),
    ProductBoxDetails(id = 20092023, product = "Kaiak", productDescription = "Natura", amount = 1),
    ProductBoxDetails(id = 20092023, product = "Kaiak", productDescription = "Natura", amount = 1),
    ProductBoxDetails(id = 20092023, product = "Kaiak", productDescription = "Natura", amount = 1)
)

@Composable
fun NewShippingScreen(
    topAppBarTitle: String,
    productInput: String,
    quantityInput: String
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

            Body(
                productInput = productInput,
                quantityInput = quantityInput
            )
            LazyColumn(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(MOCKITEMSHIPPING) { item ->
                    ProductBoxCard(
                        productBoxName = item.product,
                        productBoxDescription = item.productDescription,
                        productBoxQuantity = item.amount,
                        onClick = {}
                    )
                }

            }
        }
    }
}

@Composable
fun Body(
    productInput: String,
    quantityInput: String
) {

    Column(
        Modifier.padding(16.dp)
    ) {
        OutlinedTextField(
            value = productInput,
            onValueChange = { },
            label = { Text(text = stringResource(R.string.product_label)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        Row {

            OutlinedTextField(
                value = quantityInput,
                onValueChange = { },
                label = { Text(text = stringResource(R.string.quantity_label)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .weight(1f)
            )
            ButtonWithText(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
                    .align(Alignment.CenterVertically),
                title = stringResource(R.string.add_item),
                onClick = {}
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))


        ButtonWithText(
            modifier = Modifier
                .fillMaxWidth(),
            title = stringResource(R.string.config_box),
            onClick = {}
        )

    }
}

@Preview
@Composable
fun BodyPreview() {
    AnaCosmeticosTheme {
        Body(
            productInput = "Kaiak",
            quantityInput = "2"
        )
    }
}

@Preview
@Composable
fun NewShippingScreenPreview() {
    AnaCosmeticosTheme {
        NewShippingScreen(
            topAppBarTitle = stringResource(id = R.string.new_shipping),
            productInput = "",
            quantityInput = ""
        )
    }
}