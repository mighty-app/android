package cc.mightyapp.mighty.ui.onboarding.login.email

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cc.mightyapp.mighty.data.io.input.LogInWithEmailInput
import cc.mightyapp.mighty.domain.auth.LogInWithEmailUseCase
import cc.mightyapp.mighty.domain.result.data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogInWithEmailViewModel @Inject constructor(
    private val logInWithEmailUseCase: LogInWithEmailUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(LogInWithEmailViewState())
    val state: StateFlow<LogInWithEmailViewState>
        get() = _state

    private fun setState(userId: String, token: String, isLoggedIn: Boolean) {
        _state.value = LogInWithEmailViewState(userId, token, isLoggedIn)
    }

    fun logInWithEmail(input: LogInWithEmailInput) {
        viewModelScope.launch {
            val response = logInWithEmailUseCase(input)
            val data = response.data

            val userId: String = data!!.userId
            val token: String = data!!.token
            val isLoggedIn = true

            setState(
                userId = userId,
                token = token,
                isLoggedIn = isLoggedIn
            )
        }
    }
}