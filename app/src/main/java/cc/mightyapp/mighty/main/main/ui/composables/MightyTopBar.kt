package cc.mightyapp.mighty.main.main.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MightyTopBar(title: Int) {
    TopAppBar(
        elevation = 6.dp,
        backgroundColor = MaterialTheme.colors.background
    ) {

        Text(
            text = stringResource(id = title),
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Black,
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterVertically)
        )
    }
}