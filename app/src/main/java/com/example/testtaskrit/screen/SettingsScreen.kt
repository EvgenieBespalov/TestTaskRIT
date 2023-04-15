package com.example.testtaskrit.screen.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testtaskrit.R
import com.example.testtaskrit.screen.TabItem
import com.example.testtaskrit.screen.compose.theme.colorPrimary
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorPrimary),
        verticalArrangement = Arrangement.Top
    ) {
        RadioGroup()
    }
}

@Composable
fun RadioGroup() {
    val radioOptions = listOf("Dog API", "Nationalize API")

    var selectedItem by remember { mutableStateOf(radioOptions[0]) }

    Column(
        modifier = Modifier.selectableGroup()
    ) {
        radioOptions.forEach { label ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .selectable(
                        selected = (selectedItem == label),
                        onClick = { selectedItem = label },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    modifier = Modifier.padding(end = 16.dp).
                            align(Alignment.CenterVertically),
                    selected = (selectedItem == label),
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.White,
                        unselectedColor = Color.Black
                    ),
                    onClick = null
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = label,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 25.sp
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()
}