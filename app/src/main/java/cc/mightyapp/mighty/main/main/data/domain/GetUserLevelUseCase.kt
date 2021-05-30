package cc.mightyapp.mighty.main.main.data.domain

import cc.mightyapp.mighty.common.data.domain.SuspendedUseCase
import cc.mightyapp.mighty.common.data.models.Level
import cc.mightyapp.mighty.di.IoDispatcher
import cc.mightyapp.mighty.main.main.data.repository.MainRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetUserLevelUseCase @Inject constructor(
    private val mainRepository: MainRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : SuspendedUseCase<String, Level>(ioDispatcher) {

    override suspend fun execute(parameters: String): Level =
        mainRepository.getUserLevel(parameters)
}