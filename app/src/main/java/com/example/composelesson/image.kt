package com.example.composelesson

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource

@SuppressLint("DiscouragedApi")
@Composable
fun ImageAsString(photoName: String) {

    val activity = (LocalContext.current as Activity)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            bitmap = ImageBitmap.imageResource(
                id = activity.resources.getIdentifier(
                    photoName,
                    "drawable",
                    activity.packageName
                )
            ),
            contentDescription = "",
            modifier = Modifier.fillMaxSize()
        )
    }
}
