package cc.mightyapp.mighty.common.data.api.services

import cc.mightyapp.mighty.common.data.api.MightyApi
import cc.mightyapp.mighty.common.data.models.Exercise
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RealExercisesService @Inject constructor(
    private val api: MightyApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ExercisesService {
    override suspend fun getExercises(): List<Exercise> =
        withContext(ioDispatcher) { api.getExercises() }
}