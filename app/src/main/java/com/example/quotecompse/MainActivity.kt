package com.example.quotecompse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quotecompse.model.DataManager
import com.example.quotecompse.screens.QuoteDetails
import com.example.quotecompse.screens.QuoteList
import com.example.quotecompse.screens.QuoteListItem
import com.example.quotecompse.screens.QuoteListScreen
import com.example.quotecompse.ui.theme.QuoteCompseTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetsFromFile(applicationContext)
        }

        setContent {
            App()
        }
    }

    @Composable
    fun App(){

        if (DataManager.isDataLoaded.value){

            if (DataManager.currentPage.value==Pages.LISTING) {
                QuoteListScreen(data = DataManager.data) {
                    DataManager.switchPages(it)
                }
            }else{

                DataManager.currentQuote?.let { QuoteDetails(quote = it) }
            }
        }
    }

    enum class Pages{
        LISTING,
        DETAIL
    }
}
