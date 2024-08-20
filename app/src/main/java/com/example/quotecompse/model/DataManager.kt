package com.example.quotecompse.model

import android.content.Context
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.example.quotecompse.MainActivity
import com.google.gson.Gson


object DataManager {

    var data = emptyArray<Quote>()
    var currentQuote : Quote?= null

    var currentPage = mutableStateOf(MainActivity.Pages.LISTING)
    var isDataLoaded = mutableStateOf(false)

    fun loadAssetsFromFile(context:Context){

        val inputStream = context.assets.open("Quote.json")
        val size : Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json,Array<Quote>::class.java)
        isDataLoaded.value = true

    }

    fun switchPages(quote: Quote?){
        if (currentPage.value == MainActivity.Pages.LISTING){
            currentQuote = quote
            currentPage.value = MainActivity.Pages.DETAIL
        }
        else{
            currentPage.value = MainActivity.Pages.LISTING
        }
    }
}