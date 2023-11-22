package com.example.placesintheworld

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PatallaLugares(navController: NavHostController) {
    val rvState = rememberLazyStaggeredGridState()
    Column {
        LazyVerticalStaggeredGrid(
            state = rvState,
            columns = StaggeredGridCells.Fixed(2),
        ) {
            items(getLugares()) { item ->
                ItemsLugares(
                    lugar = item,
                    navHostController = navController
                )
            }
        }
    }
}

data class Lugares(
    var name: String,
    var image: Int
)

fun getLugares(): List<Lugares> {
    return listOf(
        Lugares(
            "Morella",
            R.drawable.image,
        ),
        Lugares(
            "Lugo",
            R.drawable.image1,

        ),
        Lugares(
            "Bangkok",
            R.drawable.image2,
        ),
        Lugares(
            "Perú",
            R.drawable.image3,
        ),
        Lugares(
            "Pekín",
            R.drawable.image4,
        ),
        Lugares(
            "Granada",
            R.drawable.image5,
        ),
        Lugares(
            "Atenas",
            R.drawable.image6,
        ),
        Lugares(
            "Yucatán",
            R.drawable.image7,
        ),
        Lugares(
            "Seychelles",
            R.drawable.image8,
        ),
    )
}

@Composable
fun ItemsLugares(lugar: Lugares, navHostController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp)
            .clickable {
                navHostController.navigate("Imagen/${lugar.name}/${lugar.image}")
            }
    ) {
        Image(
            painter = painterResource(id = lugar.image),
            contentDescription = "imageLugar",
            contentScale = ContentScale.Crop,
        )
        Box(
            contentAlignment = Alignment.BottomStart,
            modifier = Modifier.fillMaxWidth()
                .background(Color.Black.copy(alpha = 0.3f)),
        ) {
            Text(
                text = lugar.name,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
