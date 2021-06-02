package cc.mightyapp.mighty.common.data.fakes

import cc.mightyapp.mighty.common.data.models.User

object FakeUsers {
    val Mighty = User(
        id = "1",
        firstName = "Mighty",
        lastName = "App",
        email = "team@mightyapp.cc",
        isLoggedIn = true,
        isVerified = true,
        xp = 9899,
        poundsLiftedTotal = 100000000,
        level = FakeLevels.LevelOneHundred.id,
        achievements = listOf()
    )

    val Tag = User(
        id = "123",
        firstName = "Tag",
        lastName = "Ramotar",
        email = "tag@mightyapp.cc",
        isLoggedIn = true,
        isVerified = true,
        xp = 25,
        poundsLiftedTotal = 1000,
        level = FakeLevels.LevelOne.id,
        achievements = listOf(
            FakeRealAchievements.TagCompleted1Workout,
            FakeRealAchievements.TagCompleted3Workouts,
            FakeRealAchievements.TagCompleted10Workouts
        ),
        routinesFavorited = listOf(
            FakeRoutines.StrongLiftsA
        )
    )
}