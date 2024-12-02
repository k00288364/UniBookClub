package com.example.unibookclub2.components


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.unibookclub2.R
import com.example.unibookclub2.navigation.Screen
import com.example.unibookclub2.navigation.screens




@Composable
fun MainPageNavigationBar(
    navController: NavHostController
) {
    val icons = mapOf(
        Screen.Home to IconGroup(
            filledIcon = Icons.Filled.Home,
            outlineIcon = Icons.Outlined.Home,
            label = stringResource(id = R.string.home)
        ),
        Screen.MeetUps to IconGroup(
            filledIcon = Icons.Filled.DateRange,
            outlineIcon = Icons.Outlined.DateRange,
            label = stringResource(id = R.string.meetUps)
        ),
        Screen.Poll to IconGroup(
            filledIcon = Icons.Filled.List,
            outlineIcon = Icons.Outlined.List,
            label = stringResource(id = R.string.poll)
         )
    )

    NavigationBar {
        val navBackStackEntry by
        navController.currentBackStackEntryAsState()
        val currentDestination =
            navBackStackEntry?.destination
        screens.forEach { screen ->
            val isSelected = currentDestination?.route == screen.route
            val labelText = icons[screen]!!.label

            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = (
                                if (isSelected)
                                    icons[screen]!!.filledIcon
                                else
                                    icons[screen]!!.outlineIcon),
                        contentDescription = labelText
                    )
                },
                label = { Text(labelText) },
                selected = isSelected,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true // Save state of all destinations popped off stack
                            //inclusive = true // This would also remove Home from stack if navigating to Cats
                        }
                        // launchSingleTop: Navigate to the "search” destination only if we’re not already on
                        // the "search" destination, avoiding multiple copies on the top of the
                        // back stack
                        launchSingleTop = true
                        // If there was state previously saved for this destination
                        // when it was popped we can now get it back
                        restoreState = true
                    }
                }
            )
        }
    }
}