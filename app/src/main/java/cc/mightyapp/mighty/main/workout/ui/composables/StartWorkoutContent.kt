package cc.mightyapp.mighty.main.workout.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import cc.mightyapp.mighty.common.data.fakes.FakeRoutines
import cc.mightyapp.mighty.common.data.models.Routine
import cc.mightyapp.mighty.common.ui.composables.graphics.XpGraphic
import cc.mightyapp.mighty.common.ui.theme.GoldHorizontalGradient
import cc.mightyapp.mighty.common.ui.theme.color_gold
import cc.mightyapp.mighty.common.ui.theme.color_gold_dark
import cc.mightyapp.mighty.common.ui.theme.color_gold_light
import cc.mightyapp.mighty.main.dashboard.data.entities.MightyDestination
import cc.mightyapp.mighty.main.main.data.entities.MightyUtil
import cc.mightyapp.mighty.main.main.ui.presenter.MainViewModel
import cc.mightyapp.mighty.main.workout.data.util.RealRoutineUtil

@Composable
fun StartWorkoutContent(
    mainViewModel: MainViewModel,
    mightyUtil: MightyUtil,
    onStartEmptyWorkout: () -> Unit
) {
    val user by mainViewModel.user.collectAsState()
    val favoriteRoutines by mainViewModel.favoriteRoutines.collectAsState()

    Column {

        Button(onClick = { onStartEmptyWorkout() }) {
            Text(text = "Start Empty Workout")
        }

        MyRoutinesContent(
            routines = listOf(
                FakeRoutines.StrongLiftsA,
                FakeRoutines.StrongLiftsA,
                FakeRoutines.StrongLiftsA,
                FakeRoutines.StrongLiftsA
            )
        )
    }
}


@Preview
@Composable
fun MyRoutinesContent(
    routines: List<Routine> = listOf(
        FakeRoutines.StrongLiftsA,
        FakeRoutines.StrongLiftsA,
        FakeRoutines.StrongLiftsA,
        FakeRoutines.StrongLiftsA,
    )
) {


    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
        routines.forEach { routine ->
            RoutineCard(routine = routine)
        }
    }
}

@Preview
@Composable
fun RoutineCard(routine: Routine = FakeRoutines.StrongLiftsA) {
    val width = 220.dp

    val routineUtil = RealRoutineUtil(routine = routine)
    val namesOfExercises = routineUtil.getNamesOfExercises()
    val totalXp = routineUtil.getTotalXp()
    val nameOfAuthor = routineUtil.getNameOfAuthor()

    Surface(
        modifier = Modifier
            .padding(6.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .width(width)
    ) {
        Column(
            modifier = Modifier
                .background(GoldHorizontalGradient)
                .padding(8.dp)
        ) {
            Row {
                Text(
                    text = routine.name,
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.Bold
                )
            }

            XpGraphic(
                id = routineUtil.getImageUri(
                    authorId = routine.author.id,
                    totalXp = routineUtil.getTotalXp()
                )
            )

            Text(text = "@$nameOfAuthor")
            Text(text = namesOfExercises)
            Text(text = "$totalXp XP")
        }
    }
}

