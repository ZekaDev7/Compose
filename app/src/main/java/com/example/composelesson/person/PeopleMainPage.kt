package com.example.composelesson.person

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.example.composelesson.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PeopleMainPage() {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "People")}, colors = TopAppBarDefaults.topAppBarColors(
            colorResource(id = R.color.orange)))
    }, content = {

    }, floatingActionButton = {
        FloatingActionButton(
            onClick = {},
            containerColor = colorResource(id = R.color.orange),
            content = {
                Icon(painter = painterResource(id = R.drawable.add), contentDescription = "")
            }
        )
    })
}