package com.example.myfirstapplication
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            MainContent()
//ComposeMultiScreenApp()
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


        @Composable
        fun MainContent() {
            Scaffold(
                bottomBar = { BottomMenu() },
                content = { paddingValues ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .background(Color(red = 0, green = 1, blue = 0))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.portada),
                            contentDescription = "Fondo",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(450.dp)
                                .drawWithContent {
                                    drawContent()

                                    drawRect(
                                        brush = Brush.verticalGradient(
                                            colors = listOf(
                                                Color.Black,
                                                Color.Transparent,
                                                Color.Black
                                            ),
                                            startY = 0f,
                                            endY = size.height
                                        ),
                                        size = size
                                    )},
                            contentScale = ContentScale.Crop
                        )

                        // Contenedor para los íconos
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.crunchi), // Ícono izquierdo
                                    contentDescription = "Ícono Izquierdo",
                                    tint = Color(red = 252, green = 94, blue = 1),
                                    modifier = Modifier
                                        .size(33.dp)
                                        .clickable { /* Acción del ícono izquierdo */ }
                                )

                                Row {
                                    Icon(
                                        painter = painterResource(id = R.drawable.baseline_cast_24), // Ícono derecho 1
                                        contentDescription = "Ícono Derecho 1",
                                        tint = Color.White,
                                        modifier = Modifier
                                            .size(33.dp)
                                            .clickable { /* Acción del ícono derecho 1 */ }
                                    )
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Icon(
                                        painter = painterResource(id = R.drawable.lupa), // Ícono derecho 2
                                        contentDescription = "Ícono Derecho 2",
                                        tint = Color.White,
                                        modifier = Modifier
                                            .size(33.dp)
                                            .clickable { /* Acción del ícono derecho 2 */ }
                                    )
                                }
                            }

                            // Contenido desplazable
                            Column(
                                modifier = Modifier
                                    .padding(top = 320.dp)
                            ) {
                                Text(
                                    text = "Dob | Sub",
                                    color = Color.White,
                                    fontSize = 15.sp
                                )
                                Text(
                                    text = "Alcanza lo más alto y todo será tuyo",
                                    color = Color.White,
                                    fontSize = 15.sp,
                                    modifier = Modifier.padding(top = 10.dp)
                                )
                                Text(
                                    text = "En la cima de la torre encontrarás todo lo que existe.",
                                    color = Color.White,
                                    fontSize = 15.sp,
                                    modifier = Modifier.padding(top = 18.dp)
                                )
                                Row(
                                    modifier = Modifier.padding(top = 16.dp)
                                ) {
                                    Button(
                                        onClick = { /* Acción del botón 1 */ },
                                        shape = RoundedCornerShape(0.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = Color(252, 94, 1),
                                            contentColor = Color.Black
                                        ),
                                        modifier = Modifier
                                            .padding(end = 12.dp)
                                            .width(315.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Filled.PlayArrow,
                                            contentDescription = "Reproducir",
                                            tint = Color.Black,
                                            modifier = Modifier.size(25.dp)
                                        )
                                        BasicText(
                                            text = " SEGUIR VIENDO T1 E1",
                                            style = TextStyle(
                                                fontSize = 15.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        )
                                    }

                                    Spacer(modifier = Modifier.width(20.dp))

                                    // Marcador
                                    Box(
                                        modifier = Modifier
                                            .size(38.dp)
                                            .border(2.dp, Color(252, 94, 1))
                                            .padding(4.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.img),
                                            contentDescription = "Marcador",
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(20.dp))
                                Text(
                                    text = "NUESTRAS RECOMENDACIONES",
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                                Spacer(modifier = Modifier.height(8.dp))

                                // Lista de categorías con viewers
                                LazyRow(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    items(listOf(
                                        CategoryData("Overwatch 2", R.drawable.onepiece),
                                        CategoryData("Fortnite", R.drawable.dragonball),
                                        CategoryData("Tom Clancy's R6", R.drawable.demon)
                                    )) { category ->
                                        CategoryCard(category.title, category.imageRes)
                                    }
                                }
                            }
                        }
                    }
                }
            )
        }

        data class CategoryData(val title: String, val imageRes: Int)

        @Composable
        fun CategoryCard(title: String, imageRes: Int) {
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .width(130.dp)
                    .padding(vertical = 8.dp)
                    .background(Color(red = 0, green = 1, blue = 0))
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .background(Color(red = 0, green = 1, blue = 0))
                ) {
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = title,
                        modifier = Modifier.height(165.dp),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Color.White,
                        modifier = Modifier.padding(top = 6.dp, start = 6.dp),
                        textAlign = TextAlign.Left
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Dob | Sub",
                            fontSize = 12.sp,
                            color = Color.Gray,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.trespuntos),
                            modifier = Modifier.size(24.dp),
                            contentDescription = "Marcador"
                        )
                    }
                }
            }
        }

        @Composable
        fun BottomMenu() {
            Row(
                modifier = Modifier
                    .background(Color(36, 37, 42))
                    .padding(top = 3.dp)
                    .fillMaxWidth()
                    .padding(start = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BottomMenuItem(
                    icon = Icons.Default.Home,
                    text = "Inicio",
                    iconSize = 35.dp
                )
                BottomMenuItem(
                    painter = painterResource(id = R.drawable.baseline_bookmark_24),
                    text = "Mis listas",
                    iconSize = 35.dp
                )
                BottomMenuItem(
                    painter = painterResource(id = R.drawable.baseline_content_copy_24),
                    text = "Explorar",
                    iconSize = 35.dp
                )
                BottomMenuItem(
                    painter = painterResource(id = R.drawable.baseline_auto_awesome_24),
                    text = "Simulcasts",
                    iconSize = 35.dp
                )
                BottomMenuItemWithRoundImage(
                    imageRes = R.drawable.yo,
                    contentDescription = "Marcador",
                    text = "Cuenta"
                )
            }

        }

        @Composable
        fun BottomMenuItem(
            icon: androidx.compose.ui.graphics.vector.ImageVector? = null,
            painter: androidx.compose.ui.graphics.painter.Painter? = null,
            text: String,
            iconSize: Dp // Agregar tamaño como parámetro
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                if (icon != null) {
                    Icon(
                        imageVector = icon,
                        contentDescription = text,
                        tint = Color(252, 94, 1),
                        modifier = Modifier.size(iconSize)
                    )
                } else if (painter != null) {
                    Icon(
                        painter = painter,
                        contentDescription = text,
                        tint = Color.White,
                        modifier = Modifier.size(iconSize)
                    )
                }
                Text(text = text, color = Color.White, fontSize = 12.sp)
            }
        }
        @Composable
        fun BottomMenuItemWithRoundImage(imageRes: Int, contentDescription: String, text: String) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape)
                        .background(Color.Transparent)
                        .clickable {  }
                ) {
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = contentDescription,
                        modifier = Modifier.fillMaxSize(), // Ocupa todo el botón
                        contentScale = ContentScale.Crop // Asegúrate de que la imagen se recorte adecuadamente
                    )
                }

                // Texto debajo del ícono
                Text(
                    text = text,
                    color = Color.White, // Asegúrate de que el texto sea visible
                    fontSize = 12.sp
                )
            }
        }
        @Composable
        fun BottomMenuItem(icon: androidx.compose.ui.graphics.vector.ImageVector? = null, painter: androidx.compose.ui.graphics.painter.Painter? = null, text: String) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                if (icon != null) {
                    Icon(imageVector = icon, contentDescription = text, tint = Color(252, 94, 1))
                } else if (painter != null) {
                    Icon(painter = painter, contentDescription = text, tint = Color.White)
                }
                Text(text = text, color = Color.White, fontSize = 12.sp)
            }
        }



    }@Composable
    fun MainContent() {
        Scaffold(
            bottomBar = { BottomMenu() },
            content = { paddingValues ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .background(Color(red = 0, green = 1, blue = 0))
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.portada),
                        contentDescription = "Fondo",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(450.dp)
                            .drawWithContent {
                                drawContent()

                                drawRect(
                                    brush = Brush.verticalGradient(
                                        colors = listOf(
                                            Color.Black,
                                            Color.Transparent,
                                            Color.Black
                                        ),
                                        startY = 0f,
                                        endY = size.height
                                    ),
                                    size = size
                                )},
                        contentScale = ContentScale.Crop
                    )

                    // Contenedor para los íconos
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.crunchi), // Ícono izquierdo
                                contentDescription = "Ícono Izquierdo",
                                tint = Color(red = 252, green = 94, blue = 1),
                                modifier = Modifier
                                    .size(33.dp)
                                    .clickable { /* Acción del ícono izquierdo */ }
                            )

                            Row {
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_cast_24), // Ícono derecho 1
                                    contentDescription = "Ícono Derecho 1",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(33.dp)
                                        .clickable { /* Acción del ícono derecho 1 */ }
                                )
                                Spacer(modifier = Modifier.width(16.dp))
                                Icon(
                                    painter = painterResource(id = R.drawable.lupa), // Ícono derecho 2
                                    contentDescription = "Ícono Derecho 2",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(33.dp)
                                        .clickable { /* Acción del ícono derecho 2 */ }
                                )
                            }
                        }

                        // Contenido desplazable
                        Column(
                            modifier = Modifier
                                .padding(top = 320.dp)
                        ) {
                            Text(
                                text = "Dob | Sub",
                                color = Color.White,
                                fontSize = 15.sp
                            )
                            Text(
                                text = "Alcanza lo más alto y todo será tuyo",
                                color = Color.White,
                                fontSize = 15.sp,
                                modifier = Modifier.padding(top = 10.dp)
                            )
                            Text(
                                text = "En la cima de la torre encontrarás todo lo que existe.",
                                color = Color.White,
                                fontSize = 15.sp,
                                modifier = Modifier.padding(top = 18.dp)
                            )
                            Row(
                                modifier = Modifier.padding(top = 16.dp)
                            ) {
                                Button(
                                    onClick = { /* Acción del botón 1 */ },
                                    shape = RoundedCornerShape(0.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(252, 94, 1),
                                        contentColor = Color.Black
                                    ),
                                    modifier = Modifier
                                        .padding(end = 12.dp)
                                        .width(315.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.PlayArrow,
                                        contentDescription = "Reproducir",
                                        tint = Color.Black,
                                        modifier = Modifier.size(25.dp)
                                    )
                                    BasicText(
                                        text = " SEGUIR VIENDO T1 E1",
                                        style = TextStyle(
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                }

                                Spacer(modifier = Modifier.width(20.dp))

                                // Marcador
                                Box(
                                    modifier = Modifier
                                        .size(38.dp)
                                        .border(2.dp, Color(252, 94, 1))
                                        .padding(4.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.img),
                                        contentDescription = "Marcador",
                                        modifier = Modifier.size(24.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(20.dp))
                            Text(
                                text = "NUESTRAS RECOMENDACIONES",
                                fontSize = 20.sp,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.height(8.dp))

                            // Lista de categorías con viewers
                            LazyRow(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                items(listOf(
                                    CategoryData("One Piece", R.drawable.onepiece),
                                    CategoryData("Dragon Ball", R.drawable.dragonball),
                                    CategoryData("Demon Slayer", R.drawable.demon)
                                )) { category ->
                                    CategoryCard(category.title, category.imageRes)
                                }
                            }
                        }
                    }
                }
            }
        )
    }

    data class CategoryData(val title: String, val imageRes: Int)

    @Composable
    fun CategoryCard(title: String, imageRes: Int) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .width(130.dp)
                .padding(vertical = 8.dp)
                .background(Color(red = 0, green = 1, blue = 0))
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .background(Color(red = 0, green = 1, blue = 0))
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = title,
                    modifier = Modifier.height(165.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.White,
                    modifier = Modifier.padding(top = 6.dp, start = 6.dp),
                    textAlign = TextAlign.Left
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Dob | Sub",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.trespuntos),
                        modifier = Modifier.size(24.dp),
                        contentDescription = "Marcador"
                    )
                }
            }
        }
    }

    @Composable
    fun BottomMenu() {
        Row(
            modifier = Modifier
                .background(Color(36, 37, 42))
                .padding(top = 3.dp)
                .fillMaxWidth()
                .padding(start = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BottomMenuItem(
                icon = Icons.Default.Home,
                text = "Inicio",
                iconSize = 35.dp
            )
            BottomMenuItem(
                painter = painterResource(id = R.drawable.baseline_bookmark_24),
                text = "Mis listas",
                iconSize = 35.dp
            )
            BottomMenuItem(
                painter = painterResource(id = R.drawable.baseline_content_copy_24),
                text = "Explorar",
                iconSize = 35.dp
            )
            BottomMenuItem(
                painter = painterResource(id = R.drawable.baseline_auto_awesome_24),
                text = "Simulcasts",
                iconSize = 35.dp
            )
            BottomMenuItemWithRoundImage(
                imageRes = R.drawable.yo,
                contentDescription = "Marcador",
                text = "Cuenta"
            )
        }

    }

    @Composable
    fun BottomMenuItem(
        icon: androidx.compose.ui.graphics.vector.ImageVector? = null,
        painter: androidx.compose.ui.graphics.painter.Painter? = null,
        text: String,
        iconSize: Dp // Agregar tamaño como parámetro
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = text,
                    tint = Color(252, 94, 1),
                    modifier = Modifier.size(iconSize)
                )
            } else if (painter != null) {
                Icon(
                    painter = painter,
                    contentDescription = text,
                    tint = Color.White,
                    modifier = Modifier.size(iconSize)
                )
            }
            Text(text = text, color = Color.White, fontSize = 12.sp)
        }
    }
    @Composable
    fun BottomMenuItemWithRoundImage(imageRes: Int, contentDescription: String, text: String) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(Color.Transparent)
                    .clickable {  }
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = contentDescription,
                    modifier = Modifier.fillMaxSize(), // Ocupa todo el botón
                    contentScale = ContentScale.Crop // Asegúrate de que la imagen se recorte adecuadamente
                )
            }

            // Texto debajo del ícono
            Text(
                text = text,
                color = Color.White, // Asegúrate de que el texto sea visible
                fontSize = 12.sp
            )
        }
    }
    @Composable
    fun BottomMenuItem(icon: androidx.compose.ui.graphics.vector.ImageVector? = null, painter: androidx.compose.ui.graphics.painter.Painter? = null, text: String) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            if (icon != null) {
                Icon(imageVector = icon, contentDescription = text, tint = Color(252, 94, 1))
            } else if (painter != null) {
                Icon(painter = painter, contentDescription = text, tint = Color.White)
            }
            Text(text = text, color = Color.White, fontSize = 12.sp)
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
        composable("home"){ HomeScreen(navController) }
    }
}*/
