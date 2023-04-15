package com.example.testtaskrit.screen.navigation

sealed class Routes(val route: String) {
    object Dog : Routes("dog")
    object Nationalize : Routes("nationalize")
}