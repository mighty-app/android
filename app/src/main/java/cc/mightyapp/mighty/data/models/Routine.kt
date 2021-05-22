package cc.mightyapp.mighty.data.models

data class Routine(
    val name: String,
    val description: String,
    val author: User,

    val coverImage: String,
    val program: Program,

    val templateSets: List<TemplateSet>,

    val ratingAvg: Float,
    val timeTargetInMins: Int,
    val usersFavoritedBy: List<User>
)
