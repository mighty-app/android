package cc.mightyapp.mighty.main.dashboard.ui.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import cc.mightyapp.mighty.common.data.models.RealAchievement
import cc.mightyapp.mighty.common.ui.composables.graphics.AchievementGraphic
import cc.mightyapp.mighty.main.main.data.entities.MightyUtil

@Composable
fun DashboardAchievements(
    achievements: List<RealAchievement>,
    mightyUtil: MightyUtil
) {
    Box {
        Row {
            achievements.forEach { achievement ->
                AchievementGraphic(
                    graphicUri = achievement.achievement?.graphic ?: "https://mighty-app.s3-us-west-1.amazonaws.com/badges/arcade_levels_1.svg",
                    contentDescription = achievement.achievement?.description ?: null,
                    size = 40,
                    mightyUtil = mightyUtil
                )
            }
        }
    }
}