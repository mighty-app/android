package cc.mightyapp.mighty.main.exercises.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cc.mightyapp.mighty.common.data.fakes.FakeExercises
import cc.mightyapp.mighty.common.data.models.Exercise
import cc.mightyapp.mighty.common.ui.composables.components.MightyChip

@Preview
@Composable
fun ExerciseCard(
    exercise: Exercise = FakeExercises.BenchPress
) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(MaterialTheme.colors.surface)
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = exercise.name,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(4.dp)
            )

            Text(
                text = "${exercise.xp} XP",
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(4.dp)
            )

            Row {

                exercise.muscles.forEach { muscle ->
                    MightyChip(label = muscle.name)
                }

                MightyChip(label = exercise.equipment.name)

            }
        }
    }
}