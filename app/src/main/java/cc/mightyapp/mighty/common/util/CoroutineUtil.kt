package cc.mightyapp.mighty.common.util

import kotlinx.coroutines.CoroutineName

fun Any.coroutineName() = CoroutineName(
    ObjectUtil.getNonNullIdentityString(this)
)