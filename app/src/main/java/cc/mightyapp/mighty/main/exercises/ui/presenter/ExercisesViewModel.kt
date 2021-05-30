package cc.mightyapp.mighty.main.exercises.ui.presenter

import androidx.lifecycle.ViewModel
import cc.mightyapp.mighty.common.data.models.Exercise
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExercisesViewModel @Inject constructor(
) : ViewModel() {

    val exercises = listOf<Exercise>()
}