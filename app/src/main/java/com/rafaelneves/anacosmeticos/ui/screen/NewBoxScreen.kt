package com.rafaelneves.anacosmeticos.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rafaelneves.anacosmeticos.data.model.BoxDetails
import com.rafaelneves.anacosmeticos.ui.theme.AnaCosmeticosTheme
import com.rafaelneves.anacosmeticos.ui.widget.BoxCard
import com.rafaelneves.anacosmeticos.ui.widget.TopAppBar

val MOCKBOX = listOf(
    BoxDetails(
        id = 0,
        length = 50.0,
        height = 30.0,
        width = 60.0,
        weight = 13.5
    ),
    BoxDetails(
        id = 0,
        length = 50.0,
        height = 30.0,
        width = 60.0,
        weight = 13.5
    )
)

@Composable
fun NewBoxScreen(
    topAppBarTitle: String
) {
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

        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .background(Color.White)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            item { Spacer(modifier = Modifier.padding(16.dp)) }

            items(MOCKBOX) { item ->
                BoxCard(
                    length = item.length,
                    height = item.height,
                    width = item.width,
                    weight = item.weight
                )
            }

        }
    }
}

@Preview
@Composable
fun NewBoxScreenPreview() {
    AnaCosmeticosTheme {
        NewBoxScreen("CAIXAS")
    }
}