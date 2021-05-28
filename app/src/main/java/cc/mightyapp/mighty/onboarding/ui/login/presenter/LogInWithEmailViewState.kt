package cc.mightyapp.mighty.onboarding.ui.login.presenter

import cc.mightyapp.mighty.common.data.models.User

data class LogInWithEmailViewState(
    val user: User = User(),
    val token: String = "",
    val isLoggedIn: Boolean = false
)