package cc.mightyapp.mighty.onboarding.ui.login.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cc.mightyapp.mighty.common.util.Defaults
import cc.mightyapp.mighty.main.main.ui.view.launchMainActivity
import cc.mightyapp.mighty.onboarding.data.entities.LogInWithEmailInput
import cc.mightyapp.mighty.onboarding.ui.login.presenter.LogInWithEmailViewModel
import cc.mightyapp.mighty.onboarding.ui.login.presenter.LogInWithEmailViewState

@Composable
fun LogInWithEmailContent(
    onLogIn: () -> Unit,
    viewModel: LogInWithEmailViewModel
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val state: LogInWithEmailViewState by viewModel.state.collectAsState()

    if (state.isLoggedIn) {
        launchMainActivity(
            context = LocalContext.current,
            userId = state.user.id,
            token = state.token
        )
    }

    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize()
    ) {
        Column {

            val padding = 16.dp

            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding)
            )

            Spacer(Modifier.size(padding))

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding)
            )

            Spacer(Modifier.size(padding))

//            LogInButton(
//                onClick = {
//                    viewModel.logInWithEmail(
//                        LogInWithEmailInput(
//                            email,
//                            password
//                        )
//                    )
//                }
//            )
        }
    }
}


@Preview
@Composable
fun LogInButton(
    onClick: () -> Unit = Defaults.onClick
) {
    Button(
        onClick = onClick,
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = ButtonDefaults.elevation(5.dp),
    ) {
        Text(
            text = "Log In",
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}