package com.hoangtucode.sportnexus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.TextStyle
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.ui.unit.dp
import com.hoangtucode.sportnexus.ui.WelcomePage
import com.hoangtucode.sportnexus.ui.LoginPage
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.hoangtucode.sportnexus.ui.RegisterNewScreen
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
                            LoginPage(
                                modifier = Modifier.padding(innerPadding),
                                onBack = { showLogin = false },
                                onLogin = { emailOrPhone, password -> /* handle login */ },
                                onForgotPassword = { /* handle forgot password */ }
                            )
                        }
                        showRegister -> {
                            RegisterNewScreen(
                                modifier = Modifier.padding(innerPadding),
                                onBackToWelcome = { showRegister = false }
                            )
                        }
                        else -> {
                            WelcomePage(
                                modifier = Modifier.padding(innerPadding),
                                onRegisterClick = {
                                    showRegister = true
                                },
                                onLoginClick = { showLogin = true }
                            )
                        }
                    }
                }
            }
        }
    }
}
