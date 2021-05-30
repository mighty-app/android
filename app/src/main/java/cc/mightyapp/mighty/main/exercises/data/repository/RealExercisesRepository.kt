package cc.mightyapp.mighty.main.exercises.data.repository

import cc.mightyapp.mighty.common.data.api.services.ExercisesService
import cc.mightyapp.mighty.common.data.models.Exercise
import javax.inject.Inject

class RealExercisesRepository @Inject constructor(
    private val exercisesService: ExercisesService
) : ExercisesRepository {
    override suspend fun getExercises(): List<Exercise> = exercisesService.getExercises()
}