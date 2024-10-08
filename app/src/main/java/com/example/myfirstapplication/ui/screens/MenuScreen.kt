package com.example.myfirstapplication.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import java.security.AccessController

@Composable
fun MenuScreen(navController: NavController){
    Column {
        Text(text = "This is the menu screen")
        Button(onClick = {navController.navigate("home")} ) { }
        Button(onClick = {navController.navigate("components")} ) { }
    }
}