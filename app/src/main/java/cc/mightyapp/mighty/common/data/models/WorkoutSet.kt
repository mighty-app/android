package cc.mightyapp.mighty.common.data.models

import java.util.*

data class WorkoutSet(
    val user: User?,
    val reps: Int,
    val pounds: Int,
    val workout: Workout?,
    val exercise: Exercise?,
    val timestamp: Date?,
    val personalRecords: List<PersonalRecord>?,
    val numXPGained: Int?
)
