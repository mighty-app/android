package cc.mightyapp.mighty.common.ui.composables.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MightyChip(
    isSelected: Boolean = false,
    label: String = "Mighty Chip",
    emoji: String? = null,
    colorWhenSelected: Color = MaterialTheme.colors.secondary,
    colorWhenNotSelected: Color = MaterialTheme.colors.secondaryVariant,
) {
    Surface(
        modifier = Modifier.padding(8.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(
            width = 1.dp,
            color = when {
                isSelected -> colorWhenSelected
                else -> colorWhenNotSelected
            }
        )
    ) {
        Row(modifier = Modifier.padding(6.dp), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically ) {
            if (!emoji.isNullOrEmpty()) {
                Text(
                    text = emoji,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(2.dp)
                )
            }

            Text(
                text = label,
                style = MaterialTheme.typography.body2,
                color = Color.White,
                modifier = Modifier.padding(2.dp)
            )
        }
    }
}