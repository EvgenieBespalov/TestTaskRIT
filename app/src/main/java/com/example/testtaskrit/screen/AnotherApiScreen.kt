package com.example.testtaskrit.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testtaskrit.screen.compose.theme.colorAccent

@Composable
fun AnotherApiScreen(){
    var textFieldName by remember { mutableStateOf("Another API") }

    Column() {
        CenteredRow{
            Text(
                text = textFieldName,
                fontSize=25.sp,
                color = Color.White
            )
        }
        CenteredRow{
            TextField(
                value = textFieldName,
                onValueChange = { textFieldName = it },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.White,
                    backgroundColor = colorAccent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                shape = MaterialTheme.shapes.small.copy(
                    topEnd = CornerSize(15.dp),
                    topStart = CornerSize(15.dp),
                    bottomEnd = CornerSize(15.dp),
                    bottomStart = CornerSize(15.dp)
                ),
                textStyle = TextStyle(fontSize = 25.sp),
            )
        }
    }
}