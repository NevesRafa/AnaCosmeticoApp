package com.rafaelneves.anacosmeticos.ui.widget

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.rafaelneves.anacosmeticos.ui.theme.AnaCosmeticosTheme


@Composable
fun AlertDialog() {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(
                    text = "Excluir Item",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF545F71)
                )
            },
            text = {
                Text(
                    text = "Você tem certeza que deseja excluir o item selecionado?",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF545F71)
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text(
                        text = "Excluir",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFFF7041D)
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text(
                        text = "Cancelar",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF545F71)
                    )
                }
            }
        )
    }
}

@Preview
@Composable
fun AlertDialogPreview() {
    AnaCosmeticosTheme {
        AlertDialog()
    }
}