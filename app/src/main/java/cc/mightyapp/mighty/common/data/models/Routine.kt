package cc.mightyapp.mighty.common.data.models

data class Routine(
    val name: String,
    val description: String,
    val author: User,

    val coverImage: String? = null,
    val program: Program? = null,

    val templateSets: List<TemplateSet>,

    val ratingAvg: Float? = null,
    val timeTargetInMins: Int,
    val usersFavoritedBy: List<User>
)
