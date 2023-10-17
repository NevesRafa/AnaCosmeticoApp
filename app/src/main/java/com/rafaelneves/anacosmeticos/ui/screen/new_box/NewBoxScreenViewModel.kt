package com.rafaelneves.anacosmeticos.ui.screen.new_box

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelneves.anacosmeticos.data.model.BoxDetails
import com.rafaelneves.anacosmeticos.repository.NewBoxRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewBoxScreenViewModel(
    private val repository: NewBoxRepository
) : ViewModel() {

    val openBottomSheet = mutableStateOf(false)

    val openBottomSheetEdit = mutableStateOf(false)

    val showDialog = mutableStateOf(false)

    var boxToEdit: BoxDetails? = null

    var boxToDelete: BoxDetails? = null

    var listBox = listOf<BoxDetails>()

    fun createNewBox(newBox: BoxDetails) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertNewBox(newBox)
            getListBox()
        }
    }

    fun getListBox() {
        viewModelScope.launch(Dispatchers.IO) {
            listBox = repository.loadListBox()
        }
    }

    fun deleteBox(box: BoxDetails) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteBox(box)
            getListBox()
        }
    }

    fun editBox(box: BoxDetails) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateBox(box)
            getListBox()
        }
    }
}