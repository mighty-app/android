package cc.mightyapp.mighty.ui.onboarding.login.email

import cc.mightyapp.mighty.data.models.User

data class LogInWithEmailViewState(
    val user: User = User(),
    val token: String = "",
    val isLoggedIn: Boolean = false
)