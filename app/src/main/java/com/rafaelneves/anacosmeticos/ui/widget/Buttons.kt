package com.rafaelneves.anacosmeticos.ui.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rafaelneves.anacosmeticos.ui.theme.AnaCosmeticosTheme


@Composable
fun ButtonWithLoading(
    title: String,
    isLoading: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(16.dp)
                    .size(36.dp),
                color = Color.Blue
            )
        } else {
            ButtonWithText(
                title = title,
                onClick = onClick
            )
        }
    }
}

@Composable
fun ButtonWithText(
    title: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(text = title)
    }
}


@Preview
@Composable
fun ButtonWithLoadingPreview() {
    AnaCosmeticosTheme {
        ButtonWithLoading(
            title = "Entrar",
            isLoading = false,
            onClick = {}
        )
    }
}

@Preview
@Composable
fun ButtonWithTextPreview() {
    AnaCosmeticosTheme {
        ButtonWithText(
            title = "Continuar",
            onClick = {}
        )
    }
}