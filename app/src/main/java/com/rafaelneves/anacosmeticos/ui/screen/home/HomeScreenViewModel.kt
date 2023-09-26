package com.rafaelneves.anacosmeticos.ui.screen.home

import androidx.lifecycle.ViewModel
import com.rafaelneves.anacosmeticos.R
import com.rafaelneves.anacosmeticos.data.model.ItemHomeScreenDetails

class HomeScreenViewModel : ViewModel() {

    val homeScreenOptionsList = listOf(
        ItemHomeScreenDetails(title = R.string.new_shipping, icon = R.drawable.ic_create_shipping),
        ItemHomeScreenDetails(title = R.string.shipping, icon = R.drawable.ic_shipping),
        ItemHomeScreenDetails(title = R.string.stock, icon = R.drawable.ic_stock),
        ItemHomeScreenDetails(title = R.string.new_product, icon = R.drawable.ic_add)
    )

}