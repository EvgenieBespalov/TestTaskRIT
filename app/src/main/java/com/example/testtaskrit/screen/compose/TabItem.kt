package com.example.testtaskrit.screen.compose

import androidx.compose.runtime.Composable
import com.example.testtaskrit.R

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var icon: Int, var title: String, var screen: ComposableFun) {
    object ApiScreen : TabItem(R.drawable.ic_icon, "Api", { ApiScreen() })
    object SettingsScreen : TabItem(R.drawable.ic_icon, "Settings", { SettingsScreen() })
}