package cc.mightyapp.mighty.main.main.data.entities

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import cc.mightyapp.mighty.R
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.*

enum class MightyTabs(
    @StringRes val title: Int,
    val icon: ImageVector
) {
    Dashboard(R.string.tab_dashboard, Icons.Filled.Home),
    Workout(R.string.tab_start_workout, Icons.Filled.Build),
    Exercises(R.string.tab_exercises, Icons.Filled.Favorite),
}