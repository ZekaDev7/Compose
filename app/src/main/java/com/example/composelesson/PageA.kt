package com.example.composelesson

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.composelesson.person.Person

@Composable
fun PageA(navController: NavController, objectPerson: Person) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Welcome To A Page")
        Text(text = objectPerson.name)
        Text(text = objectPerson.age.toString())

        Button(onClick = {
            navController.navigate("page_b") {
                popUpTo("page_a") { inclusive = true }
            }
        }) {
            Text(text = "Go to page B")
        }
    }

    val activity = (LocalContext.current as Activity)


    BackHandler(onBack = {
        activity.finish()
    })
}