package com.example.mobiledeveloping

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobiledeveloping.FetchedSingleFact.CatBreed
import com.example.mobiledeveloping.FetchingMultipleThings.CatViewModel
import com.example.mobiledeveloping.UnsuccesfulAttempt.BreedModel

/* UnsuccessfulAttempt

var breedList: BreedList? = null
suspend fun getInitialData(){
    breedList = getAllBreeds()
    Log.i("CHECK_RESPONSE_INITIATE", "${breedList}")
}*/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(context: Context) {

    // FetchedSingleFact
    /* val viewModel: CatFactViewModel = viewModel()
    var catFact by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        viewModel.fetchCatFact()
        Log.i("CHECK_COMPOSABLE_FACT_FETCH", "${viewModel.catFact}")
    }

    catFact = viewModel.catFact ?: "Загрузка..." */

    /* UnsuccessfulAttempt

    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        coroutineScope.launch {
            getInitialData()
        }
    }*/

    val visible = remember {
        mutableStateOf(true)
    }

    Scaffold(topBar = {
        // UnsuccessfulAttempt Testing // TopAppBar(title = { Text(text = "${breedList?.breeds?.get(0)?.breed}") }, navigationIcon = {
        // Default // TopAppBar(title = { Text(text = "I Like Cats") }, navigationIcon = {
        TopAppBar(title = { Text(text = "I Like Cats") }, navigationIcon = {
            IconButton(onClick = {

            }) {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )
            }
        })
    }, bottomBar = {
        BottomAppBar {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                IconButton(onClick = { visible.value = true }) {
                    Icon(
                        Icons.Filled.Home,
                        contentDescription = null,
                        modifier = Modifier.size(100.dp)
                    )
                }
                IconButton(onClick = { visible.value = false }) {
                    Icon(
                        Icons.Filled.List,
                        contentDescription = null,
                        modifier = Modifier.size(100.dp)
                    )
                }
            }
        }
    }) { paddingValues ->
        if (visible.value) BreedsScreen(paddingValues)
        else FactsScreen(paddingValues)
    }
}

@Composable
fun FactsScreen(paddingValues: PaddingValues) {

    val context = LocalContext.current

    val viewModel: CatViewModel = viewModel()

    LaunchedEffect(Unit) {
        viewModel.fetchCatFacts()
    }

        viewModel.catFacts.forEach { fact ->
            Text(text = fact)
        }

    Column(
        modifier = Modifier.padding(paddingValues)
    ) {
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp), onClick = { /*Здесь ничего нет*/ }) {
            Text(text = "Click to reload facts")
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            /*
            items(5) { index ->

                FactCard(index = index)
            }
             */
            itemsIndexed(viewModel.catFacts) { index, fact ->
                FactCard(index, fact)
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun BreedsScreen(paddingValues: PaddingValues) {

    val viewModel: CatViewModel = viewModel()

    LaunchedEffect(Unit) {
        viewModel.fetchCatBreeds(limit = 5)
    }

    Column(
        modifier = Modifier.padding(paddingValues)
    ) {
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            TextField(value = "",
                onValueChange = {},
                placeholder = { Text(text = "Text count of breeds") })
            Button(
                onClick = { /*TODO*/ }, modifier = Modifier.padding(15.dp, 5.dp, 0.dp, 0.dp)
            ) {
                Text(
                    text = "GET"
                )
            }
        }
        Text(
            text = "What are the breed of kitties",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(20.dp)
        )
        LazyColumn() {
            itemsIndexed(viewModel.catBreeds) { index, breed ->
                BreedCard(breed)
            }
        }
    }
}

@Composable
fun FactCard(index: Int, fact: String) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .padding(10.dp)
    ) {
        Text(
            text = "Fact ${index + 1}", fontSize = 20.sp, fontWeight = FontWeight.Bold
        )
        LazyColumn(
            modifier = Modifier.padding(0.dp, 5.dp)
        ) {
            item {
                Text(
                    // text = "fact", color = Color.Gray
                    text = fact, color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun BreedCard(info: CatBreed) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.cat),
            contentDescription = "cat.svg",
            modifier = Modifier
                .padding(10.dp)
                .size(60.dp)
        )
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                // text = "breed", fontWeight = FontWeight.Bold
                text = info.breed, fontWeight = FontWeight.Bold
            )
            Text(
                // text = "From country: country", color = Color.Gray
                text = "From country: ${info.country}", color = Color.Gray
            )
            Text(
                // text = "Coat: coat", color = Color.Gray
                text = "Coat: ${info.coat}", color = Color.Gray
            )
        }
    }
}