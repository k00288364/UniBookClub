package com.example.unibooks.navigation


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

        TextButton(onClick = {
            coroutineScope.launch {
                drawerState.close()
                navController.navigate("home")
            }
        }) {
            Text("Home")
        }

        TextButton(onClick = {
            coroutineScope.launch {
                drawerState.close()
                navController.navigate("login")
            }
        }) {
            Text("Login")
        }

        TextButton(onClick = {
            coroutineScope.launch {
                drawerState.close()
                navController.navigate("registration")
            }
        }) {
            Text("Registration")
        }

        TextButton(onClick = {
            coroutineScope.launch {
                drawerState.close()
                navController.navigate("meetUps")
            }
        }) {
            Text("MeetUps")
        }

        TextButton(onClick = {
            coroutineScope.launch {
                drawerState.close()  // Close the drawer first
                navController.navigate("polling")
            }
        }) {
            Text("Poll")
        }
    }
}