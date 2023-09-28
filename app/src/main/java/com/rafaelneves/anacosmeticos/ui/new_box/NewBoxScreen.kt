package com.rafaelneves.anacosmeticos.ui.new_box

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rafaelneves.anacosmeticos.ui.widget.AlertDialog
import com.rafaelneves.anacosmeticos.ui.widget.BoxCard
import com.rafaelneves.anacosmeticos.ui.widget.CreateBoxBottomSheet
import com.rafaelneves.anacosmeticos.ui.widget.EditBoxBottomSheet
import com.rafaelneves.anacosmeticos.ui.widget.TopAppBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun NewBoxScreen(
    onBackPressed: () -> Unit,
    viewModel: NewBoxScreenViewModel = koinViewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.getListBox()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = "CAIXA",
                onBackPressed = { onBackPressed() }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.openBottomSheet.value = true }

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

            if (viewModel.listBox.isEmpty()) {
                item {
                    Text(
                        text = "Lista vazia"
                    )
                }
            }

            items(viewModel.listBox) { item ->
                BoxCard(
                    boxDetails = item,
                    onClickEdit = {
                        viewModel.boxToEdit = it
                        viewModel.openBottomSheetEdit.value = true
                    }
                ) {
                    viewModel.boxToDelete = it
                    viewModel.showDialog.value = true
                }
            }
        }
        CreateBoxBottomSheet(
            openBottomSheet = viewModel.openBottomSheet.value,
            onDismiss = { viewModel.openBottomSheet.value = false },
            onSaveClick = {
                viewModel.createNewBox(it)
                viewModel.openBottomSheet.value = false
            }
        )

        EditBoxBottomSheet(
            openBottomSheet = viewModel.openBottomSheetEdit.value,
            onDismiss = { viewModel.openBottomSheetEdit.value = false },
            boxDetails = viewModel.boxToEdit,
            onEditClick = {
                viewModel.editBox(it)
                viewModel.openBottomSheetEdit.value = false
            }
        )

        AlertDialog(
            openDialog = viewModel.showDialog.value,
            onDismiss = { viewModel.showDialog.value = false },
            onDeleteBox = { viewModel.deleteBox(it) },
            boxDetails = viewModel.boxToDelete
        )

    }
}