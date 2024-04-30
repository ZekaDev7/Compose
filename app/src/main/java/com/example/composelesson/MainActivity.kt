package com.example.composelesson

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composelesson.notification.NotificationMainPage
import com.example.composelesson.person.Person
import com.example.composelesson.preferences.AppDataStore
import com.example.composelesson.ui.theme.ComposeLessonTheme
import com.example.composelesson.viewmodel.MainPageViewModel
import com.example.composelesson.viewmodelfactory.MainPageViewModelFactory
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLessonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NotificationMainPage()
                }
            }
        }
    }
}

@Composable
fun PersonMain() {
    val context = LocalContext.current
    val viewModel: MainPageViewModel = viewModel(
        factory = MainPageViewModelFactory(context.applicationContext as Application)
    )
}

@Composable
fun PreferencesApp() {
    val context = LocalContext.current
    val ads = AppDataStore(context)

    LaunchedEffect(key1 = true) {
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            ads.deleteName()
            val readName = ads.readName()
            Log.e("Coming name", readName)
        }
    }
}

@Composable
fun DropDownMenu() {
    val isOpened = remember { mutableStateOf(false) }
    val photoName = remember { mutableStateOf("photo") }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.wrapContentHeight()
        ) {
            Column(
                modifier = Modifier.wrapContentHeight(),
            ) {

                Spacer(modifier = Modifier.padding(20.dp))

                Button(
                    onClick = {
                        isOpened.value = true
                    },
                    modifier = Modifier.padding(20.dp, 0.dp)
                ) {
                    Text(text = "Show")
                }
                DropdownMenu(
                    expanded = isOpened.value,
                    onDismissRequest = {
                        isOpened.value = false
                    },
                    content = {
                        DropdownMenuItem(
                            text = { Text(text = "BMW") },
                            onClick = {
                                isOpened.value = false
                                photoName.value = "photo"
                            }
                        )
                        DropdownMenuItem(
                            text = { Text(text = "Mercedes") },
                            onClick = {
                                isOpened.value = false
                                photoName.value = "photo2"
                            }
                        )
                    }
                )

            }
        }
        ImageAsString(photoName = photoName.value)
    }


}

@Composable
fun Greeting() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "mainpage") {
        composable("mainpage") {
            MainPage(navController = navController)
        }

        composable(
            "page_a/{objectPerson}",
            arguments = listOf(
                navArgument("objectPerson") { type = NavType.StringType },
            )
        ) {

            val json = it.arguments?.getString("objectPerson")!!
            val objectPerson = Gson().fromJson(json, Person::class.java)
            PageA(navController = navController, objectPerson)
        }

        composable("page_b") {
            PageB(navController = navController)
        }
    }

}

@Composable
fun MainPage(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Welcome To Main Page")

        Button(onClick = {
            val person = Person(1, "Zeka", 22)
            val gson = Gson().toJson(person)
            navController.navigate("page_a/$gson")
        }) {
            Text(text = "Go to page A")
        }
    }
}

@Composable
fun GreenColumn(modifier: Modifier) {

    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Gray)
    ) {
        Text(text = stringResource(id = R.string.text), modifier = Modifier.align(Alignment.Center))
    }
}

@Preview(showBackground = true, locale = "az")
@Composable
fun GreetingPreview() {
    ComposeLessonTheme {
        ImageAsString("")
    }
}