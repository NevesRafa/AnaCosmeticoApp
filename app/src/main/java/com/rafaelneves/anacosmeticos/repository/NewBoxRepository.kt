package com.rafaelneves.anacosmeticos.repository

import com.rafaelneves.anacosmeticos.data.local.dao.BoxDetailsDao
import com.rafaelneves.anacosmeticos.data.model.BoxDetails

class NewBoxRepository(private val database: BoxDetailsDao) {
    fun loadListBox(): List<BoxDetails> {
        return database.getAllBox()
    }

    fun deleteBox(box: BoxDetails) {
        database.deleteBox(box)
    }

    fun insertNewBox(newBox: BoxDetails) {
        database.insertBox(newBox)
    }

    fun updateBox(box: BoxDetails) {
        database.update(box)
    }
}