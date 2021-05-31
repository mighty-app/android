package cc.mightyapp.mighty.main.exercises.ui.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cc.mightyapp.mighty.common.data.entities.RequestResult
import cc.mightyapp.mighty.common.data.fakes.FakeExercises
import cc.mightyapp.mighty.common.data.models.Exercise
import cc.mightyapp.mighty.main.exercises.data.domain.GetExercisesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ExercisesViewModel @Inject constructor(
    private val getExercisesUseCase: GetExercisesUseCase
) : ViewModel() {

    private val _exercises =
        MutableStateFlow(listOf(FakeExercises.BenchPress, FakeExercises.DumbbellCurl))
    val exercises: StateFlow<List<Exercise>>
        get() = _exercises

    init {
        loadExercises()
    }

    private fun loadExercises() {
        viewModelScope.launch {
            val exercises = withContext(Dispatchers.Default) { getExercisesUseCase(Unit) }

            if (exercises is RequestResult.Success && exercises.payload.isNotEmpty()) _exercises.value =
                exercises.payload
        }
    }
}