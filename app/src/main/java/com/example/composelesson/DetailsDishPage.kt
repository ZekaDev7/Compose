package com.example.composelesson

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composelesson.entity.FoodsData

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "DiscouragedApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsDishPage(food: FoodsData) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = food.foodName, color = colorResource(id = R.color.orange)) },
                colors = TopAppBarDefaults.topAppBarColors(Color.DarkGray),
            )
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val activity = (LocalContext.current as Activity)
                Image(
                    bitmap = ImageBitmap.imageResource(
                        id = activity.resources.getIdentifier(
                            food.foodPicture, "drawable", activity.packageName
                        )
                    ), contentDescription = "", modifier = Modifier.size(250.dp)
                )
                Text(text = "${food.foodPrice} AZN", color = Color.Blue, fontSize = 50.sp)
                Button(
                    onClick = {
                        Log.e("Food", "${food.foodName} delivered")
                    },
                    modifier = Modifier.size(250.dp, 50.dp), colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = colorResource(id = R.color.orange)
                    )
                ) {
                    Text(text = "Deliver now")
                }
            }
        }
    )
}