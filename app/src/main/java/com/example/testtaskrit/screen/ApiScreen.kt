package com.example.testtaskrit.screen.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testtaskrit.R
import com.example.testtaskrit.screen.compose.theme.colorPrimary
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.testtaskrit.screen.compose.theme.colorPrimaryDark

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
        NationalizeScreen()
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
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black),
                shape = MaterialTheme.shapes.small.copy(
                    topEnd = CornerSize(15.dp),
                    topStart = CornerSize(15.dp),
                    bottomEnd = CornerSize(15.dp),
                    bottomStart = CornerSize(15.dp)),
            ){
                Text(
                    text = "Load dog",
                    fontSize = 25.sp
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            horizontalArrangement = Arrangement.Center
        ){
            val asyncPainter =
                rememberAsyncImagePainter("https://images.dog.ceo/breeds/corgi-cardigan/n02113186_8812.jpg")

            Image(
                painter = asyncPainter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(300.dp)
                    .clip(RoundedCornerShape(10))
                    .border(5.dp, colorPrimaryDark, RoundedCornerShape(10))
            )
        }
    }
}

@Composable
fun NationalizeScreen(){
    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            horizontalArrangement = Arrangement.Center
        ){
            var text by rememberSaveable { mutableStateOf("Evgenie") }

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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            horizontalArrangement = Arrangement.Center
        ){
            val openDialog = remember { mutableStateOf(false) }

            Button(
                onClick = {openDialog.value = true},
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black),
                shape = MaterialTheme.shapes.small.copy(
                    topEnd = CornerSize(15.dp),
                    topStart = CornerSize(15.dp),
                    bottomEnd = CornerSize(15.dp),
                    bottomStart = CornerSize(15.dp)),
            ){
                Text(
                    text = "Load nationalize",
                    fontSize = 25.sp
                )
            }

            if (openDialog.value) {
                AlertDialog(
                    onDismissRequest = {
                        openDialog.value = false
                    },
                    title = { Text(text = "Подтверждение действия") },
                    text = { Text("Вы действительно хотите удалить выбранный элемент?") },
                    buttons = {
                        Row(
                            modifier = Modifier.padding(all = 8.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ){
                            Button(onClick = { openDialog.value = false }) {
                                    Text("OK", fontSize = 22.sp)
                            }
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ApiScreenPreview() {
    ApiScreen()
}