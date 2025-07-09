package com.example.halallife

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import android.util.Patterns
import androidx.compose.foundation.background
import androidx.navigation.NavController

@Composable
fun ForgotPasswordScreen(navController: NavController) {
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }

    val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE3FFF3))
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // App Logo
        Image(
            painter = painterResource(id = R.drawable.halal),
            contentDescription = "App Logo",
            modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // App Name Text
        Text(
            text = "HalalLife",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF00897B)
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Forgot Password Title
        Text(
            text = "Forgot Password",
            fontSize = 28.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Email Input Field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            singleLine = true,
            isError = !isEmailValid,
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF00C8A0),
                unfocusedBorderColor = Color.Gray,
                focusedLabelColor = Color(0xFF00C8A0),
                unfocusedLabelColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Reset Password Button
        Button(
            onClick = {
                if (isEmailValid) {
                    // Logic for password reset request
                    Toast.makeText(context, "Password reset link sent to $email", Toast.LENGTH_SHORT).show()
                    navController.navigate("login")  // Navigate back to login screen after sending the reset link
                } else {
                    Toast.makeText(context, "Please enter a valid email", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0E5A49),
                contentColor = Color.White
            ),
            enabled = isEmailValid
        ) {
            Text("Reset Password", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Back to Login Link
        Text(
            text = "Back to Login",
            color = Color(0xFF00C5C1),
            modifier = Modifier.clickable { navController.navigate("login") }
        )
    }
}
