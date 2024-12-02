package com.example.myfirstapplication.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myfirstapplication.navigation.NavManager
import com.example.myfirstapplication.ui.theme.MyFirstApplicationTheme

import com.example.myfirstapplication.viewModel.SearchViewModel

@Composable
fun LocalizacionScreen(viewModel: SearchViewModel) {
    MyFirstApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NavManager(viewModel)
        }
    }
}