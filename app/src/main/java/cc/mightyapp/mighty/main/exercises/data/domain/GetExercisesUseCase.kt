package cc.mightyapp.mighty.main.exercises.data.domain

import cc.mightyapp.mighty.common.data.domain.SuspendedUseCase
import cc.mightyapp.mighty.common.data.models.Exercise
import cc.mightyapp.mighty.di.IoDispatcher
import cc.mightyapp.mighty.main.exercises.data.repository.ExercisesRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetExercisesUseCase @Inject constructor(
    private val exercisesRepository: ExercisesRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : SuspendedUseCase<Unit, List<Exercise>>(ioDispatcher) {

    override suspend fun execute(parameters: Unit): List<Exercise> =
        exercisesRepository.getExercises()
}