package com.example.unibookclub.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.unibookclub.components.Header
import com.example.unibookclub.components.Footer

@Composable
fun LoginScreen(navController : NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
        ) {
            Header()
            LoginForm()
        }
        Footer(
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}


@Composable
fun LoginForm() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 45.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome Back!",
            fontSize = 63.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(71.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .height(76.dp)
        )
        Spacer(modifier = Modifier.height(18.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .height(76.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { },
            modifier = Modifier
                .width(304.dp)
                .height(76.dp)
                .shadow(4.dp, RoundedCornerShape(10.dp)),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF09E832))
        ) {
            Text(
                text = "Login",
                color = Color.White,
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = "Forgot Password?",
            fontSize = 13.sp,
            color = Color(0xFF107CFF),
            modifier = Modifier.clickable { }
        )
    }
}
