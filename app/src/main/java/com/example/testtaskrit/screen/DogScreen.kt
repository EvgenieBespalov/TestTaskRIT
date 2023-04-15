package com.example.testtaskrit.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.testtaskrit.screen.compose.theme.colorPrimaryDark

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
                    bottomStart = CornerSize(15.dp)
                ),
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
