package com.rafaelneves.anacosmeticos.ui.widget

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rafaelneves.anacosmeticos.R
import com.rafaelneves.anacosmeticos.ui.theme.AnaCosmeticosTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ItemCard(
    icon: Painter,
    name: String,
    description: String,
    quantity: Int,
    onClick: () -> Unit,
    onLongClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
            .combinedClickable(
                onClick = { onClick() },
                onLongClick = { onLongClick() }
            ),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(color = Color(0xFFBCC2CC))
            ) {
                Icon(
                    painter = icon,
                    contentDescription = null,
                    tint = Color(0xFF545F71),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp)
                )
            }

            Column {
                Text(
                    modifier = Modifier
                        .wrapContentWidth(),
                    text = name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF545F71)

                )
                Text(
                    modifier = Modifier
                        .wrapContentWidth(),
                    text = description,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF545F71)

                )
            }

            Spacer(modifier = Modifier.width(16.dp))


            Text(
                text = "Qtd: $quantity",
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF545F71)

            )
        }
    }
}

@Composable
fun ProductCard(
    productName: String,
    productBrand: String,
    productQuantity: Int,
    onClickEdit: () -> Unit,
    onClickDelete: () -> Unit
) {

    var expanded by remember { mutableStateOf(false) }

    val iconCondition = if (productQuantity <= 0) {
        painterResource(id = R.drawable.ic_sad)
    } else {
        painterResource(id = R.drawable.ic_happy)
    }

    Box {
        ItemCard(
            icon = iconCondition,
            name = productName,
            description = productBrand,
            quantity = productQuantity,
            onClick = { },
            onLongClick = { expanded = !expanded }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(x = (-66).dp, y = (-50).dp)
        ) {
            DropdownMenuItem(
                text = { Text("Editar") },
                onClick = { onClickEdit() }
            )
            DropdownMenuItem(
                text = { Text("Excluir") },
                onClick = { onClickDelete() }
            )
        }
    }
}

@Composable
fun BoxCard(
    length: Double,
    height: Double,
    width: Double,
    weight: Double,
    onClickEdit: () -> Unit,
    onClickDelete: () -> Unit
) {

    var expanded by remember { mutableStateOf(false) }

    Box {
        ItemCard(
            icon = painterResource(id = R.drawable.ic_box),
            name = "$length X $height X $width",
            description = "$weight KG",
            quantity = 1,
            onClick = { },
            onLongClick = { expanded = !expanded }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(x = (-66).dp, y = (-50).dp)
        ) {
            DropdownMenuItem(
                text = { Text("Editar") },
                onClick = { onClickEdit() }
            )
            DropdownMenuItem(
                text = { Text("Excluir") },
                onClick = { onClickDelete() }
            )
        }
    }
}

@Composable
fun SentCard(
    shippingName: Int,
    boxQuantity: Int,
    productQuantity: Int,
    onClick: () -> Unit
) {

    val boxQuantityStringCondition = if (boxQuantity > 1) {
        "$boxQuantity caixas"
    } else {
        "$boxQuantity caixa"
    }

    ItemCard(
        icon = painterResource(id = R.drawable.ic_shipping),
        name = "Caixa $shippingName",
        description = boxQuantityStringCondition,
        quantity = productQuantity,
        onClick = { onClick() },
        onLongClick = { }
    )
}

@Composable
fun ProductBoxCard(
    productBoxName: String,
    productBoxDescription: String,
    productBoxQuantity: Int,
    onClickEdit: () -> Unit,
    onClickDelete: () -> Unit
) {

    var expanded by remember { mutableStateOf(false) }

    ItemCard(
        icon = painterResource(id = R.drawable.ic_bag),
        name = productBoxName,
        description = productBoxDescription,
        quantity = productBoxQuantity,
        onClick = { },
        onLongClick = { expanded = !expanded }
    )
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
        offset = DpOffset(x = (-66).dp, y = (-50).dp)
    ) {
        DropdownMenuItem(
            text = { Text("Editar") },
            onClick = {
                expanded = false
                onClickEdit()
            }
        )
        DropdownMenuItem(
            text = { Text("Excluir") },
            onClick = {
                expanded = false
                onClickDelete()
            }
        )
    }
}


@Composable
fun CardHomeScreen(
    icon: Painter,
    text: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
            .clickable { onClick() },
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                tint = Color(0xFF545F71)
            )

            Spacer(modifier = Modifier.width(24.dp))

            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF545F71),
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                tint = Color.Gray
            )
        }
    }
}

@Preview
@Composable
fun ProductCardPreview() {
    AnaCosmeticosTheme {
        ProductCard(
            productName = "Kaiak Tradicional",
            productBrand = "Natura",
            productQuantity = 0,
            onClickEdit = {},
            onClickDelete = {}
        )
    }
}

@Preview
@Composable
fun ShippingCardPreview() {
    AnaCosmeticosTheme {
        SentCard(
            shippingName = 31082023,
            boxQuantity = 3,
            productQuantity = 180,
            onClick = {}
        )
    }
}

@Preview
@Composable
fun ProductBoxCardPreview() {
    AnaCosmeticosTheme {
        ProductBoxCard(
            productBoxName = "Anador",
            productBoxDescription = "Comprimido",
            productBoxQuantity = 15,
            onClickEdit = {},
            onClickDelete = {}
        )
    }
}

@Preview
@Composable
fun PreviewIconTextArrowCard() {
    CardHomeScreen(
        icon = painterResource(id = R.drawable.ic_shipping),
        text = stringResource(id = R.string.shipping),
        onClick = {}
    )
}

@Preview
@Composable
fun BoxCardPreview() {
    AnaCosmeticosTheme {
        BoxCard(
            length = 30.0,
            height = 30.0,
            width = 30.0,
            weight = 12.5,
            onClickEdit = {},
            onClickDelete = {}
        )
    }
}