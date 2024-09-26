package com.example.myfirstapplication.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun ComponentsScreen(navController: NavController){
    var component by remember { mutableStateOf("")}//para actualizar el valor de la variable en la interfaz
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,//current state of drawer
        //drawer content
        drawerContent = {
            ModalDrawerSheet {
                Text("Menu", modifier = Modifier .padding(16.dp))
                HorizontalDivider()
                //Content1
                NavigationDrawerItem(
                    label = { Text("Content1") },
                    selected = false,
                    onClick = {
                        component ="Content1"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //Content2
                NavigationDrawerItem(
                    label = { Text("Content2") },
                    selected = false,
                    onClick = {
                        component ="Content2"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
            }
        }
    ) {
        //Screen Content
        Column {
            when(component){
                "Content1" -> {
                    Content1()
                }
                "Content2" -> {
                    Content2()
                }
            }
        }
    }



}

@Composable
fun Content1(){
    Text(text = "Content 1")
}
@Composable
fun Content2(){
    Text(text = "Content 2")
}