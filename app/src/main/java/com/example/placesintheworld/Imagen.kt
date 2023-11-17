package com.example.placesintheworld

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.placesintheworld.ui.theme.Principal
import com.example.placesintheworld.ui.theme.Salty
import com.example.placesintheworld.ui.theme.Segundo

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Imagen(navControllerName:String, navControllerImagen: Int, navController: NavHostController){
    Column(
        Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(
                colors = listOf(
                    Principal, Segundo
                )
            )),
    )
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ){
            Text(
                text = navControllerName,
                fontSize = 60.sp,
                color = Color.White,
                fontFamily = Salty,
                fontWeight = FontWeight.Bold,
            )
        }
        Image(
            painter = painterResource(id = navControllerImagen),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 50.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}