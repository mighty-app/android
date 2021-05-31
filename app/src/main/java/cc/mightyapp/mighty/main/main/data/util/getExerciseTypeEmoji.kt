package cc.mightyapp.mighty.main.main.data.util

import cc.mightyapp.mighty.common.data.entities.MightyEmoji
import cc.mightyapp.mighty.common.data.models.ExerciseType
import cc.mightyapp.mighty.common.util.Do

fun getExerciseTypeEmoji(exerciseType: ExerciseType): String {
    return Do exhaustive when (exerciseType) {
        ExerciseType.Lifting -> MightyEmoji.Lifting.unicodeStr
        ExerciseType.Running -> MightyEmoji.Running.unicodeStr
        ExerciseType.Biking -> MightyEmoji.Biking.unicodeStr
        ExerciseType.Plyometrics -> MightyEmoji.Plyometrics.unicodeStr
        ExerciseType.Stretching -> MightyEmoji.Stretching.unicodeStr
        ExerciseType.Swimming -> MightyEmoji.Swimming.unicodeStr
    }
}