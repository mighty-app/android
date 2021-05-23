package cc.mightyapp.mighty.ui.onboarding

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import cc.mightyapp.mighty.ui.onboarding.login.email.LogInWithEmailContent

@Composable
fun OnboardingContent(onLogIn: () -> Unit) {
    val viewModel: OnboardingViewModel = viewModel()

    Box {
        LogInWithEmailContent(onLogIn)
    }
}