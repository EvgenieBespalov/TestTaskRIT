package com.example.testtaskrit.screen.compose

import android.content.SharedPreferences
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testtaskrit.PreferenceHelper
import com.example.testtaskrit.PreferenceHelper.settings
import com.example.testtaskrit.screen.compose.theme.colorPrimary
import com.example.testtaskrit.screen.DogScreen
import com.example.testtaskrit.screen.NationalizeScreen
import com.example.testtaskrit.screen.navigation.Routes


 lateinit var prefs: SharedPreferences

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
        val prefs = PreferenceHelper.customPreference(
            LocalContext.current,
            PreferenceHelper.CUSTOM_PREF_NAME
        )

        NavHost(navController = navController, startDestination = Routes.ApiScreenRoute.route) {
            composable(Routes.NationalizeScreenRoute.route) {
                NationalizeScreen()
            }
            composable(Routes.DogScreenRoute.route) {
                DogScreen(navController)
            }
            composable(Routes.ApiScreenRoute.route) {
                ApiScreen()
            }
        }

        OnLifecycleEvent(onEvent = { _, event ->
            when (event) {
                Lifecycle.Event.ON_RESUME -> {
                    navController.navigate(prefs.settings?: Routes.DogScreenRoute.route)
                }
                else -> {}
            }
        })
    }
}

@Composable
fun OnLifecycleEvent(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    onEvent: (owner: LifecycleOwner, event: Lifecycle.Event) -> Unit
) {
    DisposableEffect(lifecycleOwner) {
        val lifecycle = lifecycleOwner.lifecycle
        val observer = LifecycleEventObserver { owner, event ->
            onEvent.invoke(owner, event)
        }
        lifecycle.addObserver(observer)
        onDispose {
            lifecycle.removeObserver(observer)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ApiScreenPreview() {
    ApiScreen()
}