package cc.mightyapp.mighty.common.data.fakes

import cc.mightyapp.mighty.common.data.models.User
import cc.mightyapp.mighty.common.data.models.Workout
import cc.mightyapp.mighty.common.data.models.WorkoutSet

object FakeWorkoutSets {
    private val fakeTag: User = FakeUsers.Tag

    private val fakeTagWorkoutOne: Workout = FakeWorkouts.TagWorkoutOne
    private val fakeTagWorkoutThree: Workout = FakeWorkouts.TagWorkoutThree

    val TagWorkoutOneSetOne = WorkoutSet(
        user = fakeTag,
        reps = 5,
        pounds = 225,
        workout = fakeTagWorkoutOne,
        exercise = FakeExercises.Squat,
        timestamp = OtherFakeInfo.RandomTime,
        personalRecords = listOf(),
        numXPGained = FakeExercises.Squat.xp
    )

    val TagWorkoutThreeSetOne = WorkoutSet(
        user = fakeTag,
        reps = 5,
        pounds = 225,
        workout = fakeTagWorkoutThree,
        exercise = FakeExercises.Squat,
        timestamp = OtherFakeInfo.RandomTime,
        personalRecords = listOf(),
        numXPGained = FakeExercises.Squat.xp
    )
}