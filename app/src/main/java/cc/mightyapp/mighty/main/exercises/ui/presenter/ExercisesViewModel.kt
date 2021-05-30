package cc.mightyapp.mighty.main.exercises.ui.presenter

import androidx.lifecycle.ViewModel
import cc.mightyapp.mighty.common.data.models.Exercise
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ExercisesViewModel @Inject constructor(
) : ViewModel() {

    private val _exercises = MutableStateFlow(listOf<Exercise>())
    val exercises: StateFlow<List<Exercise>>
        get() = _exercises
}