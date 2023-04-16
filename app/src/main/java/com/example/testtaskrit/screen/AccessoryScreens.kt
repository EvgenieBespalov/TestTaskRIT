package com.example.testtaskrit.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScreenError(errorText: String){
    CenteredColumn {
        Text(text = errorText)
    }
}

@Composable
fun ScreenLoadind(){
    CenteredColumn {
        CircularProgressIndicator()
    }
}

@Composable
fun CenteredColumn(content: @Composable ColumnScope.() -> Unit){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        content = content
    )
}

@Composable
fun CenteredRow(content: @Composable RowScope.() -> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp),
        horizontalArrangement = Arrangement.Center,
        content = content
    )
}