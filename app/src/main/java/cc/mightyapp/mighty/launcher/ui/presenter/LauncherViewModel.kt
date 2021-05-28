package cc.mightyapp.mighty.launcher.ui.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cc.mightyapp.mighty.common.data.entities.Result
import cc.mightyapp.mighty.common.data.entities.data
import cc.mightyapp.mighty.launcher.data.domain.ReadTokenUseCase
import cc.mightyapp.mighty.launcher.data.domain.ReadUserIdUseCase
import cc.mightyapp.mighty.launcher.data.domain.ValidateTokenUseCase
import cc.mightyapp.mighty.launcher.data.entities.LaunchDestination
import cc.mightyapp.mighty.launcher.data.entities.ValidateTokenInput
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LauncherViewModel @Inject constructor(
    private val readUserIdUseCase: ReadUserIdUseCase,
    private val readTokenUseCase: ReadTokenUseCase,
    private val validateTokenUseCase: ValidateTokenUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(LauncherViewState())
    val state: StateFlow<LauncherViewState>
        get() = _state

    init {
        loadState()
    }

    private fun setState(userId: String, token: String, launchDestination: LaunchDestination) {
        _state.value = LauncherViewState(
            userId = userId,
            token = token,
            launchDestination = launchDestination
        )
    }

    private fun updateUserId(userId: String) {
        _state.value = LauncherViewState(
            userId = userId,
            token = state.value.token,
            launchDestination = state.value.launchDestination
        )
    }

    private fun updateToken(token: String) {
        _state.value = LauncherViewState(
            userId = state.value.userId,
            token = token,
            launchDestination = state.value.launchDestination
        )
    }

    private fun loadState() {
        loadUserId()
        loadToken()
    }

    fun handleToken() {
        var isValid = false
        var isLoading = true

        viewModelScope.launch {
            isValid = validateToken(state.value.token)
            isLoading = false
        }

        if (isValid && !isLoading) {
            setState(
                userId = state.value.userId,
                token = state.value.token,
                launchDestination = LaunchDestination.MAIN
            )
        }
    }

    private fun loadUserId() {
        viewModelScope.launch {
            readUserIdUseCase(Unit).collect { it ->
                if (it is Result.Success) {
                    updateUserId(it.data)
                }
            }
        }
    }

    private fun loadToken() {
        viewModelScope.launch {
            readTokenUseCase(Unit).collect { it ->
                if (it is Result.Success) {
                    val isValid = validateToken(it.data)
                }
            }
        }
    }


    private fun validateToken(token: String): Boolean {
        var isValid = false

        viewModelScope.launch {
            val response = validateTokenUseCase(ValidateTokenInput(token = token))
            val data = response.data!!
            Timber.d("Token from server ${data.token}")
            Timber.d("Token from data store $token")
            isValid = data.token.isNotEmpty()
        }

        return isValid
    }
}