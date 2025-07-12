package com.hoangtucode.sportnexus.activities.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hoangtucode.sportnexus.R

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    onRegisterClick: () -> Unit = {},
    onLoginClick: () -> Unit = {},
    onClose: (() -> Unit)? = null,
) {
    Box(modifier = modifier.fillMaxSize().background(Color(0xFFED8A43))) {
        // Top bar: close icon (left)
        Row(
            Modifier.fillMaxWidth().padding(top = 16.dp, start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
        ) {
            IconButton(onClick = { onClose?.invoke() }) {
                Text("✕", fontSize = 20.sp, color = Color.White)
            }
            Spacer(Modifier.width(24.dp)) // No right icon
        }
        // Main content
        Column(
            Modifier.fillMaxSize().padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ) {
            Spacer(Modifier.height(32.dp))
            // Logo and title
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.sportnexus_logo),
                    contentDescription = "Sport Nexus Logo",
                    modifier = Modifier.size(56.dp),
                )
                Spacer(Modifier.width(8.dp))
                Column {
                    Text(
                        text = "Sport",
                        fontWeight = FontWeight.Black,
                        fontSize = 28.sp,
                        color = Color.Black,
                        letterSpacing = 1.sp,
                    )
                    Text(
                        text = "Nexus",
                        fontWeight = FontWeight.Black,
                        fontSize = 28.sp,
                        color = Color.Black,
                        letterSpacing = 1.sp,
                    )
                }
            }
            Spacer(Modifier.height(24.dp))
            // Illustrations
            Image(
                painter = painterResource(id = R.drawable.welcome_badminton),
                contentDescription = "Badminton Illustration",
                modifier = Modifier.height(100.dp),
            )
            Spacer(Modifier.height(12.dp))
            Image(
                painter = painterResource(id = R.drawable.welcome_basketball),
                contentDescription = "Basketball Illustration",
                modifier = Modifier.height(100.dp),
            )
            Spacer(Modifier.height(12.dp))
            Image(
                painter = painterResource(id = R.drawable.welcome_football),
                contentDescription = "Football Illustration",
                modifier = Modifier.height(100.dp),
            )
            Spacer(Modifier.height(24.dp))
            // Welcome text
            Text(
                text = "Welcome to Sport Nexus",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 4.dp),
            )
            Text(
                text =
                    "A platform enabling users to reserve available\nsports courts directly from facility owners",
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 24.dp),
            )
            // Register button
            Button(
                onClick = onRegisterClick,
                shape = RoundedCornerShape(6.dp),
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF181C23),
                        contentColor = Color.White,
                    ),
                modifier = Modifier.fillMaxWidth().height(44.dp),
            ) {
                Text("Register", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
            Spacer(Modifier.height(12.dp))
            // Log in button
            Button(
                onClick = onLoginClick,
                shape = RoundedCornerShape(6.dp),
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFB0B0B0),
                        contentColor = Color.Black,
                    ),
                modifier = Modifier.fillMaxWidth().height(44.dp),
            ) {
                Text("Log in", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
        }
    }
}
