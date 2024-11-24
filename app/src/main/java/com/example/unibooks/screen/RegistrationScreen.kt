package com.example.unibooks.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.unibooks.components.Header
import com.example.unibooks.components.Footer
import com.example.unibooks.components.RegistrationForm

@Composable
fun RegistrationScreen(navController: NavHostController) {
    // Declare state for the registration form fields
    var name by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var agreeToTerms by remember { mutableStateOf(false) }

    // Form submission handler
    fun onSubmit() {
        // Validate the fields
        if (name.isNotBlank() && location.isNotBlank() && email.isNotBlank() && password == confirmPassword && agreeToTerms) {
            // Call your registration logic or API here
            navController.navigate("Home")  // Navigate to Home after successful registration
        } else {
            // Handle validation errors (e.g., show a Snackbar or Toast)
            // Example: showError("Please fill in all fields correctly.")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Header() // Header component
        JoinClubContent(
            name = name,
            location = location,
            email = email,
            password = password,
            confirmPassword = confirmPassword,
            agreeToTerms = agreeToTerms,
            onNameChange = { name = it },
            onLocationChange = { location = it },
            onEmailChange = { email = it },
            onPasswordChange = { password = it },
            onConfirmPasswordChange = { confirmPassword = it },
            onAgreeToTermsChange = { agreeToTerms = it },
            onSubmit = onSubmit
        )
        Footer() // Footer component
    }
}

@Composable
fun JoinClubContent(
    name: String,
    location: String,
    email: String,
    password: String,
    confirmPassword: String,
    agreeToTerms: Boolean,
    onNameChange: (String) -> Unit,
    onLocationChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onAgreeToTermsChange: (Boolean) -> Unit,
    onSubmit: () -> Unit // Submit function passed as a parameter
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title/Heading
        Text(
            text = "Join The Club!",
            fontSize = 63.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        // Pass down the form state and onSubmit function to the RegistrationForm
        RegistrationForm(
            name = name,
            location = location,
            email = email,
            password = password,
            confirmPassword = confirmPassword,
            agreeToTerms = agreeToTerms,
            onNameChange = onNameChange,
            onLocationChange = onLocationChange,
            onEmailChange = onEmailChange,
            onPasswordChange = onPasswordChange,
            onConfirmPasswordChange = onConfirmPasswordChange,
            onAgreeToTermsChange = onAgreeToTermsChange,
            onSubmit = onSubmit // Function for form submission
        )
    }
}
