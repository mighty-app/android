package cc.mightyapp.mighty.main.workout.data.util

import cc.mightyapp.mighty.R
import cc.mightyapp.mighty.common.data.models.Routine

interface RoutineUtil {
    fun getNameOfAuthor(): String

    fun getNamesOfExercises(): String

    fun getTotalXp(): Int

    fun getImageUri(authorId: String, totalXp: Int): Int

    fun getBgImageUri(authorId: String, totalXp: Int): Int
}

class RealRoutineUtil(
    private val routine: Routine
) : RoutineUtil {

    override fun getNameOfAuthor(): String {
        return "${routine.author.firstName} ${routine.author.lastName}"
    }

    override fun getNamesOfExercises(): String {
        val namesOfExercises = mutableListOf<String>()

        routine.templateSets.forEach { set ->
            if ((set.exercise.name in namesOfExercises).not()) {
                namesOfExercises.add(set.exercise.name)
            }
        }

        return namesOfExercises.joinToString()
    }

    override fun getTotalXp(): Int {
        var totalXp = 0

        routine.templateSets.forEach { set -> totalXp += set.exercise.xp }

        return totalXp
    }

    override fun getImageUri(authorId: String, totalXp: Int): Int {
        return when {
            authorId == "1" -> R.mipmap.ic_xp_gold_foreground
            totalXp in 0..50 -> R.mipmap.ic_xp_green_foreground
            totalXp in 50..100 -> R.mipmap.ic_xp_blue_foreground
            else -> R.mipmap.ic_xp_purple_foreground
        }
    }

    override fun getBgImageUri(authorId: String, totalXp: Int): Int {
        return when {
            authorId == "1" -> R.mipmap.ic_gold_bg_foreground
            totalXp in 0..50 -> R.mipmap.ic_xp_gold_foreground
            totalXp in 50..100 -> R.mipmap.ic_xp_gold_foreground
            else -> R.mipmap.ic_xp_gold_foreground
        }
    }


}