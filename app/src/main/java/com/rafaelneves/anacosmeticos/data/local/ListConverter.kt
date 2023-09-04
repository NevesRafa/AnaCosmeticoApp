package com.rafaelneves.anacosmeticos.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rafaelneves.anacosmeticos.data.model.BoxDetails
import com.rafaelneves.anacosmeticos.data.model.ProductBoxDetails

class ListConverter {

    private val gson = Gson()

    //Box Product List
    @TypeConverter
    fun jsonToListProductBox(input: String): List<ProductBoxDetails> {
        return gson.fromJson(input, object : TypeToken<List<ProductBoxDetails>>() {}.type)
    }

    @TypeConverter
    fun listProductBoxToJson(input: List<ProductBoxDetails>): String {
        return gson.toJson(input)
    }

    // Box List
    @TypeConverter
    fun jsonToListBox(input: String): List<BoxDetails> {
        return gson.fromJson(input, object : TypeToken<List<BoxDetails>>() {}.type)
    }

    @TypeConverter
    fun listBoxToJson(input: List<BoxDetails>): String {
        return gson.toJson(input)
    }

}