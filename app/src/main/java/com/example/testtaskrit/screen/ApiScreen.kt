package com.example.testtaskrit.screen.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testtaskrit.R
import com.example.testtaskrit.screen.compose.theme.colorPrimary

@Composable
fun ApiScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorPrimary),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ApiTextField()
        DogScreen()
    }
}

@Composable
fun ApiTextField(){
    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            horizontalArrangement = Arrangement.Center
        ){
            var text by rememberSaveable { mutableStateOf("Api name") }

            TextField(
                value = text,
                onValueChange = {
                    text = it
                },
                shape = MaterialTheme.shapes.small.copy(
                    topEnd = CornerSize(15.dp),
                    topStart = CornerSize(15.dp),
                    bottomEnd = CornerSize(15.dp),
                    bottomStart = CornerSize(15.dp)),
                textStyle = TextStyle(fontSize =  25.sp),
                colors = TextFieldDefaults.textFieldColors(textColor = Color.Black, backgroundColor = Color.White)
            )
        }
    }
}

@Composable
fun DogScreen(){
    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black)
            ){
                Text(
                    text = "Load",
                    fontSize = 25.sp
                )
            }
        }
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

@Preview(showBackground = true)
@Composable
fun ApiScreenPreview() {
    ApiScreen()
}