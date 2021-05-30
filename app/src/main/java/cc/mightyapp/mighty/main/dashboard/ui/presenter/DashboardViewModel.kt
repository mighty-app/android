package cc.mightyapp.mighty.main.dashboard.ui.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cc.mightyapp.mighty.common.data.entities.RequestResult
import cc.mightyapp.mighty.common.data.models.Level
import cc.mightyapp.mighty.main.main.data.domain.GetUserLevelUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getUserLevelUseCase: GetUserLevelUseCase
) : ViewModel() {

    private val _level = MutableStateFlow(Level())
    val level: StateFlow<Level>
        get() = _level

    fun dashboardInit(levelId: String) {
        loadLevel(levelId = "607d965abd1c9fadaa88f2ff")
    }

    private fun loadLevel(levelId: String) {
        viewModelScope.launch {
            val level = withContext(Dispatchers.Default) { getUserLevelUseCase(levelId) }

            if (level is RequestResult.Success) _level.value = level.payload
        }
    }
}