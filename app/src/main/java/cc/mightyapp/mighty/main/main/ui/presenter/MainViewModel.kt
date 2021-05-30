package cc.mightyapp.mighty.main.main.ui.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cc.mightyapp.mighty.common.data.entities.RequestResult
import cc.mightyapp.mighty.common.data.models.User
import cc.mightyapp.mighty.main.main.data.domain.GetUserUseCase
import cc.mightyapp.mighty.main.main.data.entities.GetUserInput
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _user = MutableStateFlow(User())
    val user: StateFlow<User>
        get() = _user

    fun mainInit(userId: String, token: String) {
        loadUser(userId = userId, token = token)
    }

    private fun loadUser(userId: String, token: String) {

        viewModelScope.launch {
            val user = withContext(Dispatchers.Default) {
                getUserUseCase(GetUserInput(userId = userId, token = token))
            }

            if (user is RequestResult.Success) _user.value = user.payload
        }
    }
}