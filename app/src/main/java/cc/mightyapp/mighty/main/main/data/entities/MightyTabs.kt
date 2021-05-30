package cc.mightyapp.mighty.main.main.data.entities

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import cc.mightyapp.mighty.R
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.*

enum class MightyTabs(
    @StringRes val title: Int,
    val icon: ImageVector
) {
    Dashboard(R.string.tab_dashboard, FontAwesomeIcons.Solid.Rocket),
    Workout(R.string.tab_start_workout, FontAwesomeIcons.Solid.Plus),
    Exercises(R.string.tab_exercises, FontAwesomeIcons.Solid.Dumbbell),
}