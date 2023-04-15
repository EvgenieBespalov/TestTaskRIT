package com.example.testtaskrit.screen

import androidx.compose.runtime.Composable
import com.example.testtaskrit.R
import com.example.testtaskrit.screen.compose.ApiScreen
import com.example.testtaskrit.screen.compose.SettingsScreen

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var icon: Int, var title: String, var screen: ComposableFun) {
    object ApiScreen : TabItem(R.drawable.ic_icon, "Api", { ApiScreen() })
    object SettingsScreen : TabItem(R.drawable.ic_icon, "Settings", { SettingsScreen() })
}