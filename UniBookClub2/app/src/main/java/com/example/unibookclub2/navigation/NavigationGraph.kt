package com.example.unibooks.navigation


import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.unibookclub2.HomeScreen
import com.example.unibookclub2.screen.LoginScreen
import com.example.unibookclub2.screen.MeetUpsScreen
import com.example.unibookclub2.screen.PollingScreen
import com.example.unibookclub2.screen.RegistrationScreen


@Composable
fun NavigationGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("meetUps") { MeetUpsScreen(navController) }
        composable("polling") { PollingScreen(navController) }
        composable("registration") { RegistrationScreen(navController) }

    }
}