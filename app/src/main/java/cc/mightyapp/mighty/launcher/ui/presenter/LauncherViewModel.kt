package cc.mightyapp.mighty.launcher.ui.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cc.mightyapp.mighty.common.data.entities.RequestResult
import cc.mightyapp.mighty.launcher.data.domain.ReadTokenUseCase
import cc.mightyapp.mighty.launcher.data.domain.ReadUserIdUseCase
import cc.mightyapp.mighty.launcher.data.entities.LaunchDestination
import cc.mightyapp.mighty.launcher.data.interactor.RealLauncherInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LauncherViewModel @Inject constructor(
    private val interactor: RealLauncherInteractor,
    private val readUserIdUseCase: ReadUserIdUseCase,
    private val readTokenUseCase: ReadTokenUseCase,
) : ViewModel() {

    val hasError = MutableStateFlow(false)
    val isDoneLoading = MutableStateFlow(false)

    private val _state = MutableStateFlow(LauncherViewState())
    val state: StateFlow<LauncherViewState>
        get() = _state

    private val _destination = MutableStateFlow(LaunchDestination.MAIN)
    val destination: StateFlow<LaunchDestination>
        get() = _destination

    init {
        loadState()
    }

    private fun loadState() {
        viewModelScope.launch {
            combine(
                readUserIdUseCase(Unit),
                readTokenUseCase(Unit)
            ) { userId, token ->
                LauncherViewState(
                    userId = if (userId is RequestResult.Success) userId.payload else "",
                    token = if (token is RequestResult.Success) token.payload else ""
                )
            }.catch { e ->
                Timber.d(e)
                hasError.value = true
            }.collect {
                _state.value = it
                _destination.value = LaunchDestination.MAIN
                isDoneLoading.value = true
            }

        }
    }

    fun loadDestination() {

        _destination.value = LaunchDestination.MAIN
//        if (token.isNullOrEmpty()) _destination.value = LaunchDestination.ONBOARDING
//
//        else {
//            viewModelScope.launch {
//                val isValid = validateTokenUseCase(ValidateTokenInput(token))
//
//                Do exhaustive when(isValid) {
//                    is RequestResult.Success -> _destination.value = LaunchDestination.MAIN
//                    else -> _destination.value = LaunchDestination.ONBOARDING
//                }
//            }
//        }
    }

    private fun getUserIdAsync(): Deferred<String> {
        return viewModelScope.async { interactor.getUserId() }
    }

    private fun getTokenAsync(): Deferred<String> {
        return viewModelScope.async { interactor.getToken() }
    }

    private fun setState(nextState: LauncherViewState) {
        _state.value = nextState
    }

    private fun setDestination(nextDestination: LaunchDestination) {
        _destination.value = nextDestination
    }


}