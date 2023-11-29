package com.example.placesintheworld

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
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
            "image 1",
            R.drawable.image1,

        ),
        Lugares(
            "image 2",
            R.drawable.image2,
        ),
        Lugares(
            "image 3",
            R.drawable.image3,
        ),
        Lugares(
            "image 4",
            R.drawable.image4,
        ),
        Lugares(
            "image 5",
            R.drawable.image5,
        ),
        Lugares(
            "image 6",
            R.drawable.image6,
        ),
        Lugares(
            "image 7",
            R.drawable.image7,
        ),
        Lugares(
            "image 8",
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
                navHostController.navigate("Imagen/${lugar.image}")
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
                modifier = Modifier.padding(8.dp),
                textDecoration = TextDecoration.Underline,
            )
        }
    }
}
