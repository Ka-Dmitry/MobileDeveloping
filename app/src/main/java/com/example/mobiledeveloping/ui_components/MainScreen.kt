package com.example.mobiledeveloping.ui_components

import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mobiledeveloping.MainViewModel
import com.example.mobiledeveloping.utils.DrawerEvents
import com.example.mobiledeveloping.utils.IdArrayList
import com.example.mobiledeveloping.utils.ListItem
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    mainViewModel: MainViewModel = hiltViewModel(),
    onClick: (ListItem) -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val mainList = mainViewModel.mainList

    val topBarTitle = remember {
        mutableStateOf("Грибы")
    }
    LaunchedEffect(Unit) {
        mainViewModel.getAllItemsByCategory(topBarTitle.value)
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MainTopBar(
                title = topBarTitle.value,
                scaffoldState = scaffoldState
            ){
                topBarTitle.value = "Избранные"
                mainViewModel.getFavorites()
            }
        },
        drawerContent = {
            DrawerMenu() {
                when (it) {
                    is DrawerEvents.OnItemClick -> {
                        topBarTitle.value = it.title
                        //mainList.value = getListItemsByIndex(it.index, context)
                    }
                }
                coroutineScope.launch {
                    scaffoldState.drawerState.close()
                }
            }
        }
    ) { padding ->
        padding
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(mainList.value) { item ->
                MainListItem(item = item) { listItem ->
                    onClick(listItem)
                }
            }
        }
    }
}

/*private fun getListItemsByIndex(index: Int, context: Context): List<ListItem> {
    val list = ArrayList<ListItem>()
    val arrayList = context.resources.getStringArray(IdArrayList.listId[index])
    arrayList.forEach { item ->
        val itemArray = item.split("|")
        list.add(
            ListItem(
                itemArray[0],
                itemArray[1],
                itemArray[2]
            )
        )
    }
    return list
}*/