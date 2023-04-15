package com.example.testtaskrit.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.testtaskrit.domain.entity.DogEntity
import com.example.testtaskrit.presentation.DogScreenUiState
import com.example.testtaskrit.presentation.DogScreenViewModel
import com.example.testtaskrit.screen.compose.theme.colorPrimaryDark
import org.koin.androidx.compose.koinViewModel

@Composable
fun DogScreen(
    viewModel: DogScreenViewModel = koinViewModel()
){
    val state by viewModel.state.observeAsState(DogScreenUiState.Initial)

    when(state){
        DogScreenUiState.Initial    -> Unit
        DogScreenUiState.Loading    -> DogScreenLoadind()
        is DogScreenUiState.Content -> DogScreenContent(dog = (state as DogScreenUiState.Content).dog)
        is DogScreenUiState.Error   -> DogScreenError(errorText = (state as DogScreenUiState.Error).message.orEmpty())
    }
}

@Composable
fun DogScreenContent(dog: DogEntity){
    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Button(
                onClick = {},
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            horizontalArrangement = Arrangement.Center
        ){
            val asyncPainter =
                rememberAsyncImagePainter("https://images.dog.ceo/breeds/corgi-cardigan/n02113186_8812.jpg")

            Image(
                painter = asyncPainter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(300.dp)
                    .clip(RoundedCornerShape(10))
                    .border(5.dp, colorPrimaryDark, RoundedCornerShape(10))
            )
        }
    }
}

@Composable
fun DogScreenError(errorText: String){
    CenteredColumn {
        Text(text = errorText)
    }
}

@Composable
fun DogScreenLoadind(){
    CenteredColumn {
        CircularProgressIndicator()
    }
}

@Composable
fun CenteredColumn(content: @Composable ColumnScope.() -> Unit){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        content = content
    )
}