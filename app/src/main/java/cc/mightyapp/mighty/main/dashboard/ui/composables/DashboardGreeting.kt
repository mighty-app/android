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

@Preview
@Composable
fun DashboardGreeting(
    firstName: String = "Mighty User"
) {
    Row {
        Text(text = "\uD83D\uDC4B", style = MaterialTheme.typography.h4)

        Spacer(modifier = Modifier.padding(2.dp))

        Text(
            text = "Hey, ${firstName}!",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold
        )
    }
}