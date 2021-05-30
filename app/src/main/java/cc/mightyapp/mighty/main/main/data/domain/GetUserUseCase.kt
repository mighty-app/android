package cc.mightyapp.mighty.main.main.data.domain

import cc.mightyapp.mighty.common.data.domain.SuspendedUseCase
import cc.mightyapp.mighty.common.data.entities.RequestResult
import cc.mightyapp.mighty.common.data.models.User
import cc.mightyapp.mighty.di.IoDispatcher
import cc.mightyapp.mighty.main.main.data.entities.GetUserInput
import cc.mightyapp.mighty.main.main.data.repository.MainRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val mainRepository: MainRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : SuspendedUseCase<GetUserInput, User>(ioDispatcher) {

    override suspend fun execute(parameters: GetUserInput):User =
        mainRepository.getUser(parameters)
}