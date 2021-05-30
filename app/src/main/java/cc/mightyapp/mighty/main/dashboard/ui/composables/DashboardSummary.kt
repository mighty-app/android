package cc.mightyapp.mighty.main.dashboard.ui.composables

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
import cc.mightyapp.mighty.common.ui.composables.LevelGraphic
import cc.mightyapp.mighty.main.main.data.entities.MightyUtil

@Composable
fun DashboardSummary(
    levelGraphicUri: String,
    xp: Int,
    xpToNextLevel: Int,
    percentComplete: Int,
    mightyUtil: MightyUtil
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(MaterialTheme.colors.primaryVariant),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Column(modifier = Modifier.padding(8.dp)) {
            LevelGraphic(graphicUri = levelGraphicUri, size = 80, mightyUtil = mightyUtil)
        }

        Column(modifier = Modifier.padding(8.dp)) {
            ProgressBar(percentComplete = percentComplete)

            XpInfo(xp = xp, xpToNextLevel = xpToNextLevel)
        }
    }
}

@Preview
@Composable
fun ProgressBar(
    percentComplete: Int = 25
) {
    val width = 300.dp
    val height = 50.dp

    Box(
        modifier = Modifier
            .width(width)
            .height(height)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(MaterialTheme.colors.primary)
    ) {
        Box(
            modifier = Modifier
                .width(width = ((width * percentComplete) / 100))
                .height(height)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(MaterialTheme.colors.onPrimary)
        ) {
        }
    }

}

@Preview
@Composable
fun XpInfo(
    xp: Int = 25,
    xpToNextLevel: Int = 74
) {
    val width = 300.dp

    Row(
        modifier = Modifier.width(width),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$xpToNextLevel XP to next level!",
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "$xp XP",
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold
        )
    }
}