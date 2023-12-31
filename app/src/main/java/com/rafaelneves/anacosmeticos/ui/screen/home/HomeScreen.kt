package com.rafaelneves.anacosmeticos.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.rafaelneves.anacosmeticos.R
import com.rafaelneves.anacosmeticos.ui.widget.CardHomeScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = koinViewModel(),
    onNavigateToNewShippingScreenScreen: () -> Unit,
    onNavigateToSentScreenScreen: () -> Unit,
    onNavigateToStockScreenScreen: () -> Unit,
    onNavigateToNewProductScreenScreen: () -> Unit,
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                item {
                    Spacer(modifier = Modifier.padding(16.dp))
                }

                items(viewModel.homeScreenOptionsList) { item ->
                    CardHomeScreen(
                        icon = painterResource(id = item.icon),
                        text = stringResource(id = item.title),
                        onClick = {
                            when (item.title) {
                                R.string.new_shipping -> {
                                    onNavigateToNewShippingScreenScreen()
                                }

                                R.string.shipping -> {
                                    onNavigateToSentScreenScreen()
                                }

                                R.string.stock -> {
                                    onNavigateToStockScreenScreen()
                                }

                                R.string.new_product -> {
                                    onNavigateToNewProductScreenScreen()
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}