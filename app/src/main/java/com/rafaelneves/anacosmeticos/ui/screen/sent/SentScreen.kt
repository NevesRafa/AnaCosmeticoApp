package com.rafaelneves.anacosmeticos.ui.screen.sent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rafaelneves.anacosmeticos.data.model.ShippingDetails
import com.rafaelneves.anacosmeticos.ui.widget.SentCard
import com.rafaelneves.anacosmeticos.ui.widget.TopAppBar

val MOCKSHIPPING = listOf(
    ShippingDetails(
        id = 19092023,
        boxList = null,
        boxAmount = 2,
        productAmount = 180
    ),
    ShippingDetails(
        id = 19082023,
        boxList = null,
        boxAmount = 2,
        productAmount = 180
    ),
    ShippingDetails(
        id = 19072023,
        boxList = null,
        boxAmount = 2,
        productAmount = 180
    ),
)

@Composable
fun SentScreen(
    onBackPressed: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = "ENVIADOS",
                onBackPressed = { onBackPressed() }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            SearchTextField(onValueChange = { })
            LazyColumn(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(MOCKSHIPPING) { item ->
                    SentCard(
                        shippingName = item.id,
                        boxQuantity = item.boxAmount,
                        productQuantity = item.productAmount,
                        onClick = { }
                    )

                }

            }
        }
    }
}

@Composable
fun SearchTextField(
    modifier: Modifier = Modifier,
    hint: String = "Pesquisar...",
    onValueChange: (String) -> Unit
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        OutlinedTextField(
            modifier = modifier.fillMaxWidth(),
            value = "",
            onValueChange = { onValueChange(it) },
            label = { Text(text = hint) },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            }
        )
    }

}