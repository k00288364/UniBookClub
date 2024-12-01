package com.example.unibookclub2.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.unibooks.components.Header
import com.example.unibooks.components.Footer
import kotlinx.coroutines.coroutineScope

@Composable
fun LoginScreen(navController: NavHostController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
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
            Header(drawerState = drawerState, coroutineScope = coroutineScope)
            LoginForm(navController = navController)
            Footer()
        }
    }
}

@Composable
fun LoginForm(navController: NavHostController) {
    // Add mutable state for the text fields
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var isLoading by remember { mutableStateOf(false) }

    // Validation logic for email and password
    fun validateCredentials(): Boolean {
        if (email.isBlank() || password.isBlank()) {
            errorMessage = "Email and Password cannot be empty"
            return false
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            errorMessage = "Please enter a valid email"
            return false
        }

        errorMessage = null // Clear the error message if credentials are valid
        return true
    }

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

        // Bind the email text field to the 'email' state
        OutlinedTextField(
            value = email,
            onValueChange = { email = it }, // Update the state when text changes
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .height(76.dp)
        )
        Spacer(modifier = Modifier.height(18.dp))

        // Bind the password text field to the 'password' state
        OutlinedTextField(
            value = password,
            onValueChange = { password = it }, // Update the state when text changes
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .height(76.dp),
            visualTransformation = PasswordVisualTransformation() // Optional, to hide the password
        )
        Spacer(modifier = Modifier.height(30.dp))

        // Show error message if validation fails
        if (errorMessage != null) {
            Text(
                text = errorMessage!!,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Login button
        Button(
            onClick = {
                isLoading = true
                if (validateCredentials()) {
                    // Simulate a login process (e.g., connect to your API or auth system)
                    // After success, navigate to the MeetUpsScreen
                    isLoading = false
                    navController.navigate("MeetUps") // Navigate to MeetUpsScreen
                } else {
                    isLoading = false
                }
            },
            enabled = !isLoading,
            modifier = Modifier
                .width(304.dp)
                .height(76.dp)
                .shadow(4.dp, RoundedCornerShape(10.dp))
        ) {
            Text(
                text = if (isLoading) "Logging in..." else "Login",
                color = Color.White,
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(14.dp))

        // Forgot password link
        Text(
            text = "Forgot Password?",
            fontSize = 13.sp,
            color = Color(0xFF107CFF),
            modifier = Modifier.clickable { }
        )
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    val navController = rememberNavController()
    LoginScreen(navController)
}