@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class
)

package com.example.mobiledeveloping

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen() {
    // val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(15.dp),
                title = { Text("My First App") },
                navigationIcon = {
                    Image(
                        painter = rememberVectorPainter(image = Icons.Filled.FavoriteBorder),
                        contentDescription = "Menu",
                        modifier = Modifier.padding(5.dp).size(30.dp)
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            modifier = Modifier.size(40.dp),
                            painter = rememberVectorPainter(image = Icons.Filled.DateRange),
                            contentDescription = "Date Icon"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            modifier = Modifier.size(40.dp),
                            painter = rememberVectorPainter(image = Icons.Filled.Home),
                            contentDescription = "Home Icon"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            modifier = Modifier.size(40.dp),
                            painter = rememberVectorPainter(image = Icons.Filled.AccountCircle),
                            contentDescription = "Account Icon"
                        )
                    }
                }

            }
        }
    ) { padding ->
        padding
        Column(
            modifier = Modifier
                .padding(15.dp, 75.dp)
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
                items(10) { index ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .height(60.dp)
                    ) {
                        Row {
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
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    fontSize = 10.sp,
                                    text = "That a simple example for chat number $index. I just want to see this text on two lines so that you can try to make a restriction"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
internal fun Preview() {
    SecondScreen()
}

