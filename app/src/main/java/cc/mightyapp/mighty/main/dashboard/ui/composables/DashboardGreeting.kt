package cc.mightyapp.mighty.main.dashboard.ui.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cc.mightyapp.mighty.common.data.entities.MightyEmoji
import cc.mightyapp.mighty.common.data.fakes.FakeUsers

@Preview
@Composable
fun DashboardGreeting(
    firstName: String = FakeUsers.Tag.firstName
) {
    Row {
        Text(text = MightyEmoji.Waving.unicodeStr, style = MaterialTheme.typography.h4)

        Spacer(modifier = Modifier.padding(2.dp))

        Text(
            text = "Hey, ${firstName}!",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold
        )
    }
}