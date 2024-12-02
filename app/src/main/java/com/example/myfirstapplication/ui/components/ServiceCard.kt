package com.example.myfirstapplication.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.myfirstapplication.R


@Composable
fun ServiceCard(
    id: Int,
    name: String,
    username:String,
    imageURL: String?,
    onButtonClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(3.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black,
            contentColor = Color.White
        )
    ) {
        Row() {
            AsyncImage(
                modifier = Modifier
                    .width(80.dp)
                    .height(88.dp)
                    .padding(18.dp),
                model = imageURL,
                error = painterResource(R.drawable.android_logo),
                contentDescription = "Service logo ",
                contentScale = ContentScale.FillBounds
            )
            Column() {
                Text(
                    text = name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(2.dp, 8.dp, 0.dp, 0.dp)
                )
                Text(
                    text = name,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(4.dp, 0.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    modifier = Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp),
                    onClick = { onButtonClick() }) {
                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = "Service Details"
                    )
                }
            }
        }
    }
}