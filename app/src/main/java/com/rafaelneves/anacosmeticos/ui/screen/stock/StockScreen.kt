package com.rafaelneves.anacosmeticos.ui.screen.stock

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rafaelneves.anacosmeticos.data.model.ProductDetails
import com.rafaelneves.anacosmeticos.ui.screen.sent.SearchTextField
import com.rafaelneves.anacosmeticos.ui.widget.AlertDialog
import com.rafaelneves.anacosmeticos.ui.widget.ProductCard
import com.rafaelneves.anacosmeticos.ui.widget.TopAppBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun StockScreen(
    onNavigateToAddNewProduct: () -> Unit,
    onNavigateToEditProduct: (Int) -> Unit,
    onBackPressed: () -> Unit,
    viewModel: StockViewModel = koinViewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.getProductList()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = "ESTOQUE",
                onBackPressed = { onBackPressed() }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onNavigateToAddNewProduct() }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }
    ) { innerPadding ->
        if (viewModel.productList.value.isEmpty()) {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .background(Color.White)
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ) {
                Text(
                    text = "Lista vazia"
                )
            }
        } else {
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
                    items(viewModel.productList.value) { item ->
                        ProductCard(
                            product = item,
                            onClickEdit = {
                                onNavigateToEditProduct(it.id)
                            }
                        ) {
                            viewModel.productToDelete = it
                            viewModel.showDialog.value = true
                        }

                        AlertDialog(
                            openDialog = viewModel.showDialog.value,
                            onDismiss = { viewModel.showDialog.value = false },
                            onDeleteClick = { viewModel.deleteProduct(it as ProductDetails) },
                            objectDetails = viewModel.productToDelete
                        )
                    }
                }
            }
        }
    }
}