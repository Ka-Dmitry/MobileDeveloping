package com.example.mobiledeveloping

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

class MainViewModel : ViewModel() {
    val isCalendarClicked = mutableStateOf(false)
    val isHomeClicked = mutableStateOf(true)
    val isProfileClicked = mutableStateOf(false)

    fun onCalendarClicked() {
        isCalendarClicked.value = true
        isHomeClicked.value = false
        isProfileClicked.value = false
    }

    fun onHomeClicked() {
        isCalendarClicked.value = false
        isHomeClicked.value = true
        isProfileClicked.value = false
    }

    fun onProfileClicked() {
        isCalendarClicked.value = false
        isHomeClicked.value = false
        isProfileClicked.value = true
    }
}

internal enum class Screens(val screenName: String) {
    MainScreen("main_screen"),
    ChatScreen("chat_screen"),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel = viewModel()) {
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(modifier = Modifier.padding(15.dp, 5.dp),
                title = { Text("My First App") },
                navigationIcon = {
                    Image(
                        painter = rememberVectorPainter(image = Icons.Filled.FavoriteBorder),
                        contentDescription = "Menu",
                        modifier = Modifier
                            .padding(5.dp)
                            .size(30.dp)
                    )
                })
        },
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        modifier = Modifier.padding(20.dp),
                        onClick = { viewModel.onCalendarClicked() },
                    ) {
                        Icon(
                            modifier = Modifier.size(40.dp),
                            painter = rememberVectorPainter(image = Icons.Filled.DateRange),
                            contentDescription = "Date Icon"
                        )
                    }
                    IconButton(
                        modifier = Modifier.padding(20.dp),
                        onClick = { viewModel.onHomeClicked() },
                    ) {
                        Icon(
                            modifier = Modifier.size(40.dp),
                            painter = rememberVectorPainter(image = Icons.Filled.Home),
                            contentDescription = "Home Icon"
                        )
                    }
                    IconButton(
                        modifier = Modifier.padding(20.dp),
                        onClick = { viewModel.onProfileClicked() },
                    ) {
                        Icon(
                            modifier = Modifier.size(40.dp),
                            painter = rememberVectorPainter(image = Icons.Filled.AccountCircle),
                            contentDescription = "Profile Icon"
                        )
                    }
                }

            }
        }
    ) { paddingValues ->
        when {
            viewModel.isProfileClicked.value -> Profile(paddingValues)
            viewModel.isHomeClicked.value -> ChatList(paddingValues, navController)
            viewModel.isCalendarClicked.value -> Calendar(paddingValues)
        }
    }
}

@Composable
fun ChatList(paddingValues: PaddingValues, navController: NavController) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth()
    ) {
        Text(
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            text = "Hello! These is your last chats",
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(50) { index ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .height(60.dp)
                        .clickable { navController.navigate(Screens.ChatScreen.screenName) }
                ) {
                    Image(
                        painter = painterResource(
                            id = R.drawable.ic_launcher_foreground
                        ),
                        contentDescription = "Icon",
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(CircleShape)
                            .size(50.dp)
                            .paint(
                                painterResource(id = R.drawable.ic_launcher_background),
                                contentScale = ContentScale.FillBounds
                            )
                    )
                    Column {
                        Text(
                            text = "Chat Number $index",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(5.dp, 7.dp)
                        )
                        Text(
                            fontSize = 10.sp,
                            text = "That a simple example for chat number $index. " + "I just want to see this text on two lines so that you can try to make a restriction",
                            modifier = Modifier.padding(5.dp, 0.dp),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Profile(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello, Dear User!",
            fontSize = 20.sp,
            modifier = Modifier.padding(15.dp)
        )
        Row {
            Image(
                painter = painterResource(
                    id = R.drawable.ic_launcher_foreground
                ),
                contentDescription = "Icon",
                modifier = Modifier
                    .padding(10.dp)
                    .clip(CircleShape)
                    .size(100.dp)
                    .paint(
                        painterResource(id = R.drawable.ic_launcher_background),
                        contentScale = ContentScale.FillBounds
                    )
            )
            Column(
                modifier = Modifier.height(110.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "Kartamyshev Dmitry",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    fontSize = 16.sp,
                    text = "19 years old",
                )
            }
        }
    }
}

/*@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Calendar(paddingValues: PaddingValues) {
    val datePickerState = rememberDatePickerState()
    DatePicker(
        modifier = Modifier.padding(paddingValues),
        state = datePickerState,
        showModeToggle = false
    )
}*/

@Composable
fun Calendar(paddingValues: PaddingValues) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .background(Color.Yellow)
                .size(200.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Желтый квадрат чувствует себя календарем. Не спорьте с желтым квадратом",
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
internal fun Preview() {
    MainScreen(navController = rememberNavController())
}