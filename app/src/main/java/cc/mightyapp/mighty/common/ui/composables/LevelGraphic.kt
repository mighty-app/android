package cc.mightyapp.mighty.common.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cc.mightyapp.mighty.main.main.data.entities.MightyUtil
import com.google.accompanist.coil.LocalImageLoader
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun LevelGraphic(
    graphicUri: String,
    contentDescription: String? = null,
    size: Int = 60,
    mightyUtil: MightyUtil
) {
    CompositionLocalProvider(LocalImageLoader provides mightyUtil.imageLoader) {

        Image(
            painter = rememberCoilPainter(
                request = graphicUri,
                fadeIn = true,
            ),
            contentDescription = contentDescription,
            modifier = Modifier.size(size.dp)
        )
    }
}