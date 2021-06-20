package cc.mightyapp.mighty.main.workout.data.domain

import cc.mightyapp.mighty.common.data.domain.SuspendedUseCase
import cc.mightyapp.mighty.common.data.models.Routine
import cc.mightyapp.mighty.di.IoDispatcher
import cc.mightyapp.mighty.main.main.data.repository.MainRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetUserFavoriteRoutinesUseCase @Inject constructor(
    private val mainRepository: MainRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : SuspendedUseCase<String, List<Routine>>(ioDispatcher) {

    override suspend fun execute(parameters: String): List<Routine> =
        mainRepository.getUserFavoriteRoutines(parameters)
}