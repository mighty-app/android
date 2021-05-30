package cc.mightyapp.mighty.main.main.data.util

import android.content.Context
import androidx.compose.runtime.Composable
import cc.mightyapp.mighty.main.main.data.entities.MightyUtil
import coil.ImageLoader
import coil.decode.SvgDecoder

@Composable
fun generateMightyUtil(context: Context): MightyUtil {
    val imageLoader = ImageLoader.Builder(context)
        .componentRegistry {
            add(SvgDecoder(context))
        }
        .build()

    return MightyUtil(
        imageLoader = imageLoader
    )
}