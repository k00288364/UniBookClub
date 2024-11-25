package com.example.unibooks.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegistrationForm(
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
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FormField(label = "Name", value = name, onValueChange = onNameChange)
        FormField(label = "Location", value = location, onValueChange = onLocationChange)
        FormField(label = "Email Address", value = email, onValueChange = onEmailChange)
        FormField(label = "Password", value = password, onValueChange = onPasswordChange, isPassword = true)
        FormField(label = "Re-Type Password", value = confirmPassword, onValueChange = onConfirmPasswordChange, isPassword = true)

        Button(
            onClick = onSubmit,
            modifier = Modifier
                .padding(top = 20.dp)
                .width(304.dp)
                .height(54.dp)
                .shadow(4.dp, RoundedCornerShape(10.dp))
           // colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF09E832)) // Optional color
        ) {
            Text("Submit", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Checkbox(
                checked = agreeToTerms,
                onCheckedChange = onAgreeToTermsChange,
                colors = CheckboxDefaults.colors(checkedColor = Color(0xFF09E832))
            )
            Text(
                "I agree to the terms and conditions",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

// Reusable FormField for text inputs
@Composable
fun FormField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPassword: Boolean = false
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = if (isPassword) KeyboardType.Password else KeyboardType.Text)
        )
    }
}
