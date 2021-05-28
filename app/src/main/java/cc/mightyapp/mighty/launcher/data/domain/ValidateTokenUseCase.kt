package cc.mightyapp.mighty.launcher.data.domain

import cc.mightyapp.mighty.common.data.domain.SuspendedUseCase
import cc.mightyapp.mighty.di.IoDispatcher
import cc.mightyapp.mighty.launcher.data.entities.ValidateTokenInput
import cc.mightyapp.mighty.launcher.data.entities.ValidateTokenResponse
import cc.mightyapp.mighty.launcher.data.repository.RealLauncherRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class ValidateTokenUseCase @Inject constructor(
    private val launcherRepository: RealLauncherRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : SuspendedUseCase<ValidateTokenInput, ValidateTokenResponse>(ioDispatcher) {
    override suspend fun execute(input: ValidateTokenInput): ValidateTokenResponse {
        return launcherRepository.validateToken(input)
    }
}