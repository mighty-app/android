package cc.mightyapp.mighty.common.data.models

import java.util.*

data class RealAchievement(
    val achievement: Achievement?,
    val user: User?,
    val workout: Workout?,
    val set: WorkoutSet?,
    val timestamp: Date
)
