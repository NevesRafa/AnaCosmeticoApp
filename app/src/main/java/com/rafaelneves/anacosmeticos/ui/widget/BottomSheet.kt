package com.rafaelneves.anacosmeticos.ui.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rafaelneves.anacosmeticos.R
import com.rafaelneves.anacosmeticos.data.model.BoxDetails
import com.rafaelneves.anacosmeticos.ui.theme.AnaCosmeticosTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    title: String,
    openBottomSheet: Boolean,
    onDismiss: () -> Unit,
    scrimColor: Color = BottomSheetDefaults.ScrimColor,
    content: @Composable ColumnScope.() -> Unit
) {

    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    if (openBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = onDismiss,
            containerColor = MaterialTheme.colorScheme.background,
            sheetState = bottomSheetState,
            scrimColor = scrimColor,
            dragHandle = null
        ) {
            Column {
                Spacer(modifier = Modifier.height(24.dp))
                BottomSheetHeader(title = title)
                Divider(color = Color.Gray.copy(alpha = 0.1F))
            }
            content()
        }
    }
}

@Composable
fun EditQuantityBottomSheet(
    openBottomSheet: Boolean,
    onDismiss: () -> Unit,
    quantityInput: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue("")),
    title: String,
    product: String
) {

    BottomSheet(
        title = title,
        openBottomSheet = openBottomSheet,
        onDismiss = onDismiss
    ) {
        OutlinedTextField(
            value = product,
            onValueChange = { },
            label = { Text(text = stringResource(R.string.product_label)) },
            enabled = false,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        )

        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        OutlinedTextField(
            value = quantityInput.value,
            onValueChange = { quantityInput.value = it },
            label = { Text(text = stringResource(R.string.quantity_label)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        )

        Divider(Color.Gray.copy(alpha = 0.1F))

        ButtonWithText(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            title = stringResource(R.string.save_btn),
            onClick = {}
        )
    }
}

@Composable
fun CreateBoxBottomSheet(
    openBottomSheet: Boolean,
    onDismiss: () -> Unit,
    onSaveClick: (BoxDetails) -> Unit
) {

    val lengthState = remember { mutableStateOf("") }
    val widthState = remember { mutableStateOf("") }
    val heightState = remember { mutableStateOf("") }
    val weightState = remember { mutableStateOf("") }

    BottomSheet(
        title = "NOVA CAIXA",
        openBottomSheet = openBottomSheet,
        onDismiss = onDismiss
    ) {
        Row {
            OutlinedTextField(
                value = lengthState.value,
                onValueChange = { lengthState.value = it },
                label = { Text(text = stringResource(R.string.length_label)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp, end = 16.dp)
            )
            OutlinedTextField(
                value = widthState.value,
                onValueChange = { widthState.value = it },
                label = { Text(text = stringResource(R.string.width_label)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp, end = 16.dp)
            )
            OutlinedTextField(
                value = heightState.value,
                onValueChange = { heightState.value = it },
                label = { Text(text = stringResource(R.string.height_label)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp, end = 16.dp)
            )
        }

        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        OutlinedTextField(
            value = weightState.value,
            onValueChange = { weightState.value = it },
            label = { Text(text = stringResource(R.string.weight_label)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        )

        Divider(Color.Gray.copy(alpha = 0.1F))

        ButtonWithText(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            title = stringResource(R.string.add_box_btn),
            onClick = {
                onSaveClick(
                    BoxDetails(
                        id = 0,
                        length = lengthState.value,
                        height = heightState.value,
                        width = widthState.value,
                        weight = weightState.value.toDouble()
                    )
                )
                lengthState.value = ""
                heightState.value = ""
                widthState.value = ""
                weightState.value = ""
            }
        )
    }
}

@Composable
fun EditBoxBottomSheet(
    openBottomSheet: Boolean,
    onDismiss: () -> Unit,
    boxDetails: BoxDetails?,
    onEditClick: (BoxDetails) -> Unit
) {

    val lengthState = remember { mutableStateOf("") }
    val widthState = remember { mutableStateOf(boxDetails?.width ?: "") }
    val heightState = remember { mutableStateOf(boxDetails?.height ?: "") }
    val weightState = remember { mutableStateOf(boxDetails?.weight.toString() ?: "") }

    when {
        boxDetails != null -> {
            lengthState.value = boxDetails.length
            widthState.value = boxDetails.width
            heightState.value = boxDetails.height
            weightState.value = boxDetails.weight.toString()
        }
    }

    BottomSheet(
        title = "EDITAR CAIXA",
        openBottomSheet = openBottomSheet,
        onDismiss = onDismiss
    ) {
        Row {
            OutlinedTextField(
                value = lengthState.value,
                onValueChange = { lengthState.value = it },
                label = { Text(text = stringResource(R.string.length_label)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp, end = 16.dp)
            )
            OutlinedTextField(
                value = widthState.value,
                onValueChange = { widthState.value = it },
                label = { Text(text = stringResource(R.string.width_label)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp, end = 16.dp)
            )
            OutlinedTextField(
                value = heightState.value,
                onValueChange = { heightState.value = it },
                label = { Text(text = stringResource(R.string.height_label)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp, end = 16.dp)
            )
        }

        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        OutlinedTextField(
            value = weightState.value,
            onValueChange = { weightState.value = it },
            label = { Text(text = stringResource(R.string.weight_label)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        )

        Divider(Color.Gray.copy(alpha = 0.1F))

        ButtonWithText(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            title = stringResource(R.string.edit_box_btn),
            onClick = {
                onEditClick(
                    BoxDetails(
                        id = boxDetails?.id ?: 0,
                        length = lengthState.value,
                        height = heightState.value,
                        width = widthState.value,
                        weight = weightState.value.toDouble()
                    )
                )
            }
        )
    }
}


@Composable
private fun BottomSheetHeader(
    title: String
) {
    Text(
        text = title,
        fontSize = 16.sp,
        fontWeight = FontWeight(600),
        color = Color(0xFF545F71),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Preview
@Composable
fun BottomSheetEditAmountItemInBoxPreview() {

    AnaCosmeticosTheme {
        EditQuantityBottomSheet(
            openBottomSheet = true,
            onDismiss = { },
            title = "EDITAR CAIXA",
            product = ""
        )
    }
}

//@Preview
//@Composable
//fun BottomSheetBoxPreview() {
//    AnaCosmeticosTheme {
//        CreateBoxBottomSheet(
//            openBottomSheet = true,
//            onDismiss = { },
//            title = "CAIXA",
//            boxDetails = BoxDetails(0, "0.0", "0.0", "0.0", 0.0),
//            onSaveClick = {}
//
//        )
//    }
//}