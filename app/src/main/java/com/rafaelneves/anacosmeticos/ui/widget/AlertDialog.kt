package com.rafaelneves.anacosmeticos.ui.widget

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun AlertDialog(
    openDialog: Boolean,
    onDeleteClick: (Any) -> Unit,
    objectDetails: Any?,
    onDismiss: () -> Unit
) {

    if (openDialog) {
        AlertDialog(
            onDismissRequest = {
                onDismiss()
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
                        if (objectDetails != null) {
                            onDeleteClick(objectDetails)
                        }
                        onDismiss()
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
                        onDismiss()
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