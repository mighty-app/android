package cc.mightyapp.mighty.common.data.api.services

import cc.mightyapp.mighty.common.data.models.Exercise

interface ExercisesService {
    suspend fun getExercises(): List<Exercise>
}