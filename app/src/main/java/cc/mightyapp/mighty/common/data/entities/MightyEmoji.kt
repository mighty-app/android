package cc.mightyapp.mighty.common.data.entities

data class Emoji(
    val unicodeStr: String
)

object MightyEmoji {

    val Lifting = Emoji(unicodeStr = "\uD83C\uDFCB")

    val Running = Emoji(unicodeStr = "\uD83C\uDFC3")

    val Biking = Emoji(unicodeStr = "\uD83D\uDEB4")

    val Plyometrics = Emoji(unicodeStr = "\uD83E\uDD38")

    val Stretching = Emoji(unicodeStr = "\uD83E\uDDD8")

    val Swimming = Emoji(unicodeStr = "\uD83C\uDFCA")

    val Flexing = Emoji(unicodeStr = "\uD83D\uDCAA")

    val Waving = Emoji(unicodeStr = "\uD83D\uDC4B")

    val RunningShirt = Emoji(unicodeStr = "\uD83C\uDFBD")
}
