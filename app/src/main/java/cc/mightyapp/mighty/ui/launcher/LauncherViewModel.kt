package cc.mightyapp.mighty.ui.launcher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cc.mightyapp.mighty.domain.launcher.ReadTokenUseCase
import cc.mightyapp.mighty.domain.launcher.ReadUserIdUseCase
import cc.mightyapp.mighty.domain.launcher.ValidateTokenUseCase
import cc.mightyapp.mighty.domain.result.data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
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
        loadDataStore()
    }

    private fun setState(userId: String, token: String, launchDestination: LaunchDestination) {
        _state.value = LauncherViewState(
            userId = userId,
            token = token,
            launchDestination = launchDestination
        )
    }

    private fun loadDataStore() {
        viewModelScope.launch {
            combine(
                readUserIdUseCase(Unit),
                readTokenUseCase(Unit)
            ) { userId, token ->

                if (!userId.data.isNullOrBlank() && !token.data.isNullOrBlank()) {
                    val isValid = validateToken(token.data!!)

                    if (isValid) {
                        setState(
                            userId = userId.data!!,
                            token = token.data!!,
                            launchDestination = LaunchDestination.MAIN
                        )
                    }

                }
            }
        }
    }

    fun validateToken(token: String): Boolean {
        var isValid = false

        viewModelScope.launch {
            isValid = validateTokenUseCase(token).data!!
        }

        return isValid
    }
}