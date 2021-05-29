package cc.mightyapp.mighty.common.util

object ObjectUtil {

    @JvmStatic
    fun getNonNullIdentityString(item: Any): String = buildString {
        append(item.javaClass.name)
        append('@')
        append(Integer.toHexString(System.identityHashCode(item)))
    }
}