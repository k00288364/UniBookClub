package com.example.unibookclub2.navigation

sealed class Screen(
    val route: String
) {
    object Home : Screen("home")
    object MeetUps : Screen("meetUps")
    object Poll : Screen("polling")


}

val screens = listOf(
    Screen.Home,
    Screen.MeetUps,
    Screen.Poll
)