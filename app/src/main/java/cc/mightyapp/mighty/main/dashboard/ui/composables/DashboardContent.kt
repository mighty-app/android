package cc.mightyapp.mighty.main.dashboard.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cc.mightyapp.mighty.common.data.fakes.FakeUsers
import cc.mightyapp.mighty.main.dashboard.ui.presenter.DashboardViewModel
import cc.mightyapp.mighty.main.main.data.entities.MightyUtil
import cc.mightyapp.mighty.main.main.ui.presenter.MainViewModel

@Composable
fun DashboardContent(
    mainViewModel: MainViewModel,
    dashboardViewModel: DashboardViewModel,
    mightyUtil: MightyUtil

) {
    val user by mainViewModel.user.collectAsState()
    val level by mainViewModel.level.collectAsState()

    if (user.isLoggedIn.not().or(level.graphic.isEmpty())) return

    Column {

        DashboardGreeting(
            firstName = user.firstName
        )

        DashboardSummary(
            levelGraphicUri = level.graphic,
            xp = user.xp,
            xpToNextLevel = level.maxXP - user.xp,
            percentComplete = 100 * (user.xp / level.maxXP),
            mightyUtil = mightyUtil
        )

        DashboardAchievements(
            achievements = FakeUsers.Tag.achievements,
            mightyUtil = mightyUtil
        )
    }
}