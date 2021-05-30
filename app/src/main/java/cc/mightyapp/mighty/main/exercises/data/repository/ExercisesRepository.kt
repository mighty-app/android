package cc.mightyapp.mighty.main.exercises.data.repository

import cc.mightyapp.mighty.common.data.models.Exercise

interface ExercisesRepository {
    suspend fun getExercises(): List<Exercise>
}