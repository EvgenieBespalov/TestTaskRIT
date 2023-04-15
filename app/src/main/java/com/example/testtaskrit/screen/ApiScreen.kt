package com.example.testtaskrit.screen.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testtaskrit.screen.compose.theme.colorPrimary
import com.example.testtaskrit.screen.DogScreen
import com.example.testtaskrit.screen.NationalizeScreen
import com.example.testtaskrit.screen.navigation.Routes

@Composable
fun ApiScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorPrimary),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val navController = rememberNavController()

        ApiTextField()

        Button(onClick = { navController.navigate(Routes.Dog.route) }) { Text(text = "Dog", fontSize = 25.sp) }
        Button(onClick = { navController.navigate(Routes.Nationalize.route) }) { Text(text = "Nat", fontSize = 25.sp) }

        NavHost(navController = navController, startDestination = Routes.Dog.route) {
            composable(Routes.Nationalize.route) {
                NationalizeScreen()
            }
            composable(Routes.Dog.route) {
                DogScreen()
            }
        }
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

@Preview(showBackground = true)
@Composable
fun ApiScreenPreview() {
    ApiScreen()
}