package cc.mightyapp.mighty.main.main.data.util

import cc.mightyapp.mighty.R
import cc.mightyapp.mighty.common.util.Do

fun getXpGraphicId(xp: Int): Int =
    Do exhaustive when (xp) {
        2 -> R.mipmap.ic_xp_green_foreground
        3 -> R.mipmap.ic_xp_blue_foreground
        5 -> R.mipmap.ic_xp_gold_foreground
        else -> R.mipmap.ic_xp_purple_foreground
    }
