package com.hoangtucode.sportnexus.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hoangtucode.sportnexus.presentation.theme.NexusOrange

@Composable
fun LoginPage(
    modifier: Modifier = Modifier,
    onBack: () -> Unit = {},
    onLogin: (String, String) -> Unit = { _, _ -> },
    onForgotPassword: () -> Unit = {}
) {
    var emailOrPhone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(NexusOrange)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.Start
        ) {
            // Top bar
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable { onBack() }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color(0xFF6D6D6D),
                    modifier = Modifier.size(22.dp)
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = "Back",
                    color = Color(0xFF6D6D6D),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(Modifier.height(32.dp))
            // Welcome text
            Text(
                text = "Welcome back!",
                fontWeight = FontWeight.Black,
                fontSize = 26.sp,
                color = Color.Black
            )
            Text(
                text = "We're so excited to see you again!",
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                color = Color(0xFF444444),
                modifier = Modifier.padding(bottom = 24.dp)
            )
            // Account info label
            Text(
                text = "ACCOUNT INFORMATION",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                color = Color(0xFF444444),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            // Email or phone field
            OutlinedTextField(
                value = emailOrPhone,
                onValueChange = { emailOrPhone = it },
                placeholder = { Text("Email or phone Number", color = Color(0xFFB0B0B0)) },
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    errorIndicatorColor = MaterialTheme.colorScheme.error,
                    cursorColor = Color.Black,
                    focusedContainerColor = Color(0xFFF5F5F5),
                    unfocusedContainerColor = Color(0xFFF5F5F5)
                ),
                textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
            )
            Spacer(Modifier.height(12.dp))
            // Password field
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Password", color = Color(0xFFB0B0B0)) },
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    errorIndicatorColor = MaterialTheme.colorScheme.error,
                    cursorColor = Color.Black,
                    focusedContainerColor = Color(0xFFF5F5F5),
                    unfocusedContainerColor = Color(0xFFF5F5F5)
                ),
                textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            contentDescription = if (passwordVisible) "Hide password" else "Show password",
                            tint = Color(0xFF444444)
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
            )
            Spacer(Modifier.height(6.dp))
            // Forgot password
            Text(
                text = "Forgot your password?",
                color = Color(0xFF181C23),
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                modifier = Modifier
                    .clickable { onForgotPassword() }
                    .padding(bottom = 18.dp)
            )
            // Login button
            Button(
                onClick = { onLogin(emailOrPhone, password) },
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF0B1A2F),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp)
            ) {
                Text("Login", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
        }
    }
} 