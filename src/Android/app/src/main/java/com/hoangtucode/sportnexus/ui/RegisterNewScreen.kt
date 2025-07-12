package com.hoangtucode.sportnexus.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hoangtucode.sportnexus.presentation.theme.NexusOrange
import kotlinx.coroutines.delay
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.foundation.text.ClickableText

@Composable
fun RegisterNewScreen(
    modifier: Modifier = Modifier,
    onBackToWelcome: () -> Unit = {}
) {
    var step by remember { mutableStateOf(0) } // 0: phone, 1: code, 2: form
    var phone by remember { mutableStateOf("") }
    var phoneError by remember { mutableStateOf<String?>(null) }
    var sendingCode by remember { mutableStateOf(false) }
    var code by remember { mutableStateOf("") }
    var codeError by remember { mutableStateOf<String?>(null) }
    var verifyingCode by remember { mutableStateOf(false) }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var formError by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }
    var submitting by remember { mutableStateOf(false) }

    // State triggers for async actions
    var shouldSendCode by remember { mutableStateOf(false) }
    var shouldVerifyCode by remember { mutableStateOf(false) }
    var shouldSubmitForm by remember { mutableStateOf(false) }

    var userType by remember { mutableStateOf("") } // "player" or "owner"
    var policyChecked by remember { mutableStateOf(false) }

    fun validatePhone(): Boolean {
        phoneError = when {
            phone.isBlank() -> "Phone number required"
            !phone.all { it.isDigit() } || phone.length !in 7..15 -> "Invalid phone number"
            else -> null
        }
        return phoneError == null
    }

    fun validateCode(): Boolean {
        codeError = when {
            code.isBlank() -> "Code required"
            code.length != 6 -> "Code must be 6 digits"
            !code.all { it.isDigit() } -> "Invalid code"
            else -> null
        }
        return codeError == null
    }

    fun validateForm(): Boolean {
        formError = when {
            userType.isBlank() -> "Please select your role"
            firstName.isBlank() -> "First name required"
            lastName.isBlank() -> "Last name required"
            dob.isBlank() -> "Date of birth required"
            !dob.matches(Regex("""^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\d{4}$""")) -> "Date of birth must be DD/MM/YYYY"
            email.isBlank() -> "Email required"
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Invalid email"
            password.length < 8 -> "Password must be at least 8 characters"
            password != confirmPassword -> "Passwords do not match"
            else -> ""
        }
        return formError.isBlank()
    }

    // Async effects
    if (shouldSendCode) {
        LaunchedEffect(shouldSendCode) {
            sendingCode = true
            // Simulate backend call
            kotlinx.coroutines.delay(1200)
            sendingCode = false
            step = 1
            shouldSendCode = false
        }
    }
    if (shouldVerifyCode) {
        LaunchedEffect(shouldVerifyCode) {
            verifyingCode = true
            // Simulate backend verification
            kotlinx.coroutines.delay(1000)
            verifyingCode = false
            step = 2
            shouldVerifyCode = false
        }
    }
    if (shouldSubmitForm) {
        LaunchedEffect(shouldSubmitForm) {
            submitting = true
            // Simulate registration
            kotlinx.coroutines.delay(1200)
            submitting = false
            shouldSubmitForm = false
            // Registration complete, go back to welcome
            onBackToWelcome()
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(NexusOrange)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.Start // Match LoginPage
        ) {
            // Top bar (Back button like LoginPage)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    if (step == 0) onBackToWelcome() else step--
                }
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
            // Title and subtitle (like LoginPage)
            Text(
                text = when (step) {
                    1 -> "Verify phone number"
                    else -> "Create your account!"
                },
                fontWeight = FontWeight.Black,
                fontSize = 26.sp,
                color = Color.Black
            )
            Text(
                text = when (step) {
                    1 -> "Enter the code sent to your phone."
                    else -> "We're so excited to have you join us!"
                },
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                color = Color(0xFF444444),
                modifier = Modifier.padding(bottom = 24.dp)
            )
            // Section label
            Text(
                text = "ACCOUNT INFORMATION",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                color = Color(0xFF444444),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            when (step) {
                0 -> {
                    // Country code and phone input row
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Country code selector (static for now)
                        Text(
                            text = "VN +84",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Box(
                            modifier = Modifier
                                .height(40.dp)
                                .width(1.dp)
                                .background(Color(0xFFB0B0B0))
                        )
                        OutlinedTextField(
                            value = phone,
                            onValueChange = { phone = it; phoneError = null },
                            placeholder = { Text("Phone number", color = Color(0xFFB0B0B0)) },
                            singleLine = true,
                            shape = RoundedCornerShape(0.dp),
                            isError = phoneError != null,
                            keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(keyboardType = KeyboardType.Phone),
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                errorIndicatorColor = Color.Red,
                                cursorColor = Color.Black,
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent
                            ),
                            textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 8.dp)
                                .height(40.dp)
                        )
                    }
                    Divider(
                        color = Color.White,
                        thickness = 1.dp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    // Agreement checkbox and text
                    Row(
                        verticalAlignment = Alignment.Top,
                        modifier = Modifier.padding(bottom = 24.dp)
                    ) {
                        Checkbox(
                            checked = policyChecked,
                            onCheckedChange = { policyChecked = it },
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color.Black,
                                uncheckedColor = Color.Black,
                                checkmarkColor = Color.White
                            ),
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(Modifier.width(8.dp))
                        val annotatedString = buildAnnotatedString {
                            append("Agree to SportNexus’s ")
                            pushStringAnnotation(tag = "TOS", annotation = "tos")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, textDecoration = TextDecoration.Underline, color = Color.Black)) {
                                append("Terms of Service")
                            }
                            pop()
                            append(" and confirm that you have read ")
                            pushStringAnnotation(tag = "PRIVACY", annotation = "privacy")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, textDecoration = TextDecoration.Underline, color = Color.Black)) {
                                append("SportNexus’s Privacy Policy")
                            }
                            pop()
                            append(". If you sign up SMS, SMS fees may apply.")
                        }
                        ClickableText(
                            text = annotatedString,
                            style = TextStyle(fontSize = 14.sp, color = Color.Black),
                            onClick = { offset ->
                                annotatedString.getStringAnnotations(tag = "TOS", start = offset, end = offset)
                                    .firstOrNull()?.let { /* Show TOS dialog */ }
                                annotatedString.getStringAnnotations(tag = "PRIVACY", start = offset, end = offset)
                                    .firstOrNull()?.let { /* Show Privacy dialog */ }
                            },
                            modifier = Modifier.weight(1f)
                        )
                    }
                    // Send code button
                    Button(
                        onClick = {
                            if (validatePhone()) {
                                shouldSendCode = true
                            }
                        },
                        enabled = !sendingCode && phoneError == null && phone.isNotBlank() && policyChecked,
                        shape = RoundedCornerShape(6.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (!policyChecked || phoneError != null || phone.isBlank()) Color(0xFFF5F5F5) else Color.Black,
                            contentColor = if (!policyChecked || phoneError != null || phone.isBlank()) Color(0xFFB0B0B0) else Color.White,
                            disabledContainerColor = Color(0xFFF5F5F5),
                            disabledContentColor = Color(0xFFB0B0B0)
                        ),
                        modifier = Modifier.fillMaxWidth().height(44.dp)
                    ) {
                        if (sendingCode) {
                            CircularProgressIndicator(color = Color.White, modifier = Modifier.size(22.dp), strokeWidth = 2.dp)
                        } else {
                            Text("Send code", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        }
                    }
                }
                1 -> {
                    OutlinedTextField(
                        value = code,
                        onValueChange = { code = it; codeError = null },
                        label = { Text("Verification Code", color = Color(0xFFB0B0B0)) },
                        singleLine = true,
                        shape = RoundedCornerShape(8.dp),
                        isError = codeError != null,
                        keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(keyboardType = KeyboardType.Number),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            errorIndicatorColor = Color.Red,
                            cursorColor = Color.Black,
                            focusedContainerColor = Color(0xFFF5F5F5),
                            unfocusedContainerColor = Color(0xFFF5F5F5)
                        ),
                        textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp)
                    )
                    if (codeError != null) {
                        Text(codeError!!, color = Color.Red, fontSize = 13.sp, modifier = Modifier.align(Alignment.Start))
                    }
                    Spacer(Modifier.height(24.dp))
                    Button(
                        onClick = {
                            if (validateCode()) {
                                shouldVerifyCode = true
                            }
                        },
                        enabled = !verifyingCode,
                        shape = RoundedCornerShape(6.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Black, contentColor = Color.White),
                        modifier = Modifier.fillMaxWidth().height(44.dp)
                    ) {
                        if (verifyingCode) {
                            CircularProgressIndicator(color = Color.White, modifier = Modifier.size(22.dp), strokeWidth = 2.dp)
                        } else {
                            Text("Verify", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        }
                    }
                }
                2 -> {
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        // User type choice
                        Text("I am a...", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = Color.Black, modifier = Modifier.align(Alignment.Start))
                        Spacer(Modifier.height(8.dp))
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                            val selectedColor = Color(0xFF0B1A2F)
                            val unselectedColor = Color(0xFFF5F5F5)
                            val selectedText = Color.White
                            val unselectedText = Color.Black
                            Button(
                                onClick = { userType = "player" },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (userType == "player") selectedColor else unselectedColor,
                                    contentColor = if (userType == "player") selectedText else unselectedText
                                ),
                                shape = RoundedCornerShape(20.dp),
                                border = null,
                                modifier = Modifier.weight(1f).height(40.dp)
                            ) {
                                Text("Player", fontWeight = FontWeight.Bold)
                            }
                            Button(
                                onClick = { userType = "owner" },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (userType == "owner") selectedColor else unselectedColor,
                                    contentColor = if (userType == "owner") selectedText else unselectedText
                                ),
                                shape = RoundedCornerShape(20.dp),
                                border = null,
                                modifier = Modifier.weight(1f).height(40.dp)
                            ) {
                                Text("Court Owner", fontWeight = FontWeight.Bold)
                            }
                        }
                        Spacer(Modifier.height(18.dp))
                        OutlinedTextField(
                            value = firstName,
                            onValueChange = { firstName = it },
                            label = { Text("First Name", color = Color(0xFFB0B0B0)) },
                            singleLine = true,
                            shape = RoundedCornerShape(8.dp),
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                cursorColor = Color.Black,
                                focusedContainerColor = Color(0xFFF5F5F5),
                                unfocusedContainerColor = Color(0xFFF5F5F5)
                            ),
                            textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                            modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp).height(54.dp)
                        )
                        OutlinedTextField(
                            value = lastName,
                            onValueChange = { lastName = it },
                            label = { Text("Last Name", color = Color(0xFFB0B0B0)) },
                            singleLine = true,
                            shape = RoundedCornerShape(8.dp),
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                cursorColor = Color.Black,
                                focusedContainerColor = Color(0xFFF5F5F5),
                                unfocusedContainerColor = Color(0xFFF5F5F5)
                            ),
                            textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                            modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp).height(54.dp)
                        )
                        OutlinedTextField(
                            value = dob,
                            onValueChange = { dob = it },
                            label = { Text("Date of Birth (DD/MM/YYYY)", color = Color(0xFFB0B0B0)) },
                            singleLine = true,
                            shape = RoundedCornerShape(8.dp),
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                cursorColor = Color.Black,
                                focusedContainerColor = Color(0xFFF5F5F5),
                                unfocusedContainerColor = Color(0xFFF5F5F5)
                            ),
                            textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                            modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp).height(54.dp)
                        )
                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            label = { Text("Email", color = Color(0xFFB0B0B0)) },
                            singleLine = true,
                            shape = RoundedCornerShape(8.dp),
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                cursorColor = Color.Black,
                                focusedContainerColor = Color(0xFFF5F5F5),
                                unfocusedContainerColor = Color(0xFFF5F5F5)
                            ),
                            textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                            modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp).height(54.dp)
                        )
                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            label = { Text("Password", color = Color(0xFFB0B0B0)) },
                            singleLine = true,
                            shape = RoundedCornerShape(8.dp),
                            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            trailingIcon = {
                                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                    Icon(
                                        imageVector = if (passwordVisible) androidx.compose.material.icons.Icons.Filled.Visibility else androidx.compose.material.icons.Icons.Filled.VisibilityOff,
                                        contentDescription = if (passwordVisible) "Hide password" else "Show password",
                                        tint = Color(0xFF444444)
                                    )
                                }
                            },
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                cursorColor = Color.Black,
                                focusedContainerColor = Color(0xFFF5F5F5),
                                unfocusedContainerColor = Color(0xFFF5F5F5)
                            ),
                            textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                            modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp).height(54.dp)
                        )
                        OutlinedTextField(
                            value = confirmPassword,
                            onValueChange = { confirmPassword = it },
                            label = { Text("Confirm Password", color = Color(0xFFB0B0B0)) },
                            singleLine = true,
                            shape = RoundedCornerShape(8.dp),
                            visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            trailingIcon = {
                                IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                                    Icon(
                                        imageVector = if (confirmPasswordVisible) androidx.compose.material.icons.Icons.Filled.Visibility else androidx.compose.material.icons.Icons.Filled.VisibilityOff,
                                        contentDescription = if (confirmPasswordVisible) "Hide password" else "Show password",
                                        tint = Color(0xFF444444)
                                    )
                                }
                            },
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                cursorColor = Color.Black,
                                focusedContainerColor = Color(0xFFF5F5F5),
                                unfocusedContainerColor = Color(0xFFF5F5F5)
                            ),
                            textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                            modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp).height(54.dp)
                        )
                        if (formError.isNotBlank()) {
                            Text(formError, color = Color.Red, fontSize = 13.sp, modifier = Modifier.align(Alignment.Start))
                        }
                        Spacer(Modifier.height(18.dp))
                        Button(
                            onClick = {
                                if (validateForm()) {
                                    shouldSubmitForm = true
                                }
                            },
                            enabled = !submitting,
                            shape = RoundedCornerShape(6.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0B1A2F), contentColor = Color.White),
                            modifier = Modifier.fillMaxWidth().height(44.dp)
                        ) {
                            if (submitting) {
                                CircularProgressIndicator(color = Color.White, modifier = Modifier.size(22.dp), strokeWidth = 2.dp)
                            } else {
                                Text("Register", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                            }
                        }
                    }
                }
            }
        }
    }
} 