package com.example.testtaskrit.screen.navigation

sealed class Routes(val route: String) {
    object DogScreenRoute : Routes("dog")
    //object DogImageScreenRoute : Routes("dogimage")
    object NationalizeScreenRoute : Routes("nationalize")
    object AnotherApiScreenRoute : Routes("anotherApi")
}