package com.example.myfirstapplication

import android.graphics.Picture
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myfirstapplication.ui.screens.ComponentsScreen
import com.example.myfirstapplication.ui.screens.HomeScreen
import com.example.myfirstapplication.ui.screens.MenuScreen
import com.example.myfirstapplication.ui.theme.MyFirstApplicationTheme
import com.example.myfirstapplication.ui.screens.HomeScreen
import com.example.myfirstapplication.ui.screens.MenuScreen
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
ComposeMultiScreenApp()
            /*Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ){
                CustomText()
                com.example.myfirstapplication.Picture()
                Content1()
                //Text(text = "Simple Text")
                //ModifierExample()
                //ModifierExample2()
                //ModifierExample3()
            }*/
        }
    }
}
/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstApplicationTheme {
        Greeting("jessi")
    }
}
//@Preview(showBackground = true)
@Composable
fun ModifierExample(){
    Column (
        modifier = Modifier
            .padding(24.dp)
    ){
        Text(text = "Hello World")
    }
}

//@Preview(showBackground = true)
@Composable
fun ModifierExample2(){
    Column (
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .clickable(onClick = { clickAction() })
    ){
        Text(text = "Hello World")
    }
}

//@Preview(showBackground = true)
@Composable
fun ModifierExample3(){
    Column (
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
            .background(Color.Cyan)
            .border(width = 2.dp, color = Color.Green)
            .width(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        Text(text = "Item 1")
        Text(text = "Item 2")
        Text(text = "Item 3")
        Text(text = "Item 4")
    }
}
@Preview(showBackground = true)
@Composable
fun CustomText(){
    Column {
        Text(
            stringResource(R.string.hello_world_text),
            color = colorResource(R.color.purple_200),
            fontSize = 28.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold
        )
        val gradientColor = listOf(Color.Cyan, Color.Blue)
        Text(
            stringResource(R.string.hello_world_text),
            style = TextStyle(brush = Brush.linearGradient(colors = gradientColor)))
    }
}
@Preview(showBackground = true)
@Composable
fun Picture(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(R.drawable.android_logo) ,
            contentDescription = "Logo Android",
            contentScale = ContentScale.Crop

        )

    }
}
@Preview(showBackground = true)
@Composable
fun Content1(){
    Card(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(5.dp)
    ){
            Text(text="This is a title",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                .padding(10.dp)
            )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 300.dp),
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Android Logo",
            contentScale = ContentScale.Crop
        )
        Text(stringResource(R.string.text_card),
            textAlign = TextAlign.Justify,
            lineHeight = 18.sp,
            modifier = Modifier
                .padding(10.dp)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun Content2(){
    Card(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Row{
            Image(
                modifier = Modifier
                    .width(width = 150.dp)
                    .height(height = 150.dp),
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "Android Logo",
                contentScale = ContentScale.Crop
            )

            Column {
                Text(text="This is a title",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(10.dp)
                )
                Text(stringResource(R.string.text_card),
                    textAlign = TextAlign.Justify,
                    maxLines = 7,
                    lineHeight = 16.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun BoxExample(){
    Box(
        modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxWidth()
            .padding(5.dp)

    ){
        Image(painterResource(R.drawable.android_logo),
            contentDescription = "Android Logo",
            contentScale = ContentScale.FillBounds
        )
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp,150.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Icon(
                Icons.Filled.AccountCircle,
                contentDescription = "Icon Account"

            )
            Text(text= "Text")
        }
        Text(text ="Text",
        textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp))



    }
}
@Preview(showBackground = true)
@Composable
fun BoxExample2(){
    Box(
        modifier = Modifier
        .background(Color.Magenta)
        .padding(5.dp)
        .size(250.dp)
        ){
        Text(text = "TopStart", Modifier.align(Alignment.TopStart))
        Text(text = "TopEnd", Modifier.align(Alignment.TopEnd))
        Text(text = "CenterStart", Modifier.align(Alignment.CenterStart))
        Text(text = "Center", Modifier.align(Alignment.Center))
        Text(text = "CenterEnd", Modifier.align(Alignment.CenterEnd))
        Text(text = "BottomStart", Modifier.align(Alignment.BottomStart))
        Text(text = "BottomEnd", Modifier.align(Alignment.BottomEnd))

    }


}
fun clickAction(){
    println("Column Clicked")
}
*/
@Composable
fun ComposeMultiScreenApp(){
    val navController = rememberNavController()
    Surface(color = Color.White) {
        SetupNavGraph(navController = navController)
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "menu"){
        composable("menu"){ MenuScreen(navController)}
        composable("home"){ HomeScreen(navController)}
        composable("components"){ ComponentsScreen(navController) }
    }
}