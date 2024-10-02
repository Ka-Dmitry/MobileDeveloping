package com.example.mobiledeveloping

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ChatScreen() {
    // Произвольный интерфейс
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(75) { index ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        if (index % 2 == 0) {
                            5.dp
                        } else {
                            15.dp
                        }
                    )
            ) {
                Text(
                    text = "#${index}. Некая карточка с некой информацией...",
                    modifier = Modifier.padding(15.dp)
                )
            }
        }
    }
}