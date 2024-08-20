package com.example.quotecompse.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quotecompse.model.Quote

@Composable
fun QuoteListScreen(data:Array<Quote>,onClick : (quote: Quote)->Unit) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Quote App",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(8.dp,20.dp)
        )
        QuoteList(data = data,onClick)
    }
}