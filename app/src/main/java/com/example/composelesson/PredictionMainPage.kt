package com.example.composelesson

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun PredictionMainPage(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Prediction Game", fontSize = 36.sp)
        Image(
            painter = painterResource(id = R.drawable.die),
            contentDescription = "",
            modifier = Modifier.size(128.dp)
        )
        Button(onClick = {
            navController.navigate("predictPage")
        }, modifier = Modifier.size(250.dp, 50.dp)) {

            Text(text = "Start The Game")
        }
    }
}

@Composable
fun PredictionTransferPage() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "predictionMainPage") {
        composable("predictionMainPage") {
            PredictionMainPage(navController = navController)
        }

        composable("predictPage") {
            PredictPage(navController = navController)
        }

        composable("predictionResultPage/{result}",
            arguments = listOf(
                navArgument("result") { type = NavType.BoolType }
            )) {
            val result = it.arguments?.getBoolean("result")!!
            PredictionResultPage(result = result)
        }
    }
}