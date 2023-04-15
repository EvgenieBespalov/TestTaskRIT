package com.example.testtaskrit.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
                    bottomStart = CornerSize(15.dp)
                ),
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
                    bottomStart = CornerSize(15.dp)
                ),
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
