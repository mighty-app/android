package cc.mightyapp.mighty.onboarding.ui.login.presenter

import androidx.lifecycle.ViewModel
import cc.mightyapp.mighty.common.data.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LogInWithEmailViewModel @Inject constructor(
) : ViewModel() {

    private val _state = MutableStateFlow(LogInWithEmailViewState())
    val state: StateFlow<LogInWithEmailViewState>
        get() = _state

    private fun setState(user: User, token: String, isLoggedIn: Boolean) {
        _state.value = LogInWithEmailViewState(user = user, token = token, isLoggedIn = isLoggedIn)
    }

//    fun logInWithEmail(input: LogInWithEmailInput) {
//        viewModelScope.launch {
//            val response = logInWithEmailUseCase(input)
//
//            if (response is RequestResult.Success)
//
//            val user = data.user
//            val token = data.token
//            val isLoggedIn = true
//
//            saveUserIdUseCase(user.id)
//            saveTokenUseCase(token)
//
//            setState(
//                user = user,
//                token = token,
//                isLoggedIn = isLoggedIn
//            )
//        }
//    }
}