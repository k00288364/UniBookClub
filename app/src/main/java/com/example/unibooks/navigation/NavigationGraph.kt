package com.example.unibooks.navigation

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.unibooks.HomeScreen
import com.example.unibooks.screen.LoginScreen
//import com.example.unibooks.screen.HomeScreen
import com.example.unibooks.screen.MeetUpsScreen
import com.example.unibooks.screen.PollingScreen
import com.example.unibooks.screen.RegistrationScreen


@Composable
fun NavigationGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("meetUps") { MeetUpsScreen(navController) }
        composable("polls") { PollingScreen(navController) }
        composable("registration") { RegistrationScreen(navController) }

    }
}