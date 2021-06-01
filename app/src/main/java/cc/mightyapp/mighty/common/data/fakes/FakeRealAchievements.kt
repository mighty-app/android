package cc.mightyapp.mighty.common.data.fakes

import cc.mightyapp.mighty.common.data.models.RealAchievement
import cc.mightyapp.mighty.common.data.models.User

object FakeRealAchievements {
    private val fakeTag : User = FakeUsers.Tag

    val TagCompleted1Workout = RealAchievement(
        achievement = FakeAchievements.Completed1Workout,
        user = fakeTag,
        workout = FakeWorkouts.TagWorkoutOne,
        set = null,
        timestamp = OtherFakeInfo.EndTime
    )

    val TagCompleted3Workouts = RealAchievement(
        achievement = FakeAchievements.Completed3Workouts,
        user = fakeTag,
        workout = FakeWorkouts.TagWorkoutThree,
        set = null,
        timestamp = OtherFakeInfo.EndTime
    )
}