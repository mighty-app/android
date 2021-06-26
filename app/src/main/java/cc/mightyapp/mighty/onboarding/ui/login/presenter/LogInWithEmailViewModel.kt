package cc.mightyapp.mighty.onboarding.ui.login.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cc.mightyapp.mighty.common.data.entities.RequestResult
import cc.mightyapp.mighty.common.data.models.User
import cc.mightyapp.mighty.launcher.data.domain.SaveTokenUseCase
import cc.mightyapp.mighty.launcher.data.domain.SaveUserIdUseCase
import cc.mightyapp.mighty.onboarding.data.domain.LogInWithEmailUseCase
import cc.mightyapp.mighty.onboarding.data.entities.LogInWithEmailInput
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogInWithEmailViewModel @Inject constructor(
    private val logInWithEmailUseCase: LogInWithEmailUseCase,
    private val saveUserIdUseCase: SaveUserIdUseCase,
    private val saveTokenUseCase: SaveTokenUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(LogInWithEmailViewState())
    val state: StateFlow<LogInWithEmailViewState>
        get() = _state

    private fun setState(user: User, token: String, isLoggedIn: Boolean) {
        _state.value = LogInWithEmailViewState(user = user, token = token, isLoggedIn = isLoggedIn)
    }

    fun logInWithEmail(input: LogInWithEmailInput) {
        viewModelScope.launch {
            val response = logInWithEmailUseCase(input)

            if (response is RequestResult.Success) {
                val data = response.payload
                val user = data.user
                val token = data.token
                val isLoggedIn = true

                saveTokenUseCase(token)
                saveUserIdUseCase(user.id)

                setState(
                    user = user,
                    token = token,
                    isLoggedIn = isLoggedIn
                )
            }
        }
    }
}