package com.example.placesintheworld

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.placesintheworld.ui.theme.PlacesIntheWorldTheme
import com.example.placesintheworld.ui.theme.Principal
import com.example.placesintheworld.ui.theme.Segundo

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            PlacesIntheWorldTheme {
                Scaffold(
                    topBar = { MyTopBar() }
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = it.calculateTopPadding())
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = "PatallaLugares"
                        ) {
                            composable("PatallaLugares") {
                                PatallaLugares(navController = navController)
                            }
                            composable(
                                route = "Imagen/{textoLugar}/{imagenLugar}",
                                arguments = listOf(
                                    navArgument("textoLugar") { type = NavType.StringType },
                                    navArgument("imagenLugar") { type = NavType.IntType }
                                )
                            ) { backStackEntry ->
                                Imagen(
                                    backStackEntry.arguments?.getString("textoLugar") ?: "",
                                    backStackEntry.arguments?.getInt("imagenLugar") ?: 0,
                                    navController
                                )
                            }
                        }
                    }
                }
                FAB(navController = navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar() {
    TopAppBar(
        title = { Text(text = "PlaceIntheWorld", color = Color.White) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Principal),
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Menu",
                    tint = Color.White
                )
            }
        }
    )
}

@Composable
private fun FAB(navController: NavHostController
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    )  {
        FloatingActionButton(
            onClick = {
                      navController.navigate("PatallaLugares")
            },

            modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
            shape = RoundedCornerShape(40.dp),
            containerColor = Segundo
        ) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "check"  )
        }
    }
}
