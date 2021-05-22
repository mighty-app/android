package cc.mightyapp.mighty.domain.launcher

import cc.mightyapp.mighty.data.repository.auth.RealAuthRepository
import cc.mightyapp.mighty.di.IoDispatcher
import cc.mightyapp.mighty.domain.SuspendedUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class ValidateTokenUseCase @Inject constructor(
    private val authRepository: RealAuthRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : SuspendedUseCase<String, Boolean>(ioDispatcher) {
    override suspend fun execute(token: String): Boolean = authRepository.validateToken(token)
}