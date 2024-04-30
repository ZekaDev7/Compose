package com.example.composelesson

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.random.Random


@Composable
fun PredictPage(navController: NavController) {

    val context = LocalContext.current
    val yourPredict = remember { mutableStateOf("") }
    val randomNum = remember { mutableIntStateOf(0) }
    val remainingRight = remember { mutableIntStateOf(6) }
    val direction = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LaunchedEffect(key1 = true) {
            randomNum.intValue = Random.nextInt(6)
            Log.e("Random Number", randomNum.toString())
        }

        Text(
            text = "Remaining Rights : ${remainingRight.intValue}",
            fontSize = 36.sp,
            color = Color.Red
        )
        Text(text = "Help : ${direction.value}", fontSize = 24.sp)

        TextField(
            value = yourPredict.value.trim(),
            onValueChange = { yourPredict.value = it.trim() },
            label = { Text(text = "Predict") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )

        Button(onClick = {

            if (yourPredict.value.isBlank()) {
                Toast.makeText(context, "You didn't enter your answer!!!", Toast.LENGTH_LONG).show()
                return@Button
            }

            if (remainingRight.intValue == 0) {
                navController.navigate("predictionResultPage/false") {
                    popUpTo("predictPage") { inclusive = true }
                }
            }

            if (yourPredict.value.toInt() == randomNum.intValue) {
                navController.navigate("predictionResultPage/true") {
                    popUpTo("predictPage") { inclusive = true }
                }
            } else {
                remainingRight.intValue--
            }

            if (yourPredict.value.toInt() > randomNum.intValue) {
                direction.value = "Decrease"
            }

            if (yourPredict.value.toInt() < randomNum.intValue) {
                direction.value = "Increase"
            }

            yourPredict.value = ""

        }, modifier = Modifier.size(250.dp, 50.dp)) {
            Text(text = "Predict")
        }
    }
}