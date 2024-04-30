package com.example.composelesson

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.launch

@Composable
fun Drawable() {
    val items = listOf("One", "Two")
    val selectedItems = remember {
        mutableIntStateOf(0)
    }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                items.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        label = { Text(text = item) },
                        icon = {
                            when (item) {
                                "One" -> Icon(
                                    painter = painterResource(id = R.drawable.glad),
                                    contentDescription = ""
                                )

                                "Two" -> Icon(
                                    painter = painterResource(id = R.drawable.sad),
                                    contentDescription = ""
                                )
                            }
                        },
                        selected = selectedItems.intValue == index,
                        onClick = {
                            selectedItems.intValue = index
                            scope.launch { drawerState.close() }
                        })
                }
            }
        },
        content = {
            if (selectedItems.intValue == 0) {
                // Page 1
            } else {
                // Page 2
            }
        }
    )

    val activity = (LocalContext.current as Activity)

    BackHandler(onBack = {
        if (drawerState.isOpen) {
            scope.launch { drawerState.close() }
        } else {
            activity.finish()
        }
    }
    )

}