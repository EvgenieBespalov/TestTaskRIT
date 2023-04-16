package com.example.testtaskrit.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.testtaskrit.domain.entity.nationalize.NationalizeEntity
import com.example.testtaskrit.presentation.NationalizeScreenUiState
import com.example.testtaskrit.presentation.NationalizeScreenViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun NationalizeScreen(
    viewModel: NationalizeScreenViewModel = koinViewModel()
){
    val state by viewModel.state.observeAsState(NationalizeScreenUiState.Initial)
    val scope = rememberCoroutineScope()
    val openDialog = remember { mutableStateOf(false) }

    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Button(
                onClick = {
                    var names = arrayListOf("michael", "matthew")

                    scope.launch {
                        viewModel.getNationalize(names)
                    }
                    openDialog.value = true
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black),
                shape = MaterialTheme.shapes.small.copy(
                    topEnd = CornerSize(15.dp),
                    topStart = CornerSize(15.dp),
                    bottomEnd = CornerSize(15.dp),
                    bottomStart = CornerSize(15.dp)
                ),
            ){
                Text(
                    text = "Load nationalize",
                    fontSize = 25.sp
                )
            }
        }
    }

    when(state){
        NationalizeScreenUiState.Initial    -> Unit
        NationalizeScreenUiState.Loading    -> ScreenLoadind()
        is NationalizeScreenUiState.Content -> NationalizeScreenContent(nationalizes = (state as NationalizeScreenUiState.Content).nationalize, openDialog = openDialog)
        is NationalizeScreenUiState.Error   -> ScreenError(errorText = (state as NationalizeScreenUiState.Error).message.orEmpty())
    }
}


@Composable
fun NationalizeScreenContent(nationalizes: List<NationalizeEntity>, openDialog: MutableState<Boolean>){
    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "Nationalize API",
                fontSize=25.sp,
                color = Color.White
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            horizontalArrangement = Arrangement.Center
        ){
            if (openDialog.value) {
                Dialog(
                    //properties = DialogProperties(usePlatformDefaultWidth = true),
                    onDismissRequest = {
                        openDialog.value = false
                    }
                ){
                    Surface(//modifier = Modifier.fillMaxSize()
                    ) {
                        //Text(text = nationalize.toString())
                        LazyColumn{
                            items(nationalizes) { nationalize ->
                                Text(
                                    text = nationalize.name,
                                    color = Color.Black
                                )
                                Divider(color = Color.Black, thickness = 5.dp)
                                Column() {
                                    LazyRow {
                                        items(nationalize.country) { country ->
                                            Text(
                                                text = country.countryId,
                                                color = Color.Black
                                            )
                                            Divider(color = Color.Black, thickness = 5.dp)
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
    }
}
