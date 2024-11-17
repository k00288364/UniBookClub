package com.example.unibookclub.navigation


import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.unibookclub.screen.HomeScreen
import com.example.unibookclub.screen.LoginScreen
import com.example.unibookclub.screen.RegisterScreen
import com.example.unibookclub.screen.EventsScreen
import com.example.unibookclub.screen.PollScreen

@Composable
fun NavigationGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("events") { EventsScreen(navController) }
        composable("poll") { PollScreen(navController) }

    }
}
