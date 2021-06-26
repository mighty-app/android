package cc.mightyapp.mighty.main.workout.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import cc.mightyapp.mighty.main.main.data.entities.MightyUtil
import cc.mightyapp.mighty.main.main.ui.presenter.MainViewModel


@Composable
fun EmptyWorkoutContent(
    mainViewModel: MainViewModel,
    mightyUtil: MightyUtil,
    navController: NavController
) {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.primary)) {
        Text(text = "Empty Workout")
    }
}