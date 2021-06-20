package cc.mightyapp.mighty.common.ui.composables.graphics

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import cc.mightyapp.mighty.R
import cc.mightyapp.mighty.common.data.fakes.OtherFakeInfo

@Preview
@Composable
fun XpGraphic(
    id: Int = R.mipmap.ic_xp_gold_foreground,
    contentDescription: String? = OtherFakeInfo.GoldXpTokenContentDescription
) {
    Image(
        painter = painterResource(id = id),
        contentDescription = contentDescription
    )
}