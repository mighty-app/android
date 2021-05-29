package cc.mightyapp.mighty.common.util

object Do {
    inline infix fun <reified T> exhaustive(any: T) = any
}