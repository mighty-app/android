package cc.mightyapp.mighty.main.main.ui.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cc.mightyapp.mighty.common.data.entities.RequestResult
import cc.mightyapp.mighty.common.data.models.Level
import cc.mightyapp.mighty.common.data.models.Routine
import cc.mightyapp.mighty.common.data.models.User
import cc.mightyapp.mighty.main.main.data.domain.GetUserLevelUseCase
import cc.mightyapp.mighty.main.main.data.domain.GetUserUseCase
import cc.mightyapp.mighty.main.main.data.entities.GetUserInput
import cc.mightyapp.mighty.main.workout.data.domain.GetUserFavoriteRoutinesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val getUserLevelUseCase: GetUserLevelUseCase,
    private val getUserFavoriteRoutinesUseCase: GetUserFavoriteRoutinesUseCase
) : ViewModel() {

    private val _user = MutableStateFlow(User())
    val user: StateFlow<User>
        get() = _user

    private val _level = MutableStateFlow(Level())

    val level: StateFlow<Level>
        get() = _level

    private val _favoriteRoutines = MutableStateFlow(listOf<Routine>())

    val favoriteRoutines: StateFlow<List<Routine>>
        get() = _favoriteRoutines

    private val _isDoneLoading = MutableStateFlow(user.value.isLoggedIn)
    val isDoneLoading: StateFlow<Boolean>
        get() = _isDoneLoading

    fun mainInit(userId: String, token: String) {
        loadUser(userId = userId, token = token)

        loadUserLevel(userId = userId)

//        loadUserFavoriteRoutines(userId = userId)
    }

    private fun loadUser(userId: String, token: String) {

        viewModelScope.launch {
            val user = withContext(Dispatchers.Default) {
                getUserUseCase(GetUserInput(userId = userId, token = token))
            }

            if (user is RequestResult.Success) _user.value = user.payload
        }
    }

    private fun loadUserLevel(userId: String) {
        viewModelScope.launch {
            val level = withContext(Dispatchers.Default) {
                getUserLevelUseCase(userId)
            }

            if (level is RequestResult.Success) _level.value = level.payload
        }
    }

    private fun loadUserFavoriteRoutines(userId: String) {
        viewModelScope.launch {
            val routines = withContext(Dispatchers.Default) {
                getUserFavoriteRoutinesUseCase(userId)
            }

            if (routines is RequestResult.Success) _favoriteRoutines.value = routines.payload
        }
    }
}