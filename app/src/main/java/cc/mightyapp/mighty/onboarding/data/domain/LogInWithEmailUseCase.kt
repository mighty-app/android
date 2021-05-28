package cc.mightyapp.mighty.onboarding.data.domain

import cc.mightyapp.mighty.common.data.domain.SuspendedUseCase
import cc.mightyapp.mighty.di.IoDispatcher
import cc.mightyapp.mighty.onboarding.data.entities.LogInWithEmailInput
import cc.mightyapp.mighty.onboarding.data.entities.LogInWithEmailResponse
import cc.mightyapp.mighty.onboarding.data.repository.RealOnboardingRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class LogInWithEmailUseCase @Inject constructor(
    private val onboardingRepository: RealOnboardingRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : SuspendedUseCase<LogInWithEmailInput, LogInWithEmailResponse>(ioDispatcher) {
    override suspend fun execute(parameters: LogInWithEmailInput): LogInWithEmailResponse {
        return onboardingRepository.logInWithEmail(parameters)
    }
}