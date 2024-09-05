package com.example.myfirstapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstapplication.ui.theme.MyFirstApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ){
                Text(text = "Simple Text")
                ModifierExample()
                ModifierExample2()
                ModifierExample3()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstApplicationTheme {
        Greeting("jessi")
    }
}
@Preview(showBackground = true)
@Composable
fun ModifierExample(){
    Column (
        modifier = Modifier
            .padding(24.dp)
    ){
        Text(text = "Hello World")
    }
}

@Preview(showBackground = true)
@Composable
fun ModifierExample2(){
    Column (
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .clickable (onClick = {clickAction()})
    ){
        Text(text = "Hello World")
    }
}

@Preview(showBackground = true)
@Composable
fun ModifierExample3(){
    Column (
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
            .background(Color.Cyan)
            .border(width = 2.dp, color= Color.Green)
            .width(200.dp ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        Text(text = "Item 1")
        Text(text = "Item 2")
        Text(text = "Item 3")
        Text(text = "Item 4")
    }
}

fun clickAction(){
    println("Column Clicked")
}