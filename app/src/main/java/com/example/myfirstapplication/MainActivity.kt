package com.example.myfirstapplication
import android.content.Context
import android.graphics.Picture
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myfirstapplication.ui.theme.MyFirstApplicationTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myfirstapplication.ui.screens.HomeScreen
import com.example.myfirstapplication.ui.screens.MenuScreen
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.activity
import com.example.myfirstapplication.ui.screens.BiometricsScreen
import com.example.myfirstapplication.ui.screens.CameraScreen
import com.example.myfirstapplication.ui.screens.ComponentsScreen
import com.example.myfirstapplication.ui.screens.ContactCalendarScreen
import com.example.myfirstapplication.ui.screens.HomeScreen
import com.example.myfirstapplication.ui.screens.LocalizacionScreen
import com.example.myfirstapplication.ui.screens.MenuScreen
import com.example.myfirstapplication.ui.screens.SegundoPlanoScreen
import com.example.myfirstapplication.ui.screens.WifiDatosScreen
import com.example.myfirstapplication.ui.screens.BiometricsScreen
import com.example.myfirstapplication.ui.screens.CameraScreen
import com.example.myfirstapplication.ui.screens.ComponentsScreen
import com.example.myfirstapplication.ui.screens.ContactCalendarScreen
import com.example.myfirstapplication.ui.screens.HomeScreen
import com.example.myfirstapplication.ui.screens.LocalizacionScreen
import com.example.myfirstapplication.ui.screens.MenuScreen
import com.example.myfirstapplication.ui.screens.SegundoPlanoScreen
import com.example.myfirstapplication.ui.screens.WifiDatosScreen

//import androidx.navigation.compose.NavHostController

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()//abarca el 100% de la pantalla
        setContent {
            ComposeMultiScreenApp()
            /*
            Column(
                modifier=Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ){
                CustomText()
                Picture()
                Content1()
                Content2()
                 //Text(text ="Simple text")
                 ModifierExample()
                ModifierExample2()
                  ModifierExample3()
                BoxExample1()
                BoxExample2()

            }
            //Layouts
            /*Column {
                 Text(text = "First Row")
                 Text(text = "Second Row")
                 Text(text = "Third Row")

                 Row{
                     Text(text = "Text1")
                     Text(text = "Text2")
                     Text(text = "Text3")
                     Text(text = "Text2")
                 }
                 Box{
                     Text(text = "Larabel 1")
                     Text(text = "Larabel 2")

                 }
                 Greeting(name ="World")

             }*/
            */
        }
    }
}
/*

private fun column(function: () -> Unit) {

}

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
    FJTheme {
        Greeting("Android")
    }
}
//@Preview(showBackground = true)
@Composable
fun ModifierExample(){
    Column(
        modifier= Modifier
            .padding(24.dp)
    ){
        Text(text="Hello world")

    }
}
//@Preview(showBackground = true)
@Composable
fun ModifierExample2(){
    Column(
        modifier= Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .clickable(onClick = { clickAction() })
    ){
        Text(text="Hello world")

    }
}
//@Preview(showBackground = true)
@Composable
fun ModifierExample3() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
            .background(Color.Red)
            .border(width = 2.dp, color = Color.Green)
            .width(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Hello Item 1")
        Text(text = "Hello Item 2")
        Text(text = "Hello Item 3")
        Text(text = "Hello Item 4")
        Text(text = "Hello Item 5")
    }}
@Preview(showBackground = true)
@Composable
fun CustomText() {
    Column {
        Text(
            stringResource(R.string.hello_world_text),
            color = colorResource(R.color.purple_500),
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold
        )
        val gradientColors = listOf(Color.Cyan, Color.Blue, Color.Red)
        Text(
            stringResource(R.string.hello_world_text),
            style = TextStyle(brush = Brush.linearGradient(colors =gradientColors))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Picture(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ){
        Image(
            modifier= Modifier
                .fillMaxWidth(),
            painter = painterResource(R.drawable.descargar),
            contentDescription ="Logo Android",
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
        Text (text = "This is a Title",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.descargar),
            contentDescription = "Android Logo",
            contentScale = ContentScale.Crop
        )
        Text(
            stringResource(R.string.Text_Card),
            textAlign = TextAlign.Justify,
            lineHeight = 18.sp,
            modifier = Modifier
                .padding(10.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun Content2() {
    Card(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Row {
            Image(
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp),
                //.fillMaxWidth()
                painter = painterResource(id = R.drawable.descargar),
                contentDescription = "Android Logo",
                contentScale = ContentScale.Crop
            )
            Column {
                Text (text = "This is a Title",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(10.dp)
                )
                Text(
                    stringResource(R.string.Text_Card),
                    textAlign = TextAlign.Justify,
                    lineHeight = 18.sp,
                    maxLines = 4,
                    modifier = Modifier
                        .padding(10.dp)
                )
            }
        }
    }
}

    @Preview(showBackground = true)
    @Composable
    fun BoxExample1() {
        Box(
            modifier = Modifier
                .background(Color.DarkGray)
                .fillMaxWidth()
                .padding(5.dp)
        ){
            Image(painterResource(R.drawable.descargar),
                contentDescription = "Android Logo",
                contentScale = ContentScale.FillBounds
            )
            Row(
                modifier = Modifier

                    .fillMaxWidth()
                    .padding(0.dp, 0.dp),
                horizontalArrangement = Arrangement.Center
            ){
                Icon(
                    Icons.Filled.AccountCircle,
                    contentDescription = "Icon Account"
                )
                Text(text = "Text")
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun BoxExample2() {
    Box(
        modifier = Modifier
            .background(Color.Magenta)
            .padding(5.dp)
            .size(290.dp)
    ) {
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
*/@Preview(showBackground = true)
@Composable
fun ComposeMultiScreenApp(){
    val navController = rememberNavController()
    Surface(color = Color.White) {
        SetupNavGraph(navController = navController)
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController,startDestination = "menu"){
        composable("menu"){ MenuScreen(navController) }
        composable("home"){ HomeScreen(navController) }
        composable("component"){ ComponentsScreen(navController) }
        //expo 1 programación de tareas en 2do plano
        composable("SegundoPlano"){ SegundoPlanoScreen() }
        //expo 2 servicios de rastreo y geolocalización
        composable("Location"){ LocalizacionScreen(viewModel()) }
        //expo 3 Acceso a contactos y calendario
        composable("ContactCalendar"){ ContactCalendarScreen() }
        //expo 4 Acceso a sensores biométricos
        composable("BiometricsScreen") { BiometricsScreen() }
        //expo 5 Acceso a cámara y manejo de archivos del dispositivo
        composable("CamaraScreen"){ CameraScreen() }
        //expo 6 Conectividad Wifi y datos celulares
        composable("wifidatos") {
            WifiDatosScreen(
                wifiManager = LocalContext.current.getSystemService(Context.WIFI_SERVICE) as WifiManager,
                connectivityManager = LocalContext.current.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager,
                context = LocalContext.current as ComponentActivity
            )
        }
    }
}