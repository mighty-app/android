package cc.mightyapp.mighty.common.data.fakes

import cc.mightyapp.mighty.common.data.models.Achievement

object FakeAchievements {
    val Completed1Workout = Achievement(
        name = "1 Workout",
        description = "Completed 1 workout",
        graphic = "https://mighty-app.s3-us-west-1.amazonaws.com/badges/arcade_levels_1.svg"
    )

    val Completed3Workouts = Achievement(
        name = "3 Workouts",
        description = "Completed 3 workouts",
        graphic = "https://mighty-app.s3-us-west-1.amazonaws.com/badges/arcade_levels_3.svg"
    )

    val Completed10Workouts = Achievement(
        name = "10 Workouts",
        description = "Completed 10 workouts",
        graphic = "https://mighty-app.s3-us-west-1.amazonaws.com/badges/arcade_levels_10.svg"
    )

    val Completed20Workouts = Achievement(
        name = "20 Workouts",
        description = "Completed 20 workouts",
        graphic = "https://mighty-app.s3-us-west-1.amazonaws.com/badges/arcade_levels_20.svg"
    )

    val Completed50Workouts = Achievement(
        name = "50 Workouts",
        description = "Completed 50 workouts",
        graphic = "https://mighty-app.s3-us-west-1.amazonaws.com/badges/arcade_levels_50.svg"
    )
}