package cc.mightyapp.mighty.onboarding.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import cc.mightyapp.mighty.onboarding.ui.login.composables.LogInWithEmailContent
import cc.mightyapp.mighty.onboarding.ui.login.presenter.LogInWithEmailViewModel

@Composable
fun OnboardingContent(onLogIn: () -> Unit) {
    val logInWithEmailViewModel: LogInWithEmailViewModel = viewModel()


    Box {
        LogInWithEmailContent(onLogIn = onLogIn, viewModel = logInWithEmailViewModel)
    }
}