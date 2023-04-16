package com.example.testtaskrit.screen.compose.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.testtaskrit.screen.TabItem
import com.example.testtaskrit.screen.compose.TabsContent
import com.google.accompanist.pager.rememberPagerState

private val DarkColorPalette = darkColors(
    primary = colorPrimary,
    primaryVariant = colorPrimary,
    secondary = colorAccent
)

private val LightColorPalette = lightColors(
    primary = colorPrimaryDark,
    primaryVariant = colorPrimaryDark,
    secondary = colorAccent

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun TestTaskRITTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = DarkColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
