package com.example.testtaskrit.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.testtaskrit.domain.entity.nationalize.CountryEntity
import com.example.testtaskrit.domain.entity.nationalize.NationalizeEntity
import com.example.testtaskrit.presentation.NationalizeScreenUiState
import com.example.testtaskrit.presentation.NationalizeScreenViewModel
import com.example.testtaskrit.screen.compose.theme.colorAccent
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun NationalizeScreen(
    viewModel: NationalizeScreenViewModel = koinViewModel()
){
    val state by viewModel.state.observeAsState(NationalizeScreenUiState.Initial)
    val scope = rememberCoroutineScope()
    val openDialog = remember { mutableStateOf(false) }
    var textFieldName by remember { mutableStateOf("") }

    Column() {
        CenteredRow{
            Text(
                text = "Nationalize API",
                fontSize = 25.sp,
                color = Color.White
            )
        }
        CenteredRow{
            TextField(
                value = textFieldName,
                onValueChange = { textFieldName = it },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.White,
                    backgroundColor = colorAccent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                shape = MaterialTheme.shapes.small.copy(
                    topEnd = CornerSize(15.dp),
                    topStart = CornerSize(15.dp),
                    bottomEnd = CornerSize(15.dp),
                    bottomStart = CornerSize(15.dp)
                ),
                textStyle = TextStyle(fontSize = 25.sp),
            )
        }
        CenteredRow{
            Button(
                onClick = {
                    var names = listOf(*textFieldName.split(",").toTypedArray())
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
    Column(modifier = Modifier.padding(top = 80.dp)) {
        CenteredRow{
            if (openDialog.value) {
                Dialog(
                    onDismissRequest = {
                        openDialog.value = false
                    }
                ){
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        color = Color.White,
                        shape = RoundedCornerShape(size = 10.dp),

                    ) {
                        LazyColumn(
                            modifier = Modifier.padding(all = 5.dp)
                        ) {
                            nationalizes.forEach {
                                item {
                                    Text(
                                        text = it.name,
                                        color = Color.Black,
                                        fontSize = 25.sp
                                    )
                                }
                                CountryItem(it.country)
                            }
                        }
                    }
                }
            }
        }
    }
}

fun LazyListScope.CountryItem(countries: List<CountryEntity>) {
    items(countries) {
        Text(
            text = "Country ID: ${it.countryId} \t\t Probability: ${it.probability}",
            color = Color.Black,
            fontSize = 15.sp
        )
    }
}
