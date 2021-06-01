package cc.mightyapp.mighty.main.dashboard.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cc.mightyapp.mighty.common.data.fakes.FakeAchievements
import cc.mightyapp.mighty.common.data.models.RealAchievement
import cc.mightyapp.mighty.common.ui.composables.graphics.AchievementGraphic
import cc.mightyapp.mighty.main.main.data.entities.MightyUtil

@Composable
fun DashboardAchievements(
    achievements: List<RealAchievement>,
    mightyUtil: MightyUtil
) {
    Box(modifier = Modifier.padding(10.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            achievements.forEach { achievement ->
                AchievementGraphic(
                    graphicUri = achievement.achievement?.graphic
                        ?: FakeAchievements.Completed1Workout.graphic,
                    contentDescription = achievement.achievement?.description,
                    size = 120,
                    mightyUtil = mightyUtil
                )
            }
        }
    }
}