package cc.mightyapp.mighty.main.exercises.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cc.mightyapp.mighty.main.exercises.ui.presenter.ExercisesViewModel
import cc.mightyapp.mighty.main.main.ui.presenter.MainViewModel

@Composable
fun ExercisesContent(
    mainViewModel: MainViewModel,
    exercisesViewModel: ExercisesViewModel
) {
    val user by mainViewModel.user.collectAsState()
    val exercises by exercisesViewModel.exercises.collectAsState()

    return Column {
        Text("Exercises")
        Text(user.firstName)
        Text(user.lastName)
    }
}