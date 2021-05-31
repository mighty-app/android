package cc.mightyapp.mighty.common.ui.composables.graphics

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import cc.mightyapp.mighty.common.data.fakes.FakeExercises
import cc.mightyapp.mighty.common.data.fakes.FakeUsers
import cc.mightyapp.mighty.main.main.data.util.getXpGraphicId

@Preview
@Composable
fun XpGraphic(xp: Int = FakeExercises.BenchPress.xp) {
    Image(
        painter = painterResource(id = getXpGraphicId(xp = xp)),
        contentDescription = "$xp XP token"
    )
}