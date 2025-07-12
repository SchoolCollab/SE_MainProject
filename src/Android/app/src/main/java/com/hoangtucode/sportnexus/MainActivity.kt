package com.hoangtucode.sportnexus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.hoangtucode.sportnexus.activities.auth.login.LoginScreen
import com.hoangtucode.sportnexus.activities.auth.register.RegisterScreen
import com.hoangtucode.sportnexus.activities.welcome.WelcomeScreen
import com.hoangtucode.sportnexus.presentation.theme.SportNexusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SportNexusTheme {
                var showLogin by remember { mutableStateOf(false) }
                var showRegister by remember { mutableStateOf(false) }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    when {
                        showLogin -> {
                            LoginScreen(
                                modifier = Modifier.padding(innerPadding),
                                onBack = { showLogin = false },
                                onLogin = { emailOrPhone, password -> /* handle login */ },
                                onForgotPassword = { /* handle forgot password */ },
                            )
                        }
                        showRegister -> {
                            RegisterScreen(
                                modifier = Modifier.padding(innerPadding),
                                onBackToWelcome = { showRegister = false },
                            )
                        }
                        else -> {
                            WelcomeScreen(
                                modifier = Modifier.padding(innerPadding),
                                onRegisterClick = { showRegister = true },
                                onLoginClick = { showLogin = true },
                            )
                        }
                    }
                }
            }
        }
    }
}
