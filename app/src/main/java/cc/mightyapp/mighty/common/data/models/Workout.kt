package cc.mightyapp.mighty.common.data.models

import java.util.*

data class Workout(
    val user: User?,
    val routine: Routine?,
    val start: Date,
    val end: Date,
    val sets: List<WorkoutSet>?
)
