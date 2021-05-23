package cc.mightyapp.mighty.ui.onboarding.login.email

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import cc.mightyapp.mighty.data.io.input.LogInWithEmailInput
import cc.mightyapp.mighty.ui.main.launchMainActivity

@Composable
fun LogInWithEmailContent(
    onLogIn: () -> Unit
) {

    val viewModel: LogInWithEmailViewModel = viewModel()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val state: LogInWithEmailViewState by viewModel.state.collectAsState()

    if (state.isLoggedIn) {
        launchMainActivity(
            context = LocalContext.current,
            userId = state.user.id,
            token = state.token
        )
        onLogIn()
    }

    Column {

        Row {
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") }
            )
        }

        Row {
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") }
            )
        }

        Row {
            TextButton(onClick = {
                viewModel.logInWithEmail(
                    LogInWithEmailInput(
                        email,
                        password
                    )
                )
            }) {
                Text(text = "Log In")
            }
        }

    }
}