package cc.mightyapp.mighty.ui.onboarding.login.email

data class LogInWithEmailViewState(
    val userId: String = "",
    val token: String = "",
    val isLoggedIn: Boolean = false
)