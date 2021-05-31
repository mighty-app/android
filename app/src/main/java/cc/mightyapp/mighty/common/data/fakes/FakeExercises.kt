package cc.mightyapp.mighty.common.data.fakes

import cc.mightyapp.mighty.common.data.models.Exercise
import cc.mightyapp.mighty.common.data.models.ExerciseType
import cc.mightyapp.mighty.common.data.models.Muscle

object FakeExercises {

    val BenchPress = Exercise(
        name = "Bench Press",
        type = ExerciseType.Lifting,
        equipment = FakeEquipment.Barbell,
        instructions = "Lorem ipsum",
        muscles = listOf<Muscle>(FakeMuscles.Chest),
        images = listOf(),
        xp = 5
    )

    val DumbbellCurl = Exercise(
        name = "Dumbbell Curl",
        type = ExerciseType.Lifting,
        equipment = FakeEquipment.Dumbbell,
        instructions = "Lorem ipsum",
        muscles = listOf(FakeMuscles.Biceps),
        images = listOf(),
        xp = 1
    )
}