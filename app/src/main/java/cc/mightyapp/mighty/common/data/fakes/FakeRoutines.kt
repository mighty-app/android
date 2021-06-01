package cc.mightyapp.mighty.common.data.fakes

import cc.mightyapp.mighty.common.data.models.Routine
import cc.mightyapp.mighty.common.data.models.User

object FakeRoutines {
    val StrongLiftsA = Routine(
        name = "Strong Lifts A",
        description = "Squat, bench, row",
        author = FakeUsers.Mighty,
        templateSets = listOf(
            FakeTemplateSets.StrongLiftsASquatOne,
            FakeTemplateSets.StrongLiftsASquatTwo,
            FakeTemplateSets.StrongLiftsASquatThree,
            FakeTemplateSets.StrongLiftsASquatFour,
            FakeTemplateSets.StrongLiftsASquatFive,

            FakeTemplateSets.StrongLiftsABenchPressOne,
            FakeTemplateSets.StrongLiftsABenchPressTwo,
            FakeTemplateSets.StrongLiftsABenchPressThree,
            FakeTemplateSets.StrongLiftsABenchPressFour,
            FakeTemplateSets.StrongLiftsABenchPressFive,

            FakeTemplateSets.StrongLiftsABarbellRowOne,
            FakeTemplateSets.StrongLiftsABarbellRowTwo,
            FakeTemplateSets.StrongLiftsABarbellRowThree,
            FakeTemplateSets.StrongLiftsABarbellRowFour,
            FakeTemplateSets.StrongLiftsABarbellRowFive,
        ),
        timeTargetInMins = 45,
        usersFavoritedBy = listOf<User>()
    )
}