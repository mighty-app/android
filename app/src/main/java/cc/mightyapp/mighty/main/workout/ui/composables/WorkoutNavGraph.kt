package cc.mightyapp.mighty.main.workout.ui.composables

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import cc.mightyapp.mighty.main.workout.ui.presenter.WorkoutViewModel

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun WorkoutNavGraph() {
    val workoutViewModel: WorkoutViewModel = viewModel()
}

class StartWorkoutActions(navController: NavHostController) {
    val onStartEmptyWorkout: () -> Unit = {
        navController.navigate(
            route = StartWorkoutDestinations.START_EMPTY_WORKOUT
        )
    }
}

object StartWorkoutDestinations {
    const val START = "START"
    const val START_EMPTY_WORKOUT = "START EMPTY WORKOUT"
}