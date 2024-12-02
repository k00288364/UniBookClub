package com.example.unibookclub2.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.unibooks.components.Header
import com.example.unibooks.components.Footer
import com.example.unibooks.components.RegistrationForm
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.example.unibookclub2.model.Users


@Composable
fun RegistrationScreen(navController: NavHostController) {

    var name by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var agreeToTerms by remember { mutableStateOf(false) }

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    val context = LocalContext.current
    val auth = FirebaseAuth.getInstance()


    val database: DatabaseReference = FirebaseDatabase.getInstance().reference

    val onSubmit: () -> Unit = {

        if (name.isNotBlank() && location.isNotBlank() && email.isNotBlank() && password == confirmPassword && agreeToTerms) {

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val userId = auth.currentUser?.uid


                        if (userId != null) {
                            val user = Users(name, location, email, password, confirmPassword)
                            database.child("users").child(userId).setValue(user)
                                .addOnSuccessListener {

                                    navController.navigate("login")
                                }
                                .addOnFailureListener { e ->

                                    Toast.makeText(context, "Failed to save data: ${e.message}", Toast.LENGTH_SHORT).show()
                                }
                        }
                    } else {
                        Toast.makeText(context, "Registration failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            // Show validation error (Optional)
            Toast.makeText(context, "Please fill all fields correctly.", Toast.LENGTH_SHORT).show()
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item { Header(drawerState = drawerState, coroutineScope = coroutineScope) }
        item {
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
        }
        item { Footer() }
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
    onSubmit: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Join The Club!",
            fontSize = 43.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 20.dp)
        )

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
            onSubmit = onSubmit
        )
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewRegistrationScreen() {
    val navController = rememberNavController()
    RegistrationScreen(navController)
}