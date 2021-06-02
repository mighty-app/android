package cc.mightyapp.mighty.main.startworkout.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import cc.mightyapp.mighty.common.data.fakes.FakeRoutines
import cc.mightyapp.mighty.common.data.models.Routine
import cc.mightyapp.mighty.main.main.data.entities.MightyUtil
import cc.mightyapp.mighty.main.main.ui.presenter.MainViewModel
import cc.mightyapp.mighty.main.startworkout.ui.presenter.StartWorkoutViewModel

@Composable
fun StartWorkoutContent(
    mainViewModel: MainViewModel,
    startWorkoutViewModel: StartWorkoutViewModel,
    mightyUtil: MightyUtil
) {
    val user by mainViewModel.user.collectAsState()
    val routines by startWorkoutViewModel.routines.collectAsState()

    Column {
        MyRoutinesContent(routines = routines)
    }


}


@Composable
fun MyRoutinesContent(routines: List<Routine>) {
    routines.forEach { routine ->
        RoutineCard(routine = routine)
    }
}

@Preview
@Composable
fun RoutineCard(routine: Routine = FakeRoutines.StrongLiftsA) {

    Surface {
        Column {
            Row {
                Text(text = routine.name)
            }

            Row {
                Text(text = routine.author.firstName)
                Text(text = routine.author.lastName)
            }

            Text(text = getNamesOfExercises(routine = routine))
            Row {
            }
        }
    }
}

private fun getNamesOfExercises(routine: Routine): String {
    val namesOfExercises = mutableListOf<String>()

    routine.templateSets.forEach { templateSet ->
        if (stringIsInList(
                string = templateSet.exercise.name,
                list = namesOfExercises
            ).not()
        ) {
            namesOfExercises.add(templateSet.exercise.name)
        }
    }

    return namesOfExercises.joinToString()
}

private fun stringIsInList(string: String, list: List<String>): Boolean {
    return string in list
}
