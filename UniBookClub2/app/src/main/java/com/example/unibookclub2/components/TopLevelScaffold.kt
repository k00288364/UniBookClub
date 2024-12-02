package com.example.unibookclub2.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
/**
 * Creates the page scaffold to contain top app bar, navigation drawer,
 * bottom navigation button, Floating Action Button, Snackbar and of course the page content.
 * @param navController To pass through the NavHostController since navigation is required
 * @param pageContent So that callers can plug in their own page content.
 * By default an empty lambda.

 */
@Composable
fun TopLevelScaffold(
    navController: NavHostController,
    coroutineScope: CoroutineScope,
    pageContent: @Composable (innerPadding: PaddingValues) -> Unit = {}
) {
    val drawerState =
        rememberDrawerState(initialValue = DrawerValue.Closed)

        Scaffold(

            bottomBar = {
                MainPageNavigationBar(navController)
            },
            content = { innerPadding -> pageContent(innerPadding) }
        )
    }
