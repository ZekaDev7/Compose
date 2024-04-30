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


@Composable
fun PredictionResultPage(result: Boolean) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (result) {
            Text(text = "You Won!!!", fontSize = 36.sp)
            Image(painter = painterResource(id = R.drawable.glad), contentDescription = "")
        } else {
            Text(text = "You Lost!!!", fontSize = 36.sp)
            Image(painter = painterResource(id = R.drawable.sad), contentDescription = "")
        }
    }
}