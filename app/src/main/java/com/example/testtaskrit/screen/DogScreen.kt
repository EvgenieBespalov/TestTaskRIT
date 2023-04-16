package com.example.testtaskrit.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.testtaskrit.domain.entity.dog.DogEntity
import com.example.testtaskrit.presentation.DogScreenUiState
import com.example.testtaskrit.presentation.DogScreenViewModel
import com.example.testtaskrit.screen.compose.theme.colorPrimaryDark
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun DogScreen(
    navController: NavHostController,
    viewModel: DogScreenViewModel = koinViewModel()
){
    val state by viewModel.state.observeAsState(DogScreenUiState.Initial)
    val scope = rememberCoroutineScope()

    Column() {
        CenteredRow{
            Text(
                text = "Dog API",
                fontSize=25.sp,
                color = Color.White
            )
        }
        CenteredRow{
            Button(
                onClick = {
                    scope.launch {
                        viewModel.getDog()
                    }
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
                    text = "Load dog",
                    fontSize = 25.sp
                )
            }
        }
    }

    when(state){
        DogScreenUiState.Initial    -> Unit
        DogScreenUiState.Loading    -> ScreenLoadind()
        is DogScreenUiState.Content -> DogScreenContent(dog = (state as DogScreenUiState.Content).dog, navController)
        is DogScreenUiState.Error   -> ScreenError(errorText = (state as DogScreenUiState.Error).message.orEmpty())
    }
}

@Composable
fun DogScreenContent(dog: DogEntity, navController: NavHostController){
    Column(modifier = Modifier.padding(top = 80.dp)) {
        CenteredRow{
            val asyncPainter =
                rememberAsyncImagePainter(dog.message)

            val openDialog = remember { mutableStateOf(false) }

            Image(
                painter = asyncPainter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(300.dp)
                    .clip(RoundedCornerShape(10))
                    .border(5.dp, colorPrimaryDark, RoundedCornerShape(10))
                    .clickable(
                        enabled = true,
                        onClick = {
                            openDialog.value = true
                        }
                    )
            )
            if (openDialog.value) {
                Dialog(
                    properties = DialogProperties(usePlatformDefaultWidth = false),
                    onDismissRequest = {
                        openDialog.value = false
                    }
                ){
                    Surface(modifier = Modifier.fillMaxSize()) {
                        Image(
                            painter = asyncPainter,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(300.dp)
                                .clickable(
                                    enabled = true,
                                    onClick = {
                                        openDialog.value = false
                                    }
                                )
                        )
                    }
                }
            }
        }
    }
}