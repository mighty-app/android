package cc.mightyapp.mighty.common.data.entities


enum class MightyParam {
    EMAIL, PASSWORD
}

interface MightyError {
    val message: String
    val param: MightyParam
    val stackTrace: String
}
