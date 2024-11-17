package com.example.unibookclub.screen

import androidx.navigation.NavHostController

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.unibookclub.ui.theme.UniBookClubTheme
import androidx.compose.material3.Text

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Introduction To Jetpack Compose")
        Spacer(modifier = Modifier.height(20.dp))
        Text("Jetpack Compose is Android's modern UI toolkit, simplifying interface development with a " +
                "declarative approach. It allows developers to build responsive, " +
                "customizable UIs using Kotlin code, streamlining updates and enhancing " +
                "flexibility compared to traditional XML-based layouts.")
        Button(onClick = { navController.navigate("profile") }) {
            Text("Composable Functions")
        }
        Button(onClick = { navController.navigate("profile") }) {
            Text("State In Compose")
        }
        Button(onClick = { navController.navigate("profile") }) {
            Text("Navigation in Compose")
        }

    }
}
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    UniBookClubTheme {
        HomeScreen(navController = rememberNavController())  // Sample preview with mock navController
    }
}
