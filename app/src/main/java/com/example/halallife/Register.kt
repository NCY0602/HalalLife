package com.example.halallife

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import android.util.Patterns

@Composable
fun RegisterScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    // Validations
    val isUsernameValid = username.isNotEmpty()
    val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    val isPasswordValid = password.length >= 6
    val isConfirmPasswordValid = password == confirmPassword

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE3FFF3))  // Light green background (#E3FFF3)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        // Logo
        Image(
            painter = painterResource(id = R.drawable.halal),
            contentDescription = "Logo",
            modifier = Modifier.size(150.dp)
        )

        Text(
            text = "HalalLife",
            fontSize = 24.sp,
            color = Color(0xFF009688),
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Text(
            text = "Create an account",
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Username Input Field
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),  // White background for the input fields
            isError = !isUsernameValid
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Email Input Field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),  // White background for the input fields
            isError = !isEmailValid
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Password Input Field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),  // White background for the input fields
            isError = !isPasswordValid
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Confirm Password Input Field
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),  // White background for the input fields
            isError = !isConfirmPasswordValid
        )

        Spacer(modifier = Modifier.height(8.dp))

        Column(modifier = Modifier.align(Alignment.Start)) {
            Text("• At least 6 characters long.", fontSize = 12.sp, color = Color(0xFF80C7AA))  // Light green color
            Text("• Contain both uppercase and lowercase.", fontSize = 12.sp, color = Color(0xFF80C7AA))
            Text("• At least one number or special characters.", fontSize = 12.sp, color = Color(0xFF80C7AA))
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Sign Up Button
        Button(
            onClick = {
                if (isUsernameValid && isEmailValid && isPasswordValid && isConfirmPasswordValid) {
                    // Handle sign-up logic here (e.g., save user data)
                    navController.navigate("home")
                } else {
                    Toast.makeText(navController.context, "Please fill in all fields correctly", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0E5A49))  // Dark green color
        ) {
            Text("Sign up", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sign In Link
        TextButton(onClick = { navController.navigate("login") }) {
            Text(
                "Already have an account? Sign in",
                color = Color(0xFF00C5C1),  // Light teal color
                textAlign = TextAlign.Center
            )
        }
    }
}
