package com.rafaelneves.anacosmeticos.ui.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
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
import com.rafaelneves.anacosmeticos.ui.theme.AnaCosmeticosTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetEditQuantityOfItemInTheBox(
    sheetState: SheetState,
    scope: CoroutineScope,
    quantityInput: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue("")),
    title: Int,
    product: String
) {

    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = {
            scope.launch {
                sheetState.hide()
            }
        },
    ) {
        BottomSheetHeader(title)

        Divider(color = Color.Gray.copy(alpha = 0.1F))

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetBox(
    sheetState: SheetState,
    scope: CoroutineScope,
    title: Int,
    lengthInput: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue("")),
    widthInput: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue("")),
    heightInput: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue("")),
    weightInput: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue(""))
) {
    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = {
            scope.launch {
                sheetState.hide()
            }
        },
    ) {
        BottomSheetHeader(title)

        Divider(color = Color.Gray.copy(alpha = 0.1F))

        Row {
            OutlinedTextField(
                value = lengthInput.value,
                onValueChange = { lengthInput.value = it },
                label = { Text(text = stringResource(R.string.length_label)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp, end = 16.dp)
            )
            OutlinedTextField(
                value = widthInput.value,
                onValueChange = { widthInput.value = it },
                label = { Text(text = stringResource(R.string.width_label)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp, end = 16.dp)
            )
            OutlinedTextField(
                value = heightInput.value,
                onValueChange = { heightInput.value = it },
                label = { Text(text = stringResource(R.string.height_label)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp, end = 16.dp)
            )
        }

        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        OutlinedTextField(
            value = weightInput.value,
            onValueChange = { weightInput.value = it },
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
            onClick = {}
        )
    }
}

@Composable
private fun BottomSheetHeader(
    title: Int
) {
    Text(
        text = stringResource(id = title),
        fontSize = 16.sp,
        fontWeight = FontWeight(600),
        color = Color(0xFF545F71),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BottomSheetEditAmountItemInBoxPreview() {

    AnaCosmeticosTheme {
        BottomSheetEditQuantityOfItemInTheBox(
            sheetState = rememberModalBottomSheetState(),
            scope = rememberCoroutineScope(),
            title = R.string.edit_quantity_title,
            product = "Kaiak"

        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BottomSheetBoxPreview() {

    AnaCosmeticosTheme {
        BottomSheetBox(
            sheetState = rememberModalBottomSheetState(),
            scope = rememberCoroutineScope(),
            title = R.string.new_box_title
        )
    }
}