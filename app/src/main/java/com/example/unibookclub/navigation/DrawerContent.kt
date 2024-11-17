package com.example.unibookclub.navigation


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*

import androidx.compose.runtime.rememberCoroutineScope

import kotlinx.coroutines.launch

import androidx.compose.material3.DrawerState
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController


@Composable
fun DrawerContent(navController: NavHostController, drawerState: DrawerState) {
    val coroutineScope = rememberCoroutineScope()

    Column {
        Text("Navigate to:")

        // Home item
        TextButton(onClick = {
            coroutineScope.launch {
                drawerState.close()  // Close the drawer first
                navController.navigate("home")  // Then navigate to home
            }
        }) {
            Text("Home")
        }

        // Profile item
        TextButton(onClick = {
            coroutineScope.launch {
                drawerState.close()  // Close the drawer first
                navController.navigate("login")  // Then navigate to profile
            }
        }) {
            Text("login")
        }

        // Settings item
        TextButton(onClick = {
            coroutineScope.launch {
                drawerState.close()  // Close the drawer first
                navController.navigate("register")  // Then navigate to settings
            }
        }) {
            Text("register")
        }

        // WidgetScreen item
        TextButton(onClick = {
            coroutineScope.launch {
                drawerState.close()  // Close the drawer first
                navController.navigate("events")  // Then navigate to settings
            }
        }) {
            Text("events")
        }

        TextButton(onClick = {
            coroutineScope.launch {
                drawerState.close()  // Close the drawer first
                navController.navigate("poll")  // Then navigate to settings
            }
        }) {
            Text("poll")
        }
    }
}

