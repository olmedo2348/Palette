package com.example.placesintheworld

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Imagen(navControllerImagen: Int) {
    val context = LocalContext.current

    /* Convert our Image Resource into a Bitmap */
    val bitmap = remember {
        BitmapFactory.decodeResource(context.resources, navControllerImagen)
    }

    /* Create the Palette, pass the bitmap to it */
    val palette = remember {
        Palette.from(bitmap).generate()
    }

    /* Get the dark vibrant swatch */
    val darkVibrantSwatch = palette.darkVibrantSwatch
    val vibrantSwatch = palette.vibrantSwatch
    val lightVibrantSwatch = palette.lightVibrantSwatch
    val lightMutedSwatch = palette.lightMutedSwatch
    val mutedSwatch = palette.mutedSwatch
    val darkMutedSwatch = palette.darkMutedSwatch

    val view = LocalView.current
    val window = (view.context as Activity).window
    window.statusBarColor = (darkVibrantSwatch?.let { Color(it.rgb).toArgb() } ?: Color.Red.toArgb())

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Palette",
                        color = vibrantSwatch?.let { Color(it.titleTextColor) } ?: Color.Red)
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {

                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(vibrantSwatch?.let { Color(it.rgb) }
                    ?: Color.Transparent)
            )
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = navControllerImagen),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .height(370.dp),
                    contentScale = ContentScale.Crop
                )
            }
            // Display the palettes with their names
            PaletteRow("Dark Vibrant", darkVibrantSwatch)
            PaletteRow("Vibrant", vibrantSwatch)
            PaletteRow("Light Vibrant", lightVibrantSwatch)
            PaletteRow("Light Muted", lightMutedSwatch)
            PaletteRow("Muted", mutedSwatch)
            PaletteRow("Dark Muted", darkMutedSwatch)
        }
    }
}

@Composable
fun PaletteRow(name: String, color: Palette.Swatch?) {
    Row(
        modifier = Modifier
            .background(color?.rgb?.let { Color(it) } ?: Color.Gray)
            .fillMaxWidth()
            .padding(30.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = name,
            color = color?.let { Color(it.titleTextColor) } ?: Color.Black,
        )
    }
}