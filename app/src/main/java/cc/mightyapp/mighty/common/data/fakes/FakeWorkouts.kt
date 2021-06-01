package cc.mightyapp.mighty.common.data.fakes

import cc.mightyapp.mighty.common.data.models.User
import cc.mightyapp.mighty.common.data.models.Workout

object FakeWorkouts {
    val fakeTag: User = FakeUsers.Tag

    val TagWorkoutOne = Workout(
        user = fakeTag,
        routine = FakeRoutines.StrongLiftsA,
        start = OtherFakeInfo.StartTime,
        end = OtherFakeInfo.EndTime,
        sets = listOf(FakeWorkoutSets.TagWorkoutOneSetOne)
    )

    val TagWorkoutThree = Workout(
        user = fakeTag,
        routine = FakeRoutines.StrongLiftsA,
        start = OtherFakeInfo.StartTime,
        end = OtherFakeInfo.EndTime,
        sets = listOf(FakeWorkoutSets.TagWorkoutThreeSetOne)
    )
}