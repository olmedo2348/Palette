package com.example.placesintheworld

import android.annotation.SuppressLint
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.navigation.NavHostController
import com.example.placesintheworld.ui.theme.Principal
import com.example.placesintheworld.ui.theme.Salty
import com.example.placesintheworld.ui.theme.Segundo


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Imagen(navControllerName: String, navControllerImagen: Int, navController: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Principal, Segundo
                    )
                )
            ),
    )
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = navControllerName,
                fontSize = 60.sp,
                color = Color.White,
                fontFamily = Salty,
                fontWeight = FontWeight.Bold,
            )
        }
        var rotation by remember { mutableStateOf(0f) }
        var scale by remember { mutableStateOf(1f) }
        var alpha by remember { mutableStateOf(1f) }
        var blur by remember { mutableStateOf(0f) }

        val imageSliderModel = remember {
            ImageSliderModel(
                rotationSlider = SliderFunction("Rotación", 0f, -180f, 180f) { rotation = it },
                scaleSlider = SliderFunction("Escalado", 1f, 0.5f, 2f) { scale = it },
                alphaSlider = SliderFunction("Efecto Alfa", 1f, 0f, 1f) { alpha = it },
                blurSlider = SliderFunction("Desenfoque", 0f, 0f, 1f) { blur = it }
            )
        }

        ImageSlider(navControllerImagen, imageSliderModel, rotation, scale, alpha, blur)
    }
}

data class SliderFunction(
    val name: String,
    val initValue: Float,
    val minValue: Float,
    val maxValue: Float,
    val onValueChanged: (Float) -> Unit
)

data class ImageSliderModel(
    val rotationSlider: SliderFunction,
    val scaleSlider: SliderFunction,
    val alphaSlider: SliderFunction,
    val blurSlider: SliderFunction
)
@Composable
fun ImageSlider(navControllerImagen: Int,
                sliderModel: ImageSliderModel,
                rotation: Float,
                scale: Float,
                alpha: Float,
                blur: Float) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            val scaledModifier = Modifier
                .graphicsLayer(
                    scaleX = 1 + scale / 2,
                    scaleY = 1 - scale / 5,
                    alpha = alpha,
                    rotationZ = rotation
                )

            Image(
                painter = painterResource(id = navControllerImagen),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .then(scaledModifier)
                    .blur(
                        radiusX = blur * 10.dp,
                        radiusY = blur * 10.dp,
                        edgeTreatment = BlurredEdgeTreatment.Unbounded
                    )
            )
        }
        // Rotación Slider
        SliderFunctionSlider(sliderModel.rotationSlider, rotation)

        // Escalado Slider
        SliderFunctionSlider(sliderModel.scaleSlider, scale)

        // Efecto Alfa Slider
        SliderFunctionSlider(sliderModel.alphaSlider, alpha)

        // Desenfoque Slider
        SliderFunctionSlider(sliderModel.blurSlider, blur)
    }
}

@Composable
fun SliderFunctionSlider(sliderFunction: SliderFunction, currentValue: Float) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Text(
            text = sliderFunction.name,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.width(16.dp))
        Slider(
            value = currentValue,
            onValueChange = { sliderFunction.onValueChanged(it) },
            valueRange = sliderFunction.minValue..sliderFunction.maxValue,
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp)
        )
    }
}