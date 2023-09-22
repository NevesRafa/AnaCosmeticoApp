package com.rafaelneves.anacosmeticos.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rafaelneves.anacosmeticos.ui.theme.AnaCosmeticosTheme
import com.rafaelneves.anacosmeticos.ui.widget.AlertDialog
import com.rafaelneves.anacosmeticos.ui.widget.ProductCard
import com.rafaelneves.anacosmeticos.ui.widget.TopAppBar

@Composable
fun StockScreen(
    topAppBarTitle: String
) {

    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = topAppBarTitle,
                onBackPressed = {}
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
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
                items(MOCKPRODUCT) { item ->
                    ProductCard(
                        productName = item.product,
                        productBrand = item.productDescription,
                        productQuantity = item.amount,
                        onClickEdit = { },
                        onClickDelete = { showDialog = true }
                    )

                    AlertDialog(
                        openDialog = showDialog,
                        onDismiss = { showDialog = false }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun StockScreenPreview() {
    AnaCosmeticosTheme {
        StockScreen(
            topAppBarTitle = "ESTOQUE"
        )
    }
}