package com.example.placesintheworld

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.palette.graphics.Palette
import com.example.placesintheworld.ui.theme.Principal
import com.example.placesintheworld.ui.theme.Salty
import com.example.placesintheworld.ui.theme.Segundo


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Imagen(navControllerImagen: Int) {
    val context = LocalContext.current

    val bitmap = remember {
        BitmapFactory.decodeResource(context.resources, )
    }

    /* Create the Palette, pass the bitmap to it */
    val palette = remember {
        Palette.from(bitmap).generate()
    }

    /* Get the dark vibrant swatch */
    val darkVibrantSwatch = palette.darkVibrantSwatch
    val vibrantSwatch = palette.vibrantSwatch
    val lightVibrantSwatch = palette.lightMutedSwatch
    val lightMutedSwatch = palette.lightMutedSwatch
    val mutedSwatch = palette.mutedSwatch
    val darkMutedSwatch = palette.darkMutedSwatch

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Green Hoodie",
                        color = darkVibrantSwatch?.let { Color(it.titleTextColor) } ?: Color.Red
                    )
                },
                /* Check for null before accessing properties on a swatch */
                /* Fall back to other colors if the dark vibrant swatch is not available */
                backgroundColor = darkVibrantSwatch?.let { Color(it.rgb) }
                    ?: Color.Transparent
            )
        }
    ) {
        Image(
            painter = painterResource(id = navControllerImagen),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()

        )
    }

}
