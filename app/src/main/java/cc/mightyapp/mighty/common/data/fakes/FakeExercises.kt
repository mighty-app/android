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
        muscles = listOf<Muscle>(FakeMuscles.Chest, FakeMuscles.Triceps, FakeMuscles.Shoulders),
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

    val Squat = Exercise(
        name = "Squat",
        type = ExerciseType.Lifting,
        equipment = FakeEquipment.Barbell,
        instructions = "Lorem ipsum",
        muscles = listOf<Muscle>(FakeMuscles.Quads, FakeMuscles.Glutes, FakeMuscles.Hamstrings),
        images = listOf(),
        xp = 5
    )

    val Deadlift = Exercise(
        name = "Deadlift",
        type = ExerciseType.Lifting,
        equipment = FakeEquipment.Barbell,
        instructions = "Lorem ipsum",
        muscles = listOf<Muscle>(FakeMuscles.Glutes, FakeMuscles.Hamstrings, FakeMuscles.Forearms),
        images = listOf(),
        xp = 5
    )

    val MilitaryPress = Exercise(
        name = "Military Press",
        type = ExerciseType.Lifting,
        equipment = FakeEquipment.Barbell,
        instructions = "Lorem ipsum",
        muscles = listOf<Muscle>(FakeMuscles.Shoulders),
        images = listOf(),
        xp = 5
    )

    val BarbellRow = Exercise(
        name = "Bench Press",
        type = ExerciseType.Lifting,
        equipment = FakeEquipment.Barbell,
        instructions = "Lorem ipsum",
        muscles = listOf<Muscle>(FakeMuscles.MiddleBack, FakeMuscles.Biceps),
        images = listOf(),
        xp = 5
    )
}