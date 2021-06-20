package cc.mightyapp.mighty.main.workout.ui.composables

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cc.mightyapp.mighty.main.main.ui.presenter.MainViewModel
import cc.mightyapp.mighty.main.workout.ui.presenter.WorkoutViewModel

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun WorkoutNavGraph() {
    val workoutViewModel: WorkoutViewModel = viewModel()
    val navController = rememberNavController()
    val actions = remember(navController) { StartWorkoutActions(navController) }

    NavHost(navController = navController, startDestination = StartWorkoutDestinations.START) {
        composable(StartWorkoutDestinations.START_EMPTY_WORKOUT) {
            EmptyWorkoutContent(workoutViewModel = workoutViewModel)
        }
    }
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