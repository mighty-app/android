package cc.mightyapp.mighty.common.data.models

data class Exercise(
    val name: String,
    val type: ExerciseType,
    val equipment: Equipment,
    val instructions: String,
    val muscles: List<Muscle>,
    val images: List<String>?,
    val xp: Int
)
