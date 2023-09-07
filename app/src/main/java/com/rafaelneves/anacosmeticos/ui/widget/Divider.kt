package com.rafaelneves.anacosmeticos.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun Divider(
    color: Color
) {
    Divider(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .height(1.dp)
            .fillMaxWidth()
            .background(color = color)
    )
}