package cc.mightyapp.mighty.ui.onboarding.login.email

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import cc.mightyapp.mighty.data.io.input.LogInWithEmailInput

@Composable
fun LogInWithEmailContent() {

    val viewModel: LogInWithEmailViewModel = viewModel()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val state: LogInWithEmailViewState by viewModel.state.collectAsState()


    Box() {

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") }
        )

        TextButton(onClick = { viewModel.logInWithEmail(LogInWithEmailInput(email, password)) }) {
            Text(text = "Log In")
        }

    }
}