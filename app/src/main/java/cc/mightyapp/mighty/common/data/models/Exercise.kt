package cc.mightyapp.mighty.common.data.models

data class Exercise(
    val name: String,
    val type: String,
    val equipment: Equipment,
    val instructions: String,
    val muscles: Muscle,
    val images: List<String>,
    val xp: Int
)
