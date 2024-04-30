package com.example.composelesson.person

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composelesson.viewmodel.PersonRegistrationViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PersonRegistrationPage() {
    val tfPersonName = remember { mutableStateOf("") }
    val tfPersonPhoneNumber = remember { mutableStateOf("") }
    val localFocusManager = LocalFocusManager.current

    val viewModel: PersonRegistrationViewModel = viewModel()

    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(value = tfPersonName.value, onValueChange = { tfPersonName.value = it })
            TextField(
                value = tfPersonPhoneNumber.value,
                onValueChange = { tfPersonPhoneNumber.value = it })
            Button(onClick = {
                val personName = tfPersonName.value
                val personPhoneNumber = tfPersonPhoneNumber.value
                viewModel.registerPerson(personName, personPhoneNumber)
                localFocusManager.clearFocus()
            }) {

            }
        }
    }
}