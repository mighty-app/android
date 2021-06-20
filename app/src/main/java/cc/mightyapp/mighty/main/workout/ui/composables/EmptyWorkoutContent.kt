package cc.mightyapp.mighty.main.workout.ui.composables

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cc.mightyapp.mighty.main.main.ui.presenter.MainViewModel
import cc.mightyapp.mighty.main.workout.ui.presenter.WorkoutViewModel


@Composable
fun EmptyWorkoutContent(
    workoutViewModel: WorkoutViewModel
) {
    Text(text = "Empty Workout")
}