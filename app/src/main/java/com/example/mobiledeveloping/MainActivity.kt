@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mobiledeveloping

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import com.example.mobiledeveloping.ui.theme.MobileDevelopingTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileDevelopingTheme {
                Surface(
                ) {
                    MainScreen(this)
                }
            }
        }
    }
}