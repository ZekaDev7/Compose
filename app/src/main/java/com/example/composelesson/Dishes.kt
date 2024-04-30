package com.example.composelesson

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composelesson.entity.FoodsData
import com.example.composelesson.viewmodel.FoodsViewModel
import com.google.gson.Gson


@Composable
fun TransferFoodsPage() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "mainDishPage") {
        composable("mainDishPage") {
            DishesMainPage(navController = navController)
        }

        composable("detailsDishPage/{food}",
            arguments = listOf(
                navArgument("food") { type = NavType.StringType }
            )
        ) {
            val json = it.arguments?.getString("food")
            val foodObject = Gson().fromJson(json, FoodsData::class.java)
            DetailsDishPage(food = foodObject)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "DiscouragedApi")
@Composable
fun DishesMainPage(navController: NavController) {
    val viewModel: FoodsViewModel = viewModel()
    val foodsList = viewModel.foodList.observeAsState(listOf())


//    LaunchedEffect(key1 = true) {
//        val food1 = FoodsData(1, "Kofte", "kofte", 10)
//        val food2 = FoodsData(2, "Fries", "fries", 4)
//        val food3 = FoodsData(3, "Pizza", "pizza", 13)
//        val food4 = FoodsData(4, "Doner", "doner", 3)
//        val food5 = FoodsData(5, "Lahmacun", "lahmacun", 5)
//        val food6 = FoodsData(6, "Ayran", "ayran", 1)
//
//        foodsList.add(food1)
//        foodsList.add(food2)
//        foodsList.add(food3)
//        foodsList.add(food4)
//        foodsList.add(food5)
//        foodsList.add(food6)
//    }


    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Foods", color = colorResource(id = R.color.orange)) },
            colors = TopAppBarDefaults.topAppBarColors(Color.DarkGray),
            modifier = Modifier.wrapContentHeight()
        )
    }, content = {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(count = foodsList.value!!.count(), itemContent = {
                val food = foodsList.value!![it]
                Card(
                    modifier = Modifier
                        .padding(all = 5.dp)
                        .fillMaxWidth()
                ) {
                    Row(modifier = Modifier.clickable {
                        val foodJson = Gson().toJson(food)
                        navController.navigate("detailsDishPage/$foodJson")
                    }) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(all = 10.dp)
                                .fillMaxWidth()
                        ) {
                            val activity = (LocalContext.current as Activity)
                            Image(
                                bitmap = ImageBitmap.imageResource(
                                    id = activity.resources.getIdentifier(
                                        food.foodPicture, "drawable", activity.packageName
                                    )
                                ), contentDescription = "", modifier = Modifier.size(100.dp)
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.SpaceEvenly,
                                    modifier = Modifier.fillMaxHeight()
                                ) {
                                    Text(text = food.foodName, fontSize = 20.sp)
                                    Spacer(modifier = Modifier.size(30.dp))
                                    Text(text = "${food.foodPrice}", color = Color.Red)
                                }
                                Icon(
                                    painter = painterResource(id = R.drawable.arrow),
                                    contentDescription = ""
                                )
                            }
                        }
                    }
                }
            })
        }
    })
}

