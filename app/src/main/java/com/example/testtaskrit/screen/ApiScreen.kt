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

        // Button(onClick = { navController.navigate(Routes.Dog.route) }) { Text(text = "Dog", fontSize = 25.sp) }
        // Button(onClick = { navController.navigate(Routes.Nationalize.route) }) { Text(text = "Nat", fontSize = 25.sp) }

        NavHost(navController = navController, startDestination = Routes.DogScreenRoute.route) {
            composable(Routes.NationalizeScreenRoute.route) {
                NationalizeScreen()
            }
            composable(Routes.DogScreenRoute.route) {
                DogScreen(navController)
            }
            /*composable(Routes.DogImageScreenRoute.route + "/{dogImage}") { navBackStack ->
                val dogImage = navBackStack.arguments?.getString("dogImage")
                requireNotNull(dogImage) { "dog parameter wasn't found. Please make sure it's set!" }
                DogImageScreen(dogImage)
            }*/
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ApiScreenPreview() {
    ApiScreen()
}